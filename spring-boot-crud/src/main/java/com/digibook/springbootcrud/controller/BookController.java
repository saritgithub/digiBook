package com.digibook.springbootcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digibook.springbootcrud.Exception.ResourceNotFoundException;
import com.digibook.springbootcrud.model.Book;
import com.digibook.springbootcrud.repository.BookRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



//mark class as Controller 
@CrossOrigin(origins = {"http://localhost:3000" , "http://localhost:8080"})
@RestController
@RequestMapping("/api/v1")
public class BookController {

    //autowire the BooksService class
	@Autowired
	private BookRepository bookRepository;
	
    //get book. creating a get mapping that retrieves all the books detail from the database
	@GetMapping("/books")
	public List<Book> getAllBook() {    
	    List<Book> x= this.bookRepository.findAll();
	    return x;
	}  
	
   //get book by id
	@GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "id") Long bookId)
           throws ResourceNotFoundException {
        Book book = bookRepository.findById(bookId)
           .orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + bookId));
        return ResponseEntity.ok().body(book);
         
	}
	
	//save book
	@PostMapping("/books")
	public Book createBook(@RequestBody Book book) {
		return this.bookRepository.save(book);
	
	}
	
	//update book
	
	@PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable(value = "id") Long bookId,
         @Validated @RequestBody Book bookDetails) throws ResourceNotFoundException {
        Book book = bookRepository.findById(bookId)
        .orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + bookId));

        
        book.setBookTitle(bookDetails.getBookTitle());
        book.setBookDescription(bookDetails.getBookDescription());
        book.setIssuer(bookDetails.getIssuer());
        book.setDateOfIssue(bookDetails.getDateOfIssue());
        book.setCategory(bookDetails.getCategory());
        
       
        final Book updatedBook = bookRepository.save(book);
        return ResponseEntity.ok(updatedBook);
	}
	
	
	 //delete book
	@DeleteMapping("/books/{id}")
    public Map<String, Boolean> deleteBook(@PathVariable(value = "id") Long bookId)
         throws ResourceNotFoundException {
        Book book = bookRepository.findById(bookId)
       .orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + bookId));

        bookRepository.delete(book);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
	}
	

	
	
}





