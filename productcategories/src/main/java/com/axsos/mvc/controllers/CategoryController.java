package com.axsos.mvc.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.axsos.mvc.models.Category;
import com.axsos.mvc.services.CategoryServ;
import com.axsos.mvc.services.ProductServ;

@Controller
public class CategoryController {
	
	@Autowired
	ProductServ productServ;
	
	@Autowired
	CategoryServ categoryServ;
	
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "category.jsp";
	}
	@PostMapping("/categories/create")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result)  {
		if ( result.hasErrors()) {
			return "category.jsp";
		}
		else {
			categoryServ.createCategory(category);
			return "redirect:/categories/"+category.getId();
		}
	}
	@GetMapping("/categories/{categoryid}")
	public String categoryPage(@PathVariable("categoryid") Long categoryid,Model model) {
		Category myCategory = categoryServ.findCategory(categoryid);
		model.addAttribute("productList", productServ.productsWithoutThisCategory(myCategory));
		model.addAttribute("categoryFromDb", myCategory);
		return "allcategories.jsp";
	} 
	@PostMapping("/category/addcategory/")
	public String addProdToCat(
					@RequestParam("productid") Long productid,
					@RequestParam("categoryid") Long categoryid) {
		categoryServ.addProductToCategory(productid,categoryid);
		return "redirect:/categories/"+categoryid;
	}
}
