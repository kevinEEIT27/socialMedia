package com.sideproject.message.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class AbstractMessage {
	protected String content;
	@CreatedDate
	@Column(updatable = false)
	private LocalDate createdAt = LocalDate.now() ;
}
