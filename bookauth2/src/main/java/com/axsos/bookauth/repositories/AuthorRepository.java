package com.axsos.bookauth.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.bookauth.models.Author;
import com.axsos.bookauth.models.Book;

@Repository
public interface AuthorRepository extends CrudRepository<Author,Long>{
List<Author> findAll();


List<Author> findByBooksNotContains(Book book);


}
