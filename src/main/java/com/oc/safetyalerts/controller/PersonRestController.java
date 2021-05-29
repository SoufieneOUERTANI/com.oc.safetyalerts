package com.oc.safetyalerts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oc.safetyalerts.model.Person;
import com.oc.safetyalerts.service.IPersonService;

/*
http://localhost:8080/person 
Cet endpoint permettra d’effectuer les actions suivantes via Post/Put/Delete avec http : 
● ajouter une nouvelle personne ; 
● mettre à jour une personne existante (pour le moment, supposons que le prénom et le nom de famille ne changent pas, mais que les autres champs peuvent être modifiés) ; 
● supprimer une personne (utilisez une combinaison de prénom et de nom comme identificateur unique). 
 */

@RestController
public class PersonRestController {

	private IPersonService personService;
	
	@Autowired
	public PersonRestController(IPersonService thePersonService) {
		personService = thePersonService;
	}
	
	// expose "/persons" and return list of persons
	
	@GetMapping("/persons")
	public List<Person> getPersons() {
		return (List<Person>) personService.getPersons();
	}

	// add mapping for GET /persons/{personId}
	
	@GetMapping("/persons/{personId}")
	public Optional<Person> getPerson(@PathVariable long personId) {
		
		Optional<Person> thePerson = personService.getPerson(personId);
		
		if (thePerson == null) {
			throw new RuntimeException("Person id not found - " + personId);
		}
		
		return thePerson;
	}
	
	// add mapping for POST /persons - add new person
	
	@PostMapping("/persons")
	public Person addPerson(@RequestBody Person thePerson) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		//thePerson.setIdPerson(0);
		
		personService.savePerson(thePerson);
		
		return thePerson;
	}
	
	// add mapping for PUT /persons - update existing person
	
	@PutMapping("/persons")
	public Person updatePerson(@RequestBody Person thePerson) {
		
		thePerson = personService.savePerson(thePerson);
		
		return thePerson;
	}
	
	// add mapping for DELETE /persons/{personId} - delete person
	
	@DeleteMapping("/persons/{personId}")
	public String deletePerson(@PathVariable long personId) {
		
		Optional<Person> tempPerson = personService.getPerson(personId);
		
		// throw exception if null
		
		if (tempPerson == null) {
			throw new RuntimeException("Person id not found - " + personId);
		}
		
		personService.deletePerson(personId);
		
		return "Deleted person id - " + personId;
	}

}
