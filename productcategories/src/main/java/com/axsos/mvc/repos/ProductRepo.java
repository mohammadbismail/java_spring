package com.axsos.mvc.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.mvc.models.Category;
import com.axsos.mvc.models.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product,Long> {
	List<Product> findAll();
	List<Product> findByCategoriesNotContains(Category category);
	
}
