package com.example.hibernate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hibernate.entities.Comment;
import com.example.hibernate.services.CommentService;

@RestController
@RequestMapping(path = "/comment/api")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping(path = "/post-comment")
	public ResponseEntity<Comment> postComment(RequestEntity<Comment> c){
		Comment c1 = commentService.createComment(c.getBody());
		return ResponseEntity.status(HttpStatus.CREATED).body(c1);
	}
	
	@GetMapping(path = "/get-comment/{id}")
	public ResponseEntity<Comment> getComment(@PathVariable(value = "id") int commentId){
		Comment c = commentService.fetchComment(commentId);
		return ResponseEntity.status(HttpStatus.OK).body(c);
	}
}
