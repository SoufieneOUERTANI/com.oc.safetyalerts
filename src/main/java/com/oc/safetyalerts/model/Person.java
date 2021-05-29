package com.oc.safetyalerts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data 
@Entity
@Table
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPerson;
    
    private String city;
    
    private String email;
    
    private String firstName;
    
    private String lastName;
    
    private String phone;

    private String zip;

	public Person(String city, String email, String firstName, String lastName, String phone, String zip) {
		super();
		this.city = city;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.zip = zip;
	}
}
