package com.digibook.springbootcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.digibook.springbootcrud.model.Book;



@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}