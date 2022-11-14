package com.axsos.mvc.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axsos.mvc.repositories.appRepository;

@Service
public class appService {
	@Autowired
	appRepository appRepo;
	
//	public Country findCountry(Long id) {
//		Optional<Country> country = appRepo.findById(id);
//		if (country.isPresent()) {
//			return country.get();
//		}
//		else {
//			return null;
//		}
//	}
public List<Object[]> q1(){
		return appRepo.q1();
	} 
public List<Object[]> q2(){
	return appRepo.q2();
} 
public List<Object[]> q3(){
	return appRepo.q3();
} 
}
