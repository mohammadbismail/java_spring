package com.axsos.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	@GetMapping(value={"/omikuji","/"})
	public String index() {
		return "index.jsp";
	}
	@PostMapping("/submit")
	public String form() {
		return "redirect:/show";
	}
	@GetMapping("/show")
	public String show() {
	return "show.jsp";
	}
	
}
