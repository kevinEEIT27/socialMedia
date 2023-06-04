package com.sideproject.message.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class Post extends AbstractMessage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "postID", nullable = false)
	private Long postID;

	private Long userID;

	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "postID")
	@JsonIgnore
	private List<Comment> comments;

}
