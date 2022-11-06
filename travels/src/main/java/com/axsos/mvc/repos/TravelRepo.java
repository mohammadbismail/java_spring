package com.axsos.mvc.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.mvc.models.Travel;

@Repository
public interface TravelRepo extends CrudRepository<Travel,Long> {
	List<Travel> findAll();

}
