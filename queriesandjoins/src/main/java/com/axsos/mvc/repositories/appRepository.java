package com.axsos.mvc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.mvc.models.Country;

@Repository
public interface appRepository extends CrudRepository<Country,Long>{
	
	// display all countries, cities and their percentage of Slovene speaking people
	@Query(value="select A.name,B.language,B.percentage from countries AS A join languages AS B on A.id=B.country_id where B.language like '%Slovene%' ORDER BY B.percentage DESC",nativeQuery=true)
	List<Object[]> q1();
	
	@Query(value="select A.name,count(C.id) as numberOfC from countries AS A join cities as C on A.id = C.country_id GROUP BY A.id ORDER BY numberOfC DESC ",nativeQuery=true)
	List<Object[]> q2();
	
	@Query(value="select cities.name as citiesname from cities join countries on cities.country_id = countries.id where countries.name like '%Mexico%' and cities.population > 500000 ORDER BY cities.population DESC",nativeQuery=true)
	List<Object[]> q3();
	
	@Query(value="select languages.language as languages from languages join countries on languages.country_id = countries.id where languages.percentage > 0.89 ORDER BY languages.percentage DESC;",nativeQuery=true)
	List<Object[]> q4();
	
	@Query(value="select countries.name from countries where countries.surface_area < 501 and countries.population > 100000;",nativeQuery=true)
	List<Object[]> q5();
	
	
	
}
