package com.example.hibernate.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hibernate.entities.PersonDetail;
import com.example.hibernate.repositories.PersonDetailRepository;

@Service
public class PersonDetailService {
	
	@Autowired
	private PersonDetailRepository personDetailRepository;
	
	public PersonDetail createPersonDetail(PersonDetail p) {
		return personDetailRepository.save(p);
	}
	
	public List<PersonDetail> createPersonDetails(List<PersonDetail> pDetails){
		return (List<PersonDetail>) personDetailRepository.saveAll(pDetails);
	}
	
	public PersonDetail fetchPersonDetail(int id) {
		return personDetailRepository.findById(id).orElseThrow(()-> new RuntimeException("Resource not found!!"));
	}
	
	public List<PersonDetail> fetchPersonDetails(){
		return (List<PersonDetail>) personDetailRepository.findAll();
	}
}
