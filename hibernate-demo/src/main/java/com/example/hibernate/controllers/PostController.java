package com.example.hibernate.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hibernate.entities.Post;
import com.example.hibernate.services.PostService;

@RestController
@RequestMapping(path = "/post/api")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping(path = "/post-post")
	public ResponseEntity<Post> postPost(RequestEntity<Post> postData){
		Post p = postService.createPost(postData.getBody());
		return ResponseEntity.status(HttpStatus.CREATED).body(p);
	}
	
	@PostMapping(path = "/post-posts")
	public ResponseEntity<List<Post>> postPosts(RequestEntity<List<Post>> postDatas){
		List<Post> p = postService.createPosts(postDatas.getBody());
		return ResponseEntity.status(HttpStatus.CREATED).body(p);
	}
	
	@GetMapping(path = "/get-post/{id}")
	public ResponseEntity<Post> getPost(@PathVariable("id") int postId){
		Post p = postService.fetchPost(postId);
		return ResponseEntity.status(HttpStatus.OK).body(p);
	}
	
	@GetMapping(path = "/get-posts")
	public ResponseEntity<List<Post>> getPosts(){
		List<Post> p = postService.fetchPosts();
		return ResponseEntity.status(HttpStatus.OK).body(p);
	}
}
