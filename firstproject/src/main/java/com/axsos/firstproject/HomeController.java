package com.axsos.firstproject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
	@RequestMapping("")
	public String hello() {
		return "Hello World!";
	}
	@RequestMapping("/index")
	public String mob() {
		return "Hello, It's Ismail";
	}
}
