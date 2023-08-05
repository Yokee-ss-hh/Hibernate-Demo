package com.example.hibernate.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.hibernate.entities.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer>{

}
