package com.axsos.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikinchi")
public class HomeController {
	@RequestMapping("")
	public String welcome() {
		return "Welcome!";
	}
	@RequestMapping("/today")
	public String today() {
		return "today you will find luck";
	}
	@RequestMapping("/tomorrow")
	public String tomorrow() {
		return "tomorrow, an opportunity will arrise!";
	}
}
