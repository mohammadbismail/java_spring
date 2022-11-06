package com.axsos.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axsos.mvc.models.Travel;
import com.axsos.mvc.repos.TravelRepo;

@Service
public class TravelService {
	@Autowired
	TravelRepo travelRepo;
	
	// Return all travels from DB
	public List<Travel> allTravels(){
		return travelRepo.findAll();	
	}
	// create travel in DB
	public Travel createTravel(Travel travel) {
		return travelRepo.save(travel);
	}
	// finding travel in DB
	public Travel findTravel(Long id) {
		Optional<Travel> optionalTravel = travelRepo.findById(id);
		if (optionalTravel.isPresent())
			return optionalTravel.get();
		else
			return null;
	}
	// updating an existing travel in DB
	public Travel updateTravel(Long id) {
		return travelRepo.save(this.findTravel(id));
	}
	// deleting a travel from DB
	public void deleteTravel(Long id) {
		travelRepo.deleteById(id);
	}
}
