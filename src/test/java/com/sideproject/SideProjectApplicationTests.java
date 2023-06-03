package com.sideproject;

import com.sideproject.user.dao.UserRepository;
import com.sideproject.user.entity.User;
import com.sideproject.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SideProjectApplicationTests {

	@Autowired
	UserService userService;

	@MockBean
	UserRepository userRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void whenGetId_ThenSetId() {
		User user  = new User();
		user.setUserID(1L);
		Long expected = 1L;
		Long actual = user.getUserID();

		assertEquals(expected, actual);
	}

	@Test
	public void whenGetTask_ThenSetTask() {
		User user  = new User();
		user.setName("KAO");
		String expected = "KAo";
		String actual = user.getName();

		assertEquals(expected, actual);
	}


	@Test
	public void testGetTodos () {
		// [Arrange] 預期資料
		List<User> expectedUsers = new ArrayList();
		User user  = new User();
		user.setUserID(1l);
		user.setName("KAO");
		user.setEmail("gmail");
		expectedUsers.add(user);

		// 定義模擬呼叫todoDao.findAll() 要回傳的預設結果
		Mockito.when(userService.fineAll()).thenReturn(expectedUsers);

		// [Act]操作todoService.getTodos();
		Iterable<User> actualUsers = userService.fineAll();

		// [Assert] 預期與實際的資料
		assertEquals(expectedUsers, actualUsers);
	}
}
