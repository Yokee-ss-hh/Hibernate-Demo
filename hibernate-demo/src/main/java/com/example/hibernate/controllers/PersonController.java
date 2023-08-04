package com.example.hibernate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hibernate.entities.Person;
import com.example.hibernate.services.PersonService;

@RestController
@RequestMapping(path = "/person/api")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@PostMapping(path = "/post-person")
	public ResponseEntity<Person> postPerson(RequestEntity<Person> personData){
		Person p = personService.createPerson(personData.getBody());
		return ResponseEntity.status(HttpStatus.CREATED).body(p);
	}
	
	@GetMapping(path = "/get-person/{id}")
	public ResponseEntity<Person> getPerson(@PathVariable(value = "id") int personId){
		Person p = personService.fetchPerson(personId);
		return ResponseEntity.status(HttpStatus.OK).body(p);
	}
}
