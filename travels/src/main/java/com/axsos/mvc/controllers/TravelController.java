package com.axsos.mvc.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.axsos.mvc.models.Travel;
import com.axsos.mvc.services.TravelService;

@Controller
public class TravelController {
	
	@Autowired
	TravelService travelServ;
	
	@GetMapping({"/","/expenses"})
	public String index(Model model, @ModelAttribute("travel") Travel travel) {
		model.addAttribute("travels", travelServ.allTravels());
		return "index.jsp";
	}
	@PostMapping("/expenses/addtravel")
	public String addtravel(@Valid @ModelAttribute("travel") Travel travel, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}
		else {
			travelServ.createTravel(travel);
		}
		return "redirect:/expenses";
	}
	@GetMapping("/expenses/edit/{id}")
	public String showTravel(@PathVariable("id") Long id,
							Model model) {
		model.addAttribute("travel", travelServ.findTravel(id));
		return "edit.jsp";
	}

	@PutMapping("/expenses/edit/{id}")
	public String updateTravel(
			@PathVariable("id") Long id,
			@Valid @ModelAttribute("travel") Travel travel, BindingResult result
			) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
			travelServ.findTravel(id).setExpense(travel.getExpense());
			travelServ.findTravel(id).setDescription(travel.getDescription());
			travelServ.findTravel(id).setPrice(travel.getPrice());
			travelServ.findTravel(id).setVendor(travel.getVendor());
			travelServ.updateTravel(id);
			return "redirect:/expenses";
		}
	}
	@GetMapping("/expenses/{id}")
	public String viewTravel(@PathVariable("id") Long id,Model model) {
		model.addAttribute("singletravel", travelServ.findTravel(id));
		return "travel.jsp";
	}
	@DeleteMapping("/expenses/delete/{id}")
	public String deleteTravel(@PathVariable("id") Long id) {
		travelServ.deleteTravel(id);
		return "redirect:/expenses";
	}
}
