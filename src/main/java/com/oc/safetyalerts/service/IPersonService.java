package com.oc.safetyalerts.service;

import java.util.Optional;

import com.oc.safetyalerts.model.Person;

public interface IPersonService {

	Optional<Person> getPerson(long id);

	Iterable<Person> getPersons();

	void deletePerson(long id);

	Person savePerson(Person Person);

}
