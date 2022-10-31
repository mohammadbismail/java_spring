package com.axsos.spring;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/daikichi")
public class HomeController {
	
	@RequestMapping(value = "/{travel}/{somecity}", method = RequestMethod.GET)
	@ResponseBody
	public String travel(@PathVariable("travel") String travel,@PathVariable("somecity") String city) {
		return "Congratulations! You will soon travel to " + city;
	}
//	@RequestMapping(value = "/{lotto}/{num}", method = RequestMethod.GET)
//	@ResponseBody
//	public String lotto(@PathVariable String lotto,@PathVariable String num) {
//		Integer number = Integer.parseInt(num);
//		if (number % 2 == 0) {
//			return "You will take a ground journey in the near future, but be weary of tempting offers!";			
//		}
//		else {
//			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";			
//
//		}
//	}
}


