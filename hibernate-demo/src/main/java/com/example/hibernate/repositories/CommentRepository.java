package com.example.hibernate.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.hibernate.entities.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer>{

}
