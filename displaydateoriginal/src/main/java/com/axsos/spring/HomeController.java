package com.axsos.spring;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class HomeController {
	@RequestMapping("/")
	public String index(Model model) {

		return "index.jsp";
	}

	@RequestMapping("/time")
	public String time(Model model) {
		Date date = new Date();
		// 10:35 PM
		SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
		String timeFormatingDate = timeFormat.format(date); 
		model.addAttribute("time", timeFormatingDate );
		return "time.jsp";
	}

	@RequestMapping("/date")
	public String date(Model model) {
		Date date = new Date();
		// Saturday, the 22 of January, 2028
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE,'the 'dd' of' MMMM,yyyy");
		String formatedDate = dateFormat.format(date);
		model.addAttribute("date", formatedDate);
		return "date.jsp";
	}
}
