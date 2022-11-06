package com.axsos.mvc.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.axsos.mvc.models.Travel;
import com.axsos.mvc.services.TravelService;

@Controller
public class TravelController {
	
	@Autowired
	TravelService travelServ;
	
	@GetMapping({"/","/expenses"})
	public String index(Model model, @ModelAttribute Travel travel) {
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
}
