package com.example.hibernate.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "author_tbl")
public class Author {
	
	@Id
	@GeneratedValue
	@Column(name = "author_id")
	private Integer id;
	
	@Column(name = "author_name")
	private String name;
	
	@Column(name = "author_age")
	private Integer age;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "authors_books", 
			joinColumns = @JoinColumn(name="author_tbl_id"),
			inverseJoinColumns = @JoinColumn(name="book_tbl_id"))
	@JsonIgnoreProperties(value = "authors", allowSetters = true)
	private List<Book> books;

	public Author(Integer id, String name, Integer age, List<Book> books) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.books = books;
	}
	
	public Author() {}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", age=" + age + ", books=" + books + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
