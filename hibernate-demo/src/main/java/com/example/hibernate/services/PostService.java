package com.example.hibernate.services;

import java.util.List;

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
	
	public List<Post> createPosts(List<Post> posts){
		for(Post p: posts) {
			p.getComments().forEach(a -> a.setPost(p));
		}
		return (List<Post>) postRepository.saveAll(posts);
	}
	
	public Post fetchPost(int id) {
		return postRepository.findById(id).orElseThrow(()-> new RuntimeException("Resource not found!!"));
	}
	
	public List<Post> fetchPosts(){
		return (List<Post>) postRepository.findAll();
	}
}
