package com.example.hibernate.entities;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "post_table")
public class Post {
	
	@Id
	@GeneratedValue
	@Column(name = "post_id")
	private Integer id;
	
	@Column(name = "post_name")
	private String name;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "post_created")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@JsonIgnoreProperties(value = "post", allowSetters = true)
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	private List<Comment> comments;
	
	public Post() {}

	public Post(Integer id, String name, LocalDateTime createdAt, List<Comment> comments) {
		super();
		this.id = id;
		this.name = name;
		this.createdAt = createdAt;
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", name=" + name + ", createdAt=" + createdAt + ", comments=" + comments + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
