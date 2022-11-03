package com.axsos.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.spring.models.Book;
import com.axsos.spring.repositories.BookRepo;

@Service
public class BookService {
	// adding the book repository as a dependency
	private final BookRepo bookRepo;

	// Injecting Repository Interface using dependency injection
	// and its methods to be used for communication with DB

	// Constructor of Services
	public BookService(BookRepo bookRepo) {
		this.bookRepo = bookRepo;
	}

	// returns all the books
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}

	// creates a book
	public Book createBook(Book b) {
		return bookRepo.save(b);
	}

	// retrieves a book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}

	// Receives book instance from ControllerAPI
	public Book updateBook(Long id) {
		return bookRepo.save(this.findBook(id));

	}

	// Deletes book
	public void deleteBook(long id) {
		bookRepo.deleteById(id);
	}

}
