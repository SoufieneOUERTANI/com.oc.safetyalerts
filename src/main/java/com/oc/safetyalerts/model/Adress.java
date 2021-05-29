package com.oc.safetyalerts.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ADRESS")
public class Adress {

	@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private long idAdress;
	private String idAdress;

	//private String adress;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,
			CascadeType.MERGE,
			CascadeType.DETACH,
			CascadeType.REFRESH }, mappedBy = "adress")
	private List<Person> persons;

	public void addPerson(Person thePerson) {
		
		if (persons == null) {
			persons = new ArrayList<>();
		}
		
		persons.add(thePerson);
	}
	
	
	
}
