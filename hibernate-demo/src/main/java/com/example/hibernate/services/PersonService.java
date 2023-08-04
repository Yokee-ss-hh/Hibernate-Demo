package com.example.hibernate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hibernate.entities.Person;
import com.example.hibernate.repositories.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public Person createPerson(Person p) {
		return personRepository.save(p);
	}
	
	public Person fetchPerson(int id) {
		return personRepository.findById(id).orElseThrow(() -> new RuntimeException("Resource not found!!"));
	}

}
