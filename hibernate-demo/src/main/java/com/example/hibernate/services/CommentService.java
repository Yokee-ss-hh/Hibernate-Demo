package com.example.hibernate.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hibernate.entities.Comment;
import com.example.hibernate.repositories.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	public Comment createComment(Comment c) {
		return commentRepository.save(c);
	}
	
	public Comment fetchComment(int id) {
		return commentRepository.findById(id).orElseThrow(()-> new RuntimeException("Resource not found!!"));
	}
}
