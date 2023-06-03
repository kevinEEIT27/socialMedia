package com.sideproject.user.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Entity
public class User extends AbstractUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userID", nullable = false)
	private Long userID;
	@NotEmpty(message = "user password should not be empty")
	private String password;
	private String coverImage;
	private String biography;
	@NotEmpty(message = "user mobile should not be empty")
	@Column(unique = true)
	private String mobile;
}
