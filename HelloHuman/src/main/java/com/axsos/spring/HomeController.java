package com.axsos.spring;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(@RequestParam Map<String,String> requestParams) throws Exception {
		String firstName = requestParams.get("name");
		String lastName = requestParams.get("last");
//		Integer times = Integer.parseInt(requestParams.get("times"));
		
			if (requestParams.isEmpty()) {
//				for (int i = 0; i < times ; i++)					
					return "Hello Human";
			}
			else if (lastName.isEmpty()) {
//				for (int i = 0; i < times ; i++) 			
				return "Hello "+firstName; 
		}
			else {
//				for (int i = 0; i < times ; i++)
				return "Hello " + firstName + lastName;
		}
			
    }
}

