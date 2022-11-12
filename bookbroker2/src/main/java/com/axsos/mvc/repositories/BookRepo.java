package com.axsos.mvc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.mvc.models.Book;
import com.axsos.mvc.models.User;

@Repository
public interface BookRepo extends CrudRepository<Book, Long>{
	List<Book> findAll();
	// all borrowed books
	List<Book> findAllByborrowerIsNotNull();
	// books not borrowed
	List<Book> findAllByborrowerIsNull();

}
