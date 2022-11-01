package com.axsos.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String index(@RequestParam Map<String,String> requestParams) throws Exception {
//		String firstName = requestParams.get("name");
//		String lastName = requestParams.get("last");
//		Integer times = Integer.parseInt(requestParams.get("times"));
	public String index(@RequestParam ("name") String name,@RequestParam("last") String last , @RequestParam("times") Integer times) throws Exception {

//			while (times != null) {
//			if (name.isEmpty()) {
//					return "Hello Human";
//			}
//			else if (!name.isEmpty() && last.isEmpty()) {
//				return "Hello "+name; 
//		}
//			else {
//				return "Hello " + name + last;
//		}	
//    }
			if (name.isEmpty()) {
				return "Hello Human";
			}
			else if( !name.isEmpty() && last.isEmpty() ) {
				return "Hello" + name;
			}
			else {
				return "Hello" + name + last;
			}
}
}

