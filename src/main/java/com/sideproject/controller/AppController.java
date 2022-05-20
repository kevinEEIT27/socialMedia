package com.sideproject.controller;

import com.sideproject.entity.Member;
import com.sideproject.entity.Todo;
import com.sideproject.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

	@Autowired
	TodoService todoService;

	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("hello", "Hello World");

		return "hello"; // 要導入的html
	}

	@GetMapping("/member/form")
	public String memberForm(Model model) {

		Member member = new Member();
		model.addAttribute("member", member);

		return "member/from";
	}

	@PostMapping("/member/add")
	public String memberAddSuccess(@ModelAttribute Member member, Model model) {

		model.addAttribute("member", member);

		return "member/addSuccess";
	}

	@GetMapping("/todo")
	public String getTodos(Model model) {
		Iterable<Todo> todoList = todoService.getTodos();
		model.addAttribute("todolist", todoList);
		Todo todo = new Todo();
		model.addAttribute("todoObject", todo);
		return "todolist";
	}
	@PostMapping("/todo")
	public String createTodo(@ModelAttribute Todo todo, Model model) {
		Iterable<Todo> allTodoList = todoService.createTodo(todo);
		Todo emptyTodo = new Todo();
		model.addAttribute("todolist", allTodoList);
		model.addAttribute("todoObject", emptyTodo);
		return "todolist";
	}
}
