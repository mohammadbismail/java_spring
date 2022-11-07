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

import com.axsos.mvc.models.Ninja;
import com.axsos.mvc.services.DojoServ;
import com.axsos.mvc.services.NinjaServ;

@Controller
public class NinjaController {


	@Autowired
	NinjaServ ninjaServ;
	
	@Autowired
	DojoServ dojoServ;
	
	// rending add ninja page
	@GetMapping("/ninjas/new")
	public String addninjapage(Model model,@ModelAttribute("ninja") Ninja ninja) {
		model.addAttribute("dojosFromDB", dojoServ.allDojos());
		return "newninja.jsp";
	}
	// rendering allninjas page
	@GetMapping("/dojo/{dojoid}")
	public String allninjas(Model model,@PathVariable("dojoid") Long dojoid) {
		model.addAttribute("dojoFromDB", dojoServ.findDojo(dojoid));
//		System.out.println(dojoServ.findDojo(dojoid).getNinjas());
		return "allninjaspage.jsp";
	}
	
	// create ninja
	@PostMapping("/ninjas/create")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if (result.hasErrors()) {
			return "newninja.jsp";
		}
		else {
			ninjaServ.createNinja(ninja);
//			System.out.println(ninja.getDojo().getId());
			return "redirect:/dojo/"+ ninja.getDojo().getId();
		}
	}
	
}
