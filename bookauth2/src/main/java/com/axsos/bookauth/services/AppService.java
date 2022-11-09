package com.axsos.bookauth.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.axsos.bookauth.models.Author;
import com.axsos.bookauth.models.Book;
import com.axsos.bookauth.models.BookAuthor;
import com.axsos.bookauth.repositories.AuthorRepository;
import com.axsos.bookauth.repositories.BookAuthorRepository;
import com.axsos.bookauth.repositories.BookRepository;


@Service
public class AppService {
private final BookRepository bookRepository;
private final AuthorRepository authorRepository;
private final BookAuthorRepository baRepository;
public AppService(BookRepository bookRepository,AuthorRepository authorRepository,BookAuthorRepository baRepository) {
	this.bookRepository=bookRepository;
	this.authorRepository=authorRepository;
	this.baRepository=baRepository;
}

public Book createBook(Book book) {
	return bookRepository.save(book);
}
public Author createAuthor(Author author) {
	return authorRepository.save(author);
}
public List<Book> allBooks() {
	return bookRepository.findAll();
}
public List<Author> allAuthors() {
	return authorRepository.findAll();
}
public Book findBook(Long id) {
	return this.bookRepository.findById(id).orElse(null);
}

public Author findAuthor(Long id) {
	return this.authorRepository.findById(id).orElse(null);
}


public Book updateBook(Book b) {
	return this.bookRepository.save(b);
	
}

public void updateAuthor(Author auth) {
	authorRepository.save(auth);
	
}

public List<Author> authorsNotInBook(Book b){
	return authorRepository.findByBooksNotContains(b);
}

public BookAuthor createBookAuthor(BookAuthor ba) {
	return baRepository.save(ba);
}

}
