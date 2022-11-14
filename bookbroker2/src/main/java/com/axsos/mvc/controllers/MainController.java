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
import org.springframework.web.bind.annotation.RequestMapping;
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
		if (session.getAttribute("user") != null) {
			return "redirect:/books";
		}
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "logreg.jsp";
	}

	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("newUser") User user, BindingResult result, Model model,
			HttpSession session) {

		// go to registration process in services
		userServ.register(user, result);

		if (result.hasErrors()) {
			// if there are errors in filling registration form
			// keep the filled data for registration object
			// again give new login user object to fill
			model.addAttribute("newLogin", new LoginUser());
			return "logreg.jsp";
		} else {
			session.setAttribute("user", user);
			session.setAttribute("logged_in", true);
			return "redirect:/books";
		}
	}

	@PostMapping("/login")
	public String loginUser(@Valid @ModelAttribute("newLogin") LoginUser loginUser, BindingResult result, Model model,
			HttpSession session) {
		// go to login process
		userServ.login(loginUser, result);
		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "logreg.jsp";
		} else {
			session.setAttribute("user", userServ.findUserByEmail(loginUser.getEmail()));
			session.setAttribute("logged_in", true);
			return "redirect:/books";
		}
	}

	@GetMapping("/books")
	public String sucesspage(HttpSession session, Model model) {
		if (session.getAttribute("user") != null) {
			User userFromSession = (User) session.getAttribute("user");
			User userFromDB = userServ.findUserById(userFromSession.getId());
			model.addAttribute("loggedUser", userFromDB);
			model.addAttribute("allbooks", bookServ.allBooks());
		}
		return "books.jsp";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("user", null);
		session.setAttribute("logged_in", false);
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping("/books/new")
	public String addBook(@ModelAttribute("book") Book book, HttpSession session, Model model) {
		User userFromSession = (User) session.getAttribute("user");
		model.addAttribute("user", userServ.findUserById(userFromSession.getId()));
		return "addbook.jsp";
	}

	@PostMapping("/books/create")
	public String creatBook(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "addbook.jsp";
		}
		bookServ.createBook(book);
		return "redirect:/books";
	}

	@GetMapping("/books/{bookid}")
	public String bookView(@PathVariable("bookid") Long bookid, Model model, HttpSession session) {
		model.addAttribute("bookFromDB", bookServ.findBook(bookid));
		model.addAttribute("userFromSession", (User) session.getAttribute("user"));

		return "book.jsp";
	}

	@GetMapping("/books/edit/{bookid}")
	public String editpage(@PathVariable("bookid") Long bookid, Model model) {
		Book bookBeforeEdit = bookServ.findBook(bookid);
		System.out.println(bookBeforeEdit.getUser().getUsername() + bookBeforeEdit.getTitle());
		model.addAttribute("bookBeforeEdit", bookBeforeEdit);
		return "edit.jsp";
	}

	@PutMapping("/books/editbook/{bookid}")
	public String editThisBook(@Valid @ModelAttribute("bookBeforeEdit") Book bookAfterEdit, BindingResult result,
			Model model, HttpSession session, @PathVariable("bookid") Long bookid) {
		User myUser = (User) session.getAttribute("user");
		Book notEditidBook = bookServ.findBook(bookid);
//		System.out.println(bookAfterEdit.getUser().getUsername() + bookAfterEdit.getTitle());
		if (result.hasErrors()) {
//			model.addAttribute("bookBeforeEdit", notEditidBook);
//			model.addAttribute("user", myUser);
			return "edit.jsp";
		}
		bookServ.updateBook(notEditidBook.getId(), bookAfterEdit, myUser);
		return "redirect:/books";

	}

	@DeleteMapping("/books/delete")
	public String deleteThatBook(@RequestParam("bookid") Long bookid, HttpSession session) {
		bookServ.deleteBook(bookid);
		return "redirect:/books";
	}

	@GetMapping("/bookmarket")
	public String bookMarket(HttpSession session, Model model) {
		User currentUser = (User) session.getAttribute("user");
		model.addAttribute("loggedUser", userServ.findUserById(currentUser.getId()));
		model.addAttribute("availableBooks", bookServ.findAvailableBooks());
		model.addAttribute("borrowedBooks", bookServ.findAllBorrowedBooks());
		System.out.println(bookServ.findAllBorrowedBooks());
		return "bookmarket.jsp";
	}

	@PutMapping("/books/borrow/{bookid}")
	public String borrowBook(@RequestParam("borrowid") Long userBorrowid,@PathVariable("bookid") Long bookid) {
		Book bookToBorrow = bookServ.findBook(bookid);
		bookServ.borrowBook(userBorrowid,bookToBorrow);
		
		return "redirect:/bookmarket";
	}
	@PutMapping("/books/return/{bookid}")
	public String returnBook(@PathVariable("bookid") Long bookid) {
		Book bookToReturn = bookServ.findBook(bookid);
		bookServ.returnBook(bookToReturn);
		return "redirect:/bookmarket";
		
	}

}
