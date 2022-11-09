package com.axsos.mvc.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.axsos.mvc.models.LoginUser;
import com.axsos.mvc.models.User;
import com.axsos.mvc.services.UserService;

@Controller
public class MainController {
	@Autowired
	UserService userServ;
	
	@GetMapping("/")
	public String loginRegistration(HttpSession session, Model model) {
		if (session.getAttribute("user_object")!= null) {
			return "redirect:/success";
		}
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "logreg.jsp";
	}
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("newUser") User user,
							   BindingResult result,
							   Model model,
							   HttpSession session) {
		
		// go to registration process in services
		userServ.register(user,result);
		
		if (result.hasErrors()) {
			// if there are errors in filling registration form
			// keep the filled data for registration object 
			// again give new login user object to fill
			model.addAttribute("newLogin", new LoginUser() );
			return "logreg.jsp";
		}
		else {
			session.setAttribute("user_object",user);
			session.setAttribute("logged_in",true);
			return "redirect:/success";
		}
	}
	
	@PostMapping("/login")
	public String loginUser(@Valid @ModelAttribute("newLogin") LoginUser loginUser,
							BindingResult result,
							Model model,
							HttpSession session) {
		// go to login process
		userServ.login(loginUser,result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "logreg.jsp";
		}
		else {
			session.setAttribute("user_object", userServ.findUserByEmail(loginUser.getEmail()));
			session.setAttribute("logged_in",true);
			return "redirect:/success";
		}
		
	}
	
	@GetMapping("/success")
	public String sucesspage(HttpSession session, Model model) {
		model.addAttribute("loggedUser",session.getAttribute("user_object"));
		return "success.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("user_object", null);
		session.setAttribute("logged_in", false);
		return "redirect:/";
	}
}
