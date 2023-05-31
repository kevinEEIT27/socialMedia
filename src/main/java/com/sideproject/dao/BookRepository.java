package com.sideproject.dao;

import com.sideproject.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface BookRepository extends JpaRepository<Book, Integer> {

	@Override
	@RestResource(exported = false)
	void delete(Book t);
}
