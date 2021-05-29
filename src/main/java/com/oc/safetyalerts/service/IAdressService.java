package com.oc.safetyalerts.service;

import java.util.Optional;

import com.oc.safetyalerts.model.Adress;

public interface IAdressService {

	//Optional<Adress> getAdress(long id);
	Optional<Adress> getAdress(String id);

	Iterable<Adress> getAdresses();

	//void deleteAdress(long id);
	void deleteAdress(String id);

	Adress saveAdress(Adress Adress);
	
}
