package com.oc.safetyalerts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oc.safetyalerts.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

}
