package com.example.hibernate.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hibernate.entities.Author;
import com.example.hibernate.entities.Book;
import com.example.hibernate.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public Book createBook(Book boo) {
		List<Author> authors = boo.getAuthors();
		for(Author a: authors) {
			a.setBooks(List.of(boo));
		}
		return bookRepository.save(boo);
	}
	
	public List<Book> createBooks(List<Book> boos){
		for(Book b: boos) {
			List<Author> authors = b.getAuthors();
			for(Author a: authors) {
				a.setBooks(List.of(b));
			}
		}
		return (List<Book>) bookRepository.saveAll(boos);
	}
	
	public Book fetchBook(int id) {
		return bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Resource not found!!"));
	}
	
	public List<Book> fetchBooks(){
		return (List<Book>) bookRepository.findAll();
	}
}
