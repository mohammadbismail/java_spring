package com.axsos.mvc.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.axsos.mvc.models.Book;
import com.axsos.mvc.models.LoginUser;
import com.axsos.mvc.models.User;
import com.axsos.mvc.services.BookServ;
import com.axsos.mvc.services.UserService;

@Controller
public class MainController {
	@Autowired
	UserService userServ;
	
	@Autowired
	BookServ bookServ;
	
	@GetMapping("/")
	public String loginRegistration(HttpSession session, Model model) {
		if (session.getAttribute("user")!= null) {
			return "redirect:/books";
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
			session.setAttribute("user",user);
			session.setAttribute("logged_in",true);
			return "redirect:/books";
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
			session.setAttribute("user", userServ.findUserByEmail(loginUser.getEmail()));
			session.setAttribute("logged_in",true);
			return "redirect:/books";
		}
	}
	@GetMapping("/books")
	public String sucesspage(HttpSession session, Model model) {
		if (session.getAttribute("user") != null) {
		User userFromSession =(User) session.getAttribute("user");
		User userFromDB = userServ.findUserById(userFromSession.getId());
		model.addAttribute("loggedUser",userFromDB);
		model.addAttribute("allbooks", bookServ.allBooks());
		}
		return "books.jsp";		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("user", null);
		session.setAttribute("logged_in", false);
		return "redirect:/";
	}
	@GetMapping("/books/new")
	public String addBook(@ModelAttribute("book") Book book, HttpSession session, Model model) {
		return "addbook.jsp";
	}
	@PostMapping("/books/create")
	public String creatBook(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "addbook.jsp";
		}
//		System.out.println((User)session.getAttribute("user"));
		bookServ.createBook(book,(User)session.getAttribute("user"));
		return "redirect:/books";
	}
	@GetMapping("/books/{bookid}")
		public String bookView(@PathVariable("bookid") Long bookid, HttpSession session,Model model) {
			model.addAttribute("bookFromDB", bookServ.findBook(bookid));
			model.addAttribute("userFromSession", (User)session.getAttribute("user"));
			
			return "book.jsp";
		}
	@DeleteMapping("/books/delete")
	public String deleteThatBook(@RequestParam("bookid") Long bookid, HttpSession session) {
		bookServ.deleteBook(bookid);
		return "redirect:/books";
	}
	@GetMapping("/books/edit/{bookid}")
		public String editpage(@PathVariable("bookid") Long bookid,Model model,HttpSession session) {
		model.addAttribute("bookToEdit", bookServ.findBook(bookid));
			return "edit.jsp";
		}
	@PutMapping("/books/editbook/")
	public String editThisBook(@Valid @ModelAttribute("bookToEdit") Book book, BindingResult result,HttpSession session) {
		if (result.hasErrors()) {
			return "edit.jsp";
		}
		User userFromSession =(User) session.getAttribute("user");
		bookServ.updateBook(book, userFromSession );
		return "redirect:/books";
		
	}
}

