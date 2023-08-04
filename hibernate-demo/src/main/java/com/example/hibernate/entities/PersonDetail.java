package com.example.hibernate.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "person_detail_table")
public class PersonDetail {
	
	@Id
	@GeneratedValue
	@Column(name = "person_detail_id")
	private Integer id;
	
	@Column(name = "person_city")
	private String city;
	
	@JsonIgnoreProperties(value = "details", allowSetters = true)
	@OneToOne(mappedBy = "details", cascade = CascadeType.ALL)
	private Person person;

	public PersonDetail(Integer id, String city, Person person) {
		super();
		this.id = id;
		this.city = city;
		this.person = person;
	}
	
	public PersonDetail() {}

	@Override
	public String toString() {
		return "PersonDetail [id=" + id + ", city=" + city + ", person=" + person + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
		person.setDetails(this);
	}
}
