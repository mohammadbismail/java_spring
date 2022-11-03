package com.axsos.spring.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axsos.spring.models.Book;
import com.axsos.spring.services.BookService;

@RestController
public class BookApi {
	// Injecting BookService into Controller
	private final BookService bookService;

	public BookApi(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping("/api/books")
	public List<Book> index() {
		return bookService.allBooks();
	}

	@PostMapping("/api/books")
	public Book create(
			@RequestParam(value = "title") String title,
			@RequestParam(value = "description") String desc,
			@RequestParam(value = "language") String lang,
			@RequestParam(value = "pages") Integer numOfPages) {
		Book book = new Book(title, desc, lang, numOfPages);
		return bookService.createBook(book);
		
	}
	@RequestMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        	return  bookService.findBook(id);
         
    }
	@PutMapping(value="/api/books/{id}")
    public Book update(
    		@PathVariable("id") Long id,
    		@RequestParam(value="title") String title,
    		@RequestParam(value="description") String desc,
    		@RequestParam(value="language") String lang,
    		@RequestParam(value="pages") Integer numOfPages) {
			//Get book from database using Service help
			Book book = bookService.findBook(id);
			// Update book member variables 
			book.setTitle(title);
			book.setDescription(desc);
			book.setLanguage(lang);
			book.setNumberOfPages(500);
			// save this same book back to DB
			return bookService.updateBook(id);
			
    }
	@DeleteMapping(value="/api/books/{id}")
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }

}
