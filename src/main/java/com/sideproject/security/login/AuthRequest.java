package com.sideproject.security.login;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AuthRequest {

	private String username;
	@NotBlank
	private String mobile;
	@NotBlank
	private String password;
}
