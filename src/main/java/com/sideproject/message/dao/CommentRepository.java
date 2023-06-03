package com.sideproject.message.dao;

import com.sideproject.message.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface CommentRepository  extends JpaRepository<Comment, Long> {
}
