package com.sideproject.user.dao;

import com.sideproject.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserID(Long userID);

	User findByMobile(String mobile);
	boolean existsByMobile(String mobile);
	User findByPassword(String password);

	@Override
	@RestResource(exported = false)
	void delete(User user);
}
