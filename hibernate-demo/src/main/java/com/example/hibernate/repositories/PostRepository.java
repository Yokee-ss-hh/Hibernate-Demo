package com.example.hibernate.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.hibernate.entities.Post;


@Repository
public interface PostRepository extends CrudRepository<Post, Integer>{

}
