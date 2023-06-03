package com.sideproject.security.login;

import com.sideproject.user.entity.User;
import com.sideproject.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class SpringUserService implements UserDetailsService {
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String mobile) throws UsernameNotFoundException {

		try {
			User user = userService.getUserByMobile(mobile);
			return new SpringUser(user);
		} catch (Exception e) {
			throw new UsernameNotFoundException("Username is wrong.");
		}
	}
}