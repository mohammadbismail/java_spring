package com.axsos.mvc.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.axsos.mvc.models.Dojo;
import com.axsos.mvc.services.DojoServ;
import com.axsos.mvc.services.NinjaServ;

@Controller
public class DojoController {

	@Autowired
	DojoServ dojoServ;
	@Autowired
	NinjaServ ninjaServ;
	
	@GetMapping({ "/", "/dojos/new" })
	public String adddojopage(@ModelAttribute("dojo") Dojo dojo) {
		return "newdojo.jsp";
	}
	@PostMapping("/dojos/create")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "newdojo.jsp";
		} else {
			dojoServ.createDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}

}
