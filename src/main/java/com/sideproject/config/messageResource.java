package com.sideproject.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest")
@RestController
public class messageResource {

//	建立一個RestController 去mapping "/rest" 裡面的 message 會從Git 讀取。
	@Value("${message: Default Hello}")
	private String message;

	@GetMapping("/message")
	public String message() {
		return message;
	}
}
