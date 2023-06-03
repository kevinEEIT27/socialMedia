package com.sideproject.user.controller;

import com.sideproject.user.dao.UserRepository;
import com.sideproject.user.dto.UserDto;
import com.sideproject.user.entity.User;
import com.sideproject.user.service.Impl.UserServiceImpl;
import com.sideproject.user.service.UserService;
import com.sideproject.util.SecurityUtils;
import com.sideproject.util.StringUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
public class UserController {

	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper modelMapper;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/v1/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User register(@RequestBody UserDto userDto) throws Exception {

		if (StringUtil.isNotEmpty(userDto.getPassword()) && StringUtil.isNotEmpty(userDto.getMobile())) {
			userDto.setPassword(SecurityUtils.encodePassword(userDto.getPassword()));
		} else {
			throw new MissingServletRequestParameterException("password", "String");
		}
		User u = modelMapper.map(userDto, User.class);
		return userService.save(u);
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/v1/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserDto> allUsers() throws Exception {

		List<User> all = userRepository.findAll();

		return all
			.stream()
			.map(user -> modelMapper.map(user, UserDto.class))
			.collect(Collectors.toList());
	}

	@PostMapping(value = "/v1/user/login", produces =  MediaType.APPLICATION_JSON_VALUE)
	public User login(@RequestBody UserDto userDto) throws Exception {

		User user = userService.getUserByPassword(userDto.getPassword());
		if (SecurityUtils.matchesPassword(user.getPassword(), user.getPassword())) {
			return user;
		} else {
			throw new RuntimeException("login fail");
		}

	}
}
