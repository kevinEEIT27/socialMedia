package com.sideproject.user.service.Impl;

import com.sideproject.user.dao.UserRepository;
import com.sideproject.user.entity.User;
import com.sideproject.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User getUserByUser_id(Long userID) {
		return userRepository.findByUserID(userID);
	}

	@Override
	public User getUserByPassword(String password) {
		return userRepository.findByPassword(password);
	}

	@Override
	public User getUserByMobile(String mobile) {
		return userRepository.findByMobile(mobile);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> fineAll() {
		return userRepository.findAll();
	}

	@Override
	public void deleteUserByPrimaryKey(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public Boolean mobileExists(String mobile) {
		return userRepository.existsByMobile(mobile);
	}
}
