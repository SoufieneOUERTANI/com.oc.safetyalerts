package com.oc.safetyalerts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAdress;

	private String adress;

	/*
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,
			CascadeType.MERGE,
			CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinColumn(name = "idAdress")
	private List<Person> persons;

	public void addPerson(Person thePerson) {
		
		if (persons == null) {
			persons = new ArrayList<>();
		}
		
		persons.add(thePerson);
	}
	*/
	
	
	
}
