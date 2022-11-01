package com.axsos.spring.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")

	public String startCount(HttpSession session, Model model) {
		if (session.getAttribute("count") == null) {
			
			session.setAttribute("count", 0);
		}
		else {
			Integer currCount = (Integer) session.getAttribute("count");
			currCount++;
			session.setAttribute("count", currCount);
		}
		Integer thisCount = (Integer) session.getAttribute("count");
		System.out.println(thisCount);
		model.addAttribute("count", thisCount);
		return "index.jsp";
	}
	@RequestMapping("/counter")
	public String showCount() {
		return "counter.jsp";
	}
}
