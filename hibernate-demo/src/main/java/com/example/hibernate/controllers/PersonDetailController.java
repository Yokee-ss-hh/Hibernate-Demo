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

import com.example.hibernate.entities.PersonDetail;
import com.example.hibernate.services.PersonDetailService;

@RestController
@RequestMapping(path = "/person-detail/api")
public class PersonDetailController {
	
	@Autowired
	private PersonDetailService personDetailService;
	
	@PostMapping(path = "/post-person-detail")
	public ResponseEntity<PersonDetail> postPersonDetail(RequestEntity<PersonDetail> personDetailData){
		PersonDetail p = personDetailService.createPersonDetail(personDetailData.getBody());
		return ResponseEntity.status(HttpStatus.CREATED).body(p);
	}
	
	@GetMapping(path = "/get-person-detail/{id}")
	public ResponseEntity<PersonDetail> getPersonDetail(@PathVariable(value = "id") int personDetailId){
		PersonDetail p = personDetailService.fetchPersonDetail(personDetailId);
		return ResponseEntity.status(HttpStatus.OK).body(p);
	}
}
