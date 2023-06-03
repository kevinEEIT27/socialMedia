package com.sideproject.message.controller;

import com.sideproject.message.dao.CommentRepository;
import com.sideproject.message.dao.PostRepository;
import com.sideproject.message.entity.Comment;
import com.sideproject.message.entity.Post;
import com.sideproject.security.login.UserIdentity;
import com.sideproject.user.entity.User;
import com.sideproject.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping(value = "/api")
public class MessageController {

	@Autowired
	PostRepository postRepository;

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	private UserIdentity userIdentity;

	@Autowired
	private UserService userService;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/v1/post")
	public List<Post> getAll() {
		return postRepository.findAll();
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/v1/post", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Post post(@RequestBody Post post) {

		post.setUserID(userIdentity.getId());
		return postRepository.save(post);
	}

	@DeleteMapping(value = "/v1/post", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> deletePost(@RequestBody Post post) {

		Map<String, Object> response;
		if (Objects.equals(post.getUserID(), userIdentity.getId())) {
			postRepository.delete(post);
			response = Collections.singletonMap("success", true);
		} else {
			response = Collections.singletonMap("success", false);
		}
		return ResponseEntity.ok(response);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/v1/comment/{postId}")
	public Comment addComment(@PathVariable Long postId, @RequestBody Comment comment) {


		comment.setPostID(postId);
		Post post = postRepository.findByPostID(postId);
		userService.getUserByUser_id(userIdentity.getId());
		comment.setUserID(userIdentity.getId());
		// 保存评论到数据库
		return commentRepository.save(comment);
	}
}
