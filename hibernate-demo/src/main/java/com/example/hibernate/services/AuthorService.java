package com.example.hibernate.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hibernate.entities.Author;
import com.example.hibernate.repositories.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	public Author createAuthor(Author auth) {
		return authorRepository.save(auth);
	}
	
	public List<Author> createAuthors(List<Author> auths){
		return (List<Author>) authorRepository.saveAll(auths);
	}
	
	public Author fetchAuthor(int id) {
		return authorRepository.findById(id).orElseThrow(()-> new RuntimeException("Resource not found!!"));
	}
	
	public List<Author> fetchAuthors(){
		return (List<Author>) authorRepository.findAll();
	}
}
