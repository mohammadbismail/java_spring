package com.axsos.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axsos.mvc.models.Book;
import com.axsos.mvc.models.User;
import com.axsos.mvc.repositories.BookRepo;

@Service
public class BookServ {
	@Autowired
	BookRepo bookRepo;
	
	@Autowired
	UserService userServ;
	
	public List<Book> allBooks(){
		return bookRepo.findAll();
	}
	public Book findBook(Long bookid) {
		Optional<Book> bookIfFound = bookRepo.findById(bookid);
		if (bookIfFound.isPresent()) {
			return bookIfFound.get();
		}
		else {
			return null;
		}
	}
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}
	

	public Book updateBook(Long bookFromDbid,Book editedBook, User myUser) {
		Book book = findBook(bookFromDbid);
		book.setUser(myUser);
		book.setTitle(editedBook.getTitle());
		book.setAuthor(editedBook.getAuthor());
		book.setThoughts(editedBook.getThoughts());
		return bookRepo.save(book);		
		}
		
	public void deleteBook(Long bookid) {
		bookRepo.deleteById(bookid);
	}
}
