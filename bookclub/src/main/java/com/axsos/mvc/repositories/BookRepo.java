package com.axsos.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.mvc.models.Book;

@Repository
public interface BookRepo extends CrudRepository<Book, Long>{
	List<Book> findAll();
}
