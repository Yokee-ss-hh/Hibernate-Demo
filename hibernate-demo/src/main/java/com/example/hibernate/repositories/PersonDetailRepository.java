package com.example.hibernate.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.hibernate.entities.PersonDetail;

@Repository
public interface PersonDetailRepository extends CrudRepository<PersonDetail, Integer>{

}
