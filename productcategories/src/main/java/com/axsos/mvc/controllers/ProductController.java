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

import com.axsos.mvc.models.Product;
import com.axsos.mvc.services.CategoryServ;
import com.axsos.mvc.services.ProductServ;

@Controller
public class ProductController {
	
	@Autowired
	ProductServ productServ;
	
	@Autowired
	CategoryServ categoryServ;
	
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("allproducts",productServ.allProducts());
		model.addAttribute("allcategories", categoryServ.allCategories());
		return "index.jsp";
	}
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		
		return "product.jsp";
	}
	@PostMapping("/products/create")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()){			
			return "product.jsp";
		}
		else {
			productServ.createProduct(product);
			return "redirect:/products/"+product.getId();
		}
	}
	@GetMapping("/products/{prodid}")
	public String productPage(@PathVariable("prodid") Long prodid,Model model) {
		// injecting all categories for this specific product
		Product myProduct = productServ.findProduct(prodid);
		model.addAttribute("categorieslist", categoryServ.categoriesWithoutThisProduct(myProduct));
		model.addAttribute("productfromDb", productServ.findProduct(prodid));
		return "allproducts.jsp";
	}
	@PostMapping("/product/addcategory/")
	public String addCatToProd(
					@RequestParam("productid") Long productid,
					@RequestParam("categoryid") Long categoryid) {
		productServ.addCategoryToProduct(productid,categoryid);
		return "redirect:/products/"+productid;
	}
}
