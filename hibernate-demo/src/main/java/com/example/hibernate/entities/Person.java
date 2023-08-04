package com.example.hibernate.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "person_table")
public class Person {
	
	@Id
	@GeneratedValue
	@Column(name = "person_id")
	private Integer id;
	
	@Column(name = "person_name")
	private String name;
	
	@Column(name = "person_age")
	private Integer age;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "person_detail_fk")
	@JsonIgnoreProperties(value = "person", allowSetters = true)
	private PersonDetail details;

	public Person(Integer id, String name, Integer age, PersonDetail details) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.details = details;
	}
	
	public Person() {}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", details=" + details + "]";
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

	public PersonDetail getDetails() {
		return details;
	}

	public void setDetails(PersonDetail details) {
		this.details = details;
	}
}
