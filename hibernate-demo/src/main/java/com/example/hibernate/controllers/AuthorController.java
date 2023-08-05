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

import com.example.hibernate.entities.Author;
import com.example.hibernate.services.AuthorService;

@RestController
@RequestMapping("/author/api")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@PostMapping(path = "/post-author")
	public ResponseEntity<Author> createAuthor(RequestEntity<Author> author){
		Author authorResponse = authorService.createAuthor(author.getBody());
		return ResponseEntity.status(HttpStatus.CREATED).body(authorResponse);
	}
	
	@PostMapping(path = "/post-authors")
	public ResponseEntity<List<Author>> createAuthors(RequestEntity<List<Author>> author){
		List<Author> authorResponse = authorService.createAuthors(author.getBody());
		return ResponseEntity.status(HttpStatus.CREATED).body(authorResponse);
	}
	
	@GetMapping(path = "/get-author/{id}")
	public ResponseEntity<Author> getAuthor(@PathVariable(value = "id") int authorId){
		Author author = authorService.fetchAuthor(authorId);
		return ResponseEntity.status(HttpStatus.OK).body(author);
	}
	
	@GetMapping(path = "/get-authors")
	public ResponseEntity<List<Author>> getAuthors(){
		List<Author> authors = authorService.fetchAuthors();
		return ResponseEntity.status(HttpStatus.OK).body(authors);
	}
}
