package com.sideproject.user.service;

import com.sideproject.user.entity.User;

import java.util.List;


public interface UserService {
	User getUserByUserID(Long userID);

	User getUserByPassword(String password);

	User getUserByMobile(String mobile);

	User save(User user);

	List<User> fineAll();

	void deleteUserByPrimaryKey(Long id);

	Boolean mobileExists(String mobile);
}
