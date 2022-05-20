package com.sideproject.controller;

import com.sideproject.entity.Todo;
import com.sideproject.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

	@Autowired
	TodoService todoService;

	@GetMapping("/todos")
	public Iterable<Todo> getTodoList () {
		return todoService.getTodos();
	}

	@PutMapping("/todos/{id}")
	public void updateTodo(@PathVariable Integer id, @RequestBody Todo todo) {
		todoService.updateTodo(id ,todo);
	}

	@DeleteMapping("/todos/{id}")
	public void deleteTodo(@PathVariable Integer id) {
		todoService.deleteTodo(id);
	}
}
