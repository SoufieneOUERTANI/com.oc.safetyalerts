package com.oc.safetyalerts.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oc.safetyalerts.repository.PersonRepository;
import com.oc.safetyalerts.service.IPersonService;
import com.oc.safetyalerts.model.Person;


import lombok.Data;

@Data
@Service
public class PersonServiceImpl implements IPersonService {

	/*
	private PersonRepository personRepository;
	
	@Autowired
	public PersonServiceImpl(PersonRepository thePersonRepository) {
		personRepository = thePersonRepository;
	}
	*/
	
    @Autowired
    private PersonRepository PersonRepository;

	@Override
    public Optional<Person> getPerson(final long id) {
        return PersonRepository.findById(id);
    }

    @Override
    public Iterable<Person> getPersons() {
        return PersonRepository.findAll();
    }

    @Override
    public void deletePerson(final long id) {
        PersonRepository.deleteById(id);
    }

    @Override
    public Person savePerson(Person Person) {
        Person savedPerson = PersonRepository.save(Person);
        return savedPerson;
    }	

}
