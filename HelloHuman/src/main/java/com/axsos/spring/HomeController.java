package com.axsos.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/")
public class HomeController {
	@RequestMapping("/")
	public String index(@RequestParam(value="name", required = false) String searchRes) {
		if (searchRes == null ) {
			return "Hello Human";
		}
		else {
		return "Hello "+searchRes; 
		}
	}
}
