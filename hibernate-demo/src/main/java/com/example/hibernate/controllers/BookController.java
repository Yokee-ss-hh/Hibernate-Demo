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

import com.example.hibernate.entities.Book;
import com.example.hibernate.services.BookService;

@RestController
@RequestMapping(path = "/book/api")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping(path = "/post-book")
	public ResponseEntity<Book> createBook(RequestEntity<Book> book){
		Book b = bookService.createBook(book.getBody());
		return ResponseEntity.status(HttpStatus.CREATED).body(b);
	}
	
	@PostMapping(path = "/post-books")
	public ResponseEntity<List<Book>> createBooks(RequestEntity<List<Book>> book){
		List<Book> b = bookService.createBooks(book.getBody());
		return ResponseEntity.status(HttpStatus.CREATED).body(b);
	}
	
	@GetMapping(path = "/get-book/{id}")
	public ResponseEntity<Book> getBook(@PathVariable(value = "id") int bookId){
		Book book = bookService.fetchBook(bookId);
		return ResponseEntity.status(HttpStatus.OK).body(book);
	}
	
	@GetMapping(path = "/get-books")
	public ResponseEntity<List<Book>> getBooks(){
		List<Book> books = bookService.fetchBooks();
		return ResponseEntity.status(HttpStatus.OK).body(books);
	}
	
}
