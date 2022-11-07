package com.axsos.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axsos.mvc.models.Dojo;
import com.axsos.mvc.repos.DojoRepo;

@Service
public class DojoServ {
	@Autowired
	DojoRepo dojoRepo;
	
	public List<Dojo> allDojos(){
		return dojoRepo.findAll();
	}
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> dojoFromDb = dojoRepo.findById(id);
		if (dojoFromDb.isPresent()) {
			return dojoFromDb.get();
		}
		else {
			return null;
		}
	}
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
}
