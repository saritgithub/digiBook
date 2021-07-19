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
import com.digibook.springbootcrud.dto.BorrowDTO;
import com.digibook.springbootcrud.model.Book;
import com.digibook.springbootcrud.model.Borrow;
import com.digibook.springbootcrud.model.Users;
import com.digibook.springbootcrud.repository.BookRepository;
import com.digibook.springbootcrud.repository.BorrowRepository;
import com.digibook.springbootcrud.repository.UsersRepository;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.websocket.server.PathParam;

//mark class as Controller
@CrossOrigin(origins = {"http://localhost:3000" , "http://localhost:8080"})
@RestController
@RequestMapping("/api/v1")
public class BorrowController {
	// autowire the BorrowService class
	@Autowired
	private BorrowRepository borrowRepository;
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private BookRepository bookRepository;

	// get borrow. creating a get mapping that retrieves all the borrows detail from
	// the database
	@GetMapping("/borrows")
	public List<Borrow> getAllBorrow() {
		return this.borrowRepository.findByReturnDateIsNull();
	}

	// get borrow. creating a get mapping that retrieves all the borrows detail from
	// the database
	@GetMapping("/borrows/user/{userId}")
	public List<Borrow> getAllBorrowForUser(@PathVariable(value = "userId") long userId) {
		Optional<Users> user = this.usersRepository.findById(userId);
		if (user.isPresent()) {
			return this.borrowRepository.findByReturnDateIsNullAndUsers(user.get());
		}
		return null;
	}

	// get borrow by id
	@GetMapping("/borrows/{id}")
	public ResponseEntity<Borrow> getBorrowById(@PathVariable(value = "id") Long borrowId)
			throws ResourceNotFoundException {
		Borrow borrow = borrowRepository.findById(borrowId)
				.orElseThrow(() -> new ResourceNotFoundException("Borrow not found for this id :: " + borrowId));
		return ResponseEntity.ok().body(borrow);

	}
	//DTO- data transfer object

	// save borrow
	@PostMapping("borrows")
	public ResponseEntity createBorrow(@RequestBody BorrowDTO borrowObjFromFrontend) {
		//convert dto to DB
		Borrow borrowObjectToDB=new Borrow();
	    
		// get book by book id
		// get user by user id
		Book bookFromDB=bookRepository.getById(borrowObjFromFrontend.getBookId());
		Users userFromDB=usersRepository.getById(borrowObjFromFrontend.getUserId());
		borrowObjectToDB.setTakenDate(borrowObjFromFrontend.getTakenDate());
		borrowObjectToDB.setBook(bookFromDB);
		borrowObjectToDB.setUsers(userFromDB);
		this.borrowRepository.save(borrowObjectToDB);
		return ResponseEntity.noContent().build();

	}

	// update borrow

	@PutMapping("/borrows/{id}")
	public ResponseEntity<Borrow> updateBorrow(@PathVariable(value = "id") Long borrowId,
			@Validated @RequestBody Borrow borrowDetails) throws ResourceNotFoundException {
		Borrow borrow = borrowRepository.findById(borrowId)
				.orElseThrow(() -> new ResourceNotFoundException("Borrow not found for this id :: " + borrowId));

		borrow.setTakenDate(borrowDetails.getTakenDate());
		borrow.setReturnDate(borrowDetails.getReturnDate());

		final Borrow updatedBorrow = borrowRepository.save(borrow);
		return ResponseEntity.ok(updatedBorrow);
	}

	@PutMapping("/borrows/{id}/return")
	public ResponseEntity<Borrow> updateBorrow(@PathVariable(value = "id") Long borrowId)
			throws ResourceNotFoundException {
		Borrow borrow = borrowRepository.findById(borrowId)
				.orElseThrow(() -> new ResourceNotFoundException("Borrow not found for this id :: " + borrowId));

		borrow.setReturnDate(new Timestamp(System.currentTimeMillis()));

		final Borrow updatedBorrow = borrowRepository.save(borrow);
		return ResponseEntity.ok(updatedBorrow);
	}

	// delete borrow
	@DeleteMapping("/borrows/{id}")
	public Map<String, Boolean> deleteBorrow(@PathVariable(value = "id") Long borrowId)
			throws ResourceNotFoundException {
		Borrow borrow = borrowRepository.findById(borrowId)
				.orElseThrow(() -> new ResourceNotFoundException("Borrow not found for this id :: " + borrowId));

		borrowRepository.delete(borrow);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;

		/*
		 * // delete employee rest api
		 * 
		 * @DeleteMapping("/borrows/{id}") public ResponseEntity < Map < String, Boolean
		 * >> deleteBorrow(@PathVariable Long id) { Borrow borrow =
		 * borrowRepository.findById(id) .orElseThrow(() - > new
		 * ResourceNotFoundException("Borrow not exist with id :" + id));
		 * 
		 * borrowRepository.delete(borrow); Map < String, Boolean > response = new
		 * HashMap < > (); response.put("deleted", Boolean.TRUE); return
		 * ResponseEntity.ok(response);
		 */
	}

}
