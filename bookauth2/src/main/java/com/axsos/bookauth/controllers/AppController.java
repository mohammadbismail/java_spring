package com.axsos.bookauth.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.axsos.bookauth.models.Author;
import com.axsos.bookauth.models.Book;
import com.axsos.bookauth.models.BookAuthor;
import com.axsos.bookauth.services.AppService;

@Controller
public class AppController {
private final AppService appService;
public AppController(AppService appService) {
	this.appService=appService;
}
@GetMapping("/")
public String index(Model model) {
	model.addAttribute("books",appService.allBooks());
	model.addAttribute("authors",appService.allAuthors());
	return "index.jsp";
}

@GetMapping("/books/new")
public String book(@ModelAttribute("book") Book book) {
	return "book.jsp";
}

@PostMapping("/books")
public String book2(@Valid @ModelAttribute("book") Book book,BindingResult result) {
	if(result.hasErrors()) {
		return "book.jsp";
	}
	else {
		appService.createBook(book);
		return "redirect:/";
	}
}

@GetMapping("/authors/new")
public String author(@ModelAttribute("author") Author author) {
	return "author.jsp";
}

@PostMapping("/authors")
public String author2(@Valid @ModelAttribute("author") Author author,BindingResult result) {
	if(result.hasErrors()) {
		return "author.jsp";
	}
	else {
		appService.createAuthor(author);
		return "redirect:/";
	}
}

@GetMapping("/books/{bookId}")
public String onebook(@ModelAttribute("ba") BookAuthor ba,@PathVariable("bookId") Long id,Model model) {
	Book book=appService.findBook(id);
	model.addAttribute("book",book);
	model.addAttribute("authors",appService.authorsNotInBook(book));
	return "onebook.jsp";
}

@PostMapping("/books/addauth")
public String baaa(@ModelAttribute("ba") BookAuthor ba) {
	appService.createBookAuthor(ba);
return "redirect:/";
}
	
}

