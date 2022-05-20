package com.sideproject;

import com.sideproject.dao.TodoDao;
import com.sideproject.entity.Todo;
import com.sideproject.service.TodoService;
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
	TodoService todoService;

	@MockBean
	TodoDao todoDao;

	@Test
	void contextLoads() {
	}

	@Test
	public void whenGetId_ThenSetId() {
		Todo todo = new Todo();
		todo.setId(1);
		Integer expected = 1;
		Integer actual = todo.getId();

		assertEquals(expected, actual);
	}

	@Test
	public void whenGetTask_ThenSetTask() {
		Todo todo = new Todo();
		todo.setTask("洗衣服");
		String expected = "洗衣服";
		String actual = todo.getTask();

		assertEquals(expected, actual);
	}

	@Test
	public void whenSetTask_ThenGetTask() {
		Todo todo = new Todo();
		todo.setStatus(2);
		Integer expected = 2;
		Integer actual = todo.getStatus();

		assertEquals(expected, actual);
	}

	@Test
	public void testGetTodos () {
		// [Arrange] 預期資料
		List<Todo> expectedTodosList = new ArrayList();
		Todo todo = new Todo();
		todo.setId(1);
		todo.setTask("洗衣服");
		todo.setStatus(1);
		expectedTodosList.add(todo);

		// 定義模擬呼叫todoDao.findAll() 要回傳的預設結果
		Mockito.when(todoDao.findAll()).thenReturn(expectedTodosList);

		// [Act]操作todoService.getTodos();
		Iterable<Todo> actualTodoList = todoService.getTodos();

		// [Assert] 預期與實際的資料
		assertEquals(expectedTodosList, actualTodoList);
	}
}
