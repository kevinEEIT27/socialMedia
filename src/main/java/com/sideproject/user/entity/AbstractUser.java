package com.sideproject.user.entity;

import lombok.Data;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class AbstractUser  {

  String name;
  String email;

}