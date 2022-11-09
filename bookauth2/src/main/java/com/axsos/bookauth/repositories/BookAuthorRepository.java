package com.axsos.bookauth.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.bookauth.models.BookAuthor;
@Repository
public interface BookAuthorRepository extends CrudRepository<BookAuthor,Long>{

}
