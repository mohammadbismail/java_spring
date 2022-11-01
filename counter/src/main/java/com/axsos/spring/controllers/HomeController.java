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
	@RequestMapping("/two")
	public String twoCount(HttpSession session, Model model) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			Integer currCount = (Integer) session.getAttribute("count");
			currCount +=2;
			session.setAttribute("count", currCount);
		}
		model.addAttribute("count", session.getAttribute("count"));
		return "countBy2.jsp";
	}
	@RequestMapping("/counter")
	public String showCount() {
		return "counter.jsp";
	}
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("count", 0);
		return "counter.jsp";
	}
}
