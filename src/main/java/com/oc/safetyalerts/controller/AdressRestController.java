package com.oc.safetyalerts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.oc.safetyalerts.model.Adress;
import com.oc.safetyalerts.service.IAdressService;

@RestController
public class AdressRestController {

	private IAdressService adressService;
	
	@Autowired
	public AdressRestController(IAdressService theAdressService) {
		adressService = theAdressService;
	}
	
	// expose "/adresses" and return list of adresses
	
	@GetMapping("/adresses")
	public List<Adress> getAdresses() {
		return (List<Adress>) adressService.getAdresses();
	}

	// add mapping for GET /adresses/{adressId}
	
	@GetMapping("/adresses/{adressId}")
	@ResponseStatus(code = HttpStatus.FOUND)
	public Optional<Adress> getAdress(@PathVariable long adressId) {
		
		Optional<Adress> theAdress = adressService.getAdress(adressId);
		
		if (theAdress == null) {
			throw new RuntimeException("Adress id not found - " + adressId);
		}
		
		return theAdress;
	}
	
	// add mapping for POST /adresses - add new adress
	
	@PostMapping("/adresses")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Adress addAdress(@RequestBody Adress theAdress) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		adressService.saveAdress(theAdress);
		return(theAdress);		
		
	}
	
	// add mapping for PUT /adresses - update existing adress
	
	@PutMapping("/adresses")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Adress updateAdress(@RequestBody Adress theAdress) {
		
		adressService.saveAdress(theAdress);
		return theAdress;
	}
	
	// add mapping for DELETE /adresses/{adressId} - delete adress
	
	@DeleteMapping("/adresses/{adressId}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public String deleteAdress(@PathVariable long adressId) {
		
		Optional<Adress> tempAdress = adressService.getAdress(adressId);
		
		// throw exception if null
		
		if (tempAdress == null) {
			throw new RuntimeException("Adress id not found - " + adressId);
		}
		
		adressService.deleteAdress(adressId);
		
		return "Deleted adress id - " + adressId;
	}

}
