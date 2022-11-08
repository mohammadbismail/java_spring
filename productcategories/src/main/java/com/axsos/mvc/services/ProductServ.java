package com.axsos.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axsos.mvc.models.Category;
import com.axsos.mvc.models.Product;
import com.axsos.mvc.repos.ProductRepo;

@Service
public class ProductServ {
	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	CategoryServ categoryServ;
	
	public List<Product> allProducts() {
		return productRepo.findAll();
	}
	public Product findProduct(Long id) {
		Optional<Product> productFromDB= productRepo.findById(id);
		if (productFromDB.isPresent()) {
			return productFromDB.get();
		}
		else {
			return null;
		}
	}
	public Product createProduct(Product product) {
		return productRepo.save(product);
		
	}
	public void addCategoryToProduct(Long prodid,Long categoryid) {
		// supposed category number
		
		Product myProduct = this.findProduct(prodid);
		Category myCategory = categoryServ.findCategory(categoryid);
		List<Category> myProductCategories = myProduct.getCategories();
		myProductCategories.add(myCategory);
		myProduct.setCategories(myProductCategories);
		productRepo.save(myProduct);
	}
	
	public List<Product> productsWithoutThisCategory(Category category){
		return productRepo.findByCategoriesNotContains(category);
	}
}
