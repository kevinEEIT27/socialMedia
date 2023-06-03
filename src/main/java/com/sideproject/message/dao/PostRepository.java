package com.sideproject.message.dao;

import com.sideproject.message.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;


@RestResource
public interface PostRepository extends JpaRepository<Post, Long> {

	Post findByPostID(Long postID);

}
