package com.example.hibernate.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.hibernate.entities.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{

}
