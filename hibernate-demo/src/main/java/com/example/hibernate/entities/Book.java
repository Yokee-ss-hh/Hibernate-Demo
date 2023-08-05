package com.example.hibernate.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "book_tbl")
public class Book {
	
	@Id
	@GeneratedValue
	@Column(name = "book_id")
	private Integer id;
	
	@Column(name = "book_name")
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "pages_count")
	private Integer pages;
	
	public Book(Integer id, String name, Integer pages, List<Author> authors) {
		super();
		this.id = id;
		this.name = name;
		this.pages = pages;
		this.authors = authors;
	}

	@ManyToMany(mappedBy = "books", cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = "books", allowSetters = true)
	private List<Author> authors;

	public Book(Integer id, Integer pages, List<Author> authors) {
		super();
		this.id = id;
		this.pages = pages;
		this.authors = authors;
	}
	
	public Book() {}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", pages=" + pages + ", authors=" + authors + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
}
