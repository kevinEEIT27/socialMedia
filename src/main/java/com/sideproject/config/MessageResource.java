package com.sideproject.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MessageResource {

	//	建立一個RestController 去mapping "/rest" 裡面的 message 會從Git 讀取。
	@Value("${sideProject.message: default}")
	private String message;

	@GetMapping("/message")
	public String message() {
		return message;
	}
}
