package com.axsos.spring.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@GetMapping(value={"/omikuji","/"})
	public String index() {
		return "index.jsp";
	}
	@PostMapping("/submit")
	public String form(
			@RequestParam("number") Integer number,
			@RequestParam("city") String city,
			@RequestParam("name") String firstname,
			@RequestParam("hobby") String hobby,
			@RequestParam("desc") String desc,
			HttpSession session
			) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("name", firstname);
		session.setAttribute("hobby", hobby);
		session.setAttribute("desc", desc);
		return "redirect:/show";
	}
	@GetMapping("/show")
	public String show() {
	return "show.jsp";
	}
	
}
