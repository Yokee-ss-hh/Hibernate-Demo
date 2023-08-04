package com.example.hibernate.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comment_table")
public class Comment {
	
	@Id
	@GeneratedValue
	@Column(name = "comment_id")
	private Integer id;
	
	@Column(name = "post_comment")
	private String commentThread;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "post_fk")
	@JsonIgnoreProperties(value = "comments", allowSetters = true)
	private Post post;

	public Comment(Integer id, String commentThread, Post post) {
		super();
		this.id = id;
		this.commentThread = commentThread;
		this.post = post;
	}
	
	public Comment() {}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", commentThread=" + commentThread + ", post=" + post + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCommentThread() {
		return commentThread;
	}

	public void setCommentThread(String commentThread) {
		this.commentThread = commentThread;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
}
