package com.axsos.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.axsos.spring.services.BookService;

@Controller
public class BookController {

	@Autowired
	BookService bookServ;

	@GetMapping("/book/{bookId}")
	public String index(
			Model model,
			@PathVariable("bookId") Long bookId
			) {
		// Bring book from DB and inject it in views model to render on JSP
		model.addAttribute("book", bookServ.findBook(bookId));
		return "index.jsp";
	}
	@GetMapping("/books")
	public String getBooks(Model model) {
		model.addAttribute("books",bookServ.allBooks());
//		System.out.println(bookServ.allBooks());
		return "books.jsp";
	}
}
