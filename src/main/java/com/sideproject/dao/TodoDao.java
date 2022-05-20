package com.sideproject.dao;

import com.sideproject.entity.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoDao extends CrudRepository<Todo, Integer> {

}
