package com.axsos.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axsos.mvc.models.Ninja;
import com.axsos.mvc.repos.NinjaRepo;

@Service
public class NinjaServ {
	@Autowired
	NinjaRepo ninjaRepo;

	public List<Ninja> findAllNinjas() {
		return ninjaRepo.findAll();
	}
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
}
