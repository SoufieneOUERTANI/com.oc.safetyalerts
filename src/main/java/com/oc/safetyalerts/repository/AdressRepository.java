package com.oc.safetyalerts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oc.safetyalerts.model.Adress;

@Repository
//public interface AdressRepository extends CrudRepository<Adress, Long> {
public interface AdressRepository extends CrudRepository<Adress, String> {


}
