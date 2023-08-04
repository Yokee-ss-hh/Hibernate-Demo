package com.example.hibernate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hibernate.entities.Post;
import com.example.hibernate.repositories.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public Post createPost(Post p) {
		p.getComments().forEach(a -> a.setPost(p));
		return postRepository.save(p);
	}
	
	public Post fetchPost(int id) {
		return postRepository.findById(id).orElseThrow(()-> new RuntimeException("Resource not found!!"));
	}
}
