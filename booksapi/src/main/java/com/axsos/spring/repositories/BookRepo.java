package com.axsos.spring.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.spring.models.Book;
@Repository
public interface BookRepo extends CrudRepository<Book,Long> {
	
    List<Book> findAll();
    List<Book> findByDescriptionContaining(String search);
    Long countByTitleContaining(String search);
    Long deleteByTitleStartingWith(String search);
}
