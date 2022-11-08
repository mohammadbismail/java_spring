package com.axsos.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axsos.mvc.models.Category;
import com.axsos.mvc.models.Product;
import com.axsos.mvc.repos.CategoryRepo;

@Service
public class CategoryServ {
	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	ProductServ productServ;
	
	public List<Category> allCategories() {
		return categoryRepo.findAll();
	}
	public Category findCategory(Long id) {
		Optional<Category> categoryFromDB= categoryRepo.findById(id);
		if (categoryFromDB.isPresent()) {
			return categoryFromDB.get();
		}
		else {
			return null;
		}
	}
	public Category createCategory(Category category) {
		return categoryRepo.save(category);
	}
	public List<Category> categoriesWithoutThisProduct(Product p){
		return categoryRepo.findByProductsNotContains(p);
	}
	public void addProductToCategory(Long productid,Long categoryid) {
		Product myProduct = productServ.findProduct(productid);
		Category myCategory = this.findCategory(categoryid);
		List<Product> listOfProducts = myCategory.getProducts();
		listOfProducts.add(myProduct);
		myCategory.setProducts(listOfProducts);
		categoryRepo.save(myCategory);
	}
}
