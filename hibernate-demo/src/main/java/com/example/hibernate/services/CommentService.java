package com.example.hibernate.services;



import java.util.List;

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
	
	public List<Comment> createComments(List<Comment> comments){
		return (List<Comment>) commentRepository.saveAll(comments);
	}
	
	public Comment fetchComment(int id) {
		return commentRepository.findById(id).orElseThrow(()-> new RuntimeException("Resource not found!!"));
	}
	
	public List<Comment> fetchComments(){
		return (List<Comment>) commentRepository.findAll();
	}
}
