package com.oc.safetyalerts.service;

import java.util.Optional;

import com.oc.safetyalerts.model.Adress;

public interface IAdressService {

	Optional<Adress> getAdress(long id);

	Iterable<Adress> getAdresses();

	void deleteAdress(long id);

	Adress saveAdress(Adress Adress);
	
}
