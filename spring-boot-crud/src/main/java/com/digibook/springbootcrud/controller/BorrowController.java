package com.digibook.springbootcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digibook.springbootcrud.Exception.ResourceNotFoundException;
import com.digibook.springbootcrud.model.Borrow;
import com.digibook.springbootcrud.repository.BorrowRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//mark class as Controller  
@RestController
@RequestMapping("/api/v1")
public class BorrowController {
	 //autowire the BorrowService class
		@Autowired
		private BorrowRepository borrowRepository;
		
	    //get borrow. creating a get mapping that retrieves all the borrows detail from the database
		@GetMapping("/borrows")
		public List<Borrow> getAllBorrow() {    
		    return this.borrowRepository.findAll();
		}  
		
	   //get borrow by id
		@GetMapping("/borrows/{id}")
	    public ResponseEntity<Borrow> getBorrowById(@PathVariable(value = "id") Long borrowId)
	           throws ResourceNotFoundException {
			Borrow borrow = borrowRepository.findById(borrowId)
	           .orElseThrow(() -> new ResourceNotFoundException("Borrow not found for this id :: " + borrowId));
	        return ResponseEntity.ok().body(borrow);
	        
		}
		
		//save borrow
		@PostMapping("borrows")
		public Borrow createBorrow(@RequestBody Borrow borrow) {
			return this.borrowRepository.save(borrow);
			
		}
		
		//update borrow
		
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
		
		 //delete borrow
		@DeleteMapping("/borrows/{id}")
	    public Map<String, Boolean> deleteBorrow(@PathVariable(value = "id") Long borrowId)
	         throws ResourceNotFoundException {
			Borrow borrow = borrowRepository.findById(borrowId)
	       .orElseThrow(() -> new ResourceNotFoundException("Borrow not found for this id :: " + borrowId));

	        borrowRepository.delete(borrow);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
		}
		

}
