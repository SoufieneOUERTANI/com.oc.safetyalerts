package com.oc.safetyalerts.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="PERSON")
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
    
    
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,
			CascadeType.MERGE,
			CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinColumn(name = "idAdress")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Adress adress;

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
