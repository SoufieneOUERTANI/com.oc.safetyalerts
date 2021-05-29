package com.oc.safetyalerts.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oc.safetyalerts.repository.AdressRepository;
import com.oc.safetyalerts.service.IAdressService;
import com.oc.safetyalerts.model.Adress;


import lombok.Data;

@Data
@Service
public class AdressServiceImpl implements IAdressService {
	
	@Autowired
    private AdressRepository adressRepository;
    
    /*
	@Autowired
	public AdressServiceImpl(AdressRepository theAdressRepository) {
		adressRepository = theAdressRepository;
	}
    */
	

	@Override
    public Optional<Adress> getAdress(final long id) {
        return adressRepository.findById(id);
    }

	@Override
    public Iterable<Adress> getAdresses() {
        return adressRepository.findAll();
    }

	@Override
    public void deleteAdress(final long id) {
        adressRepository.deleteById(id);
    }

	@Override
	public Adress saveAdress(Adress adress) {
        Adress savedAdress = adressRepository.save(adress);
        System.out.println("savedAdress.toString() => "+savedAdress.toString());
        return savedAdress;
    }
	
}
