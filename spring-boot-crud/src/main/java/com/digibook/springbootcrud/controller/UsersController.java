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
import com.digibook.springbootcrud.model.Users;
import com.digibook.springbootcrud.repository.UsersRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:3000" , "http://localhost:8080"})
@RestController
@RequestMapping("/api/v1")
public class UsersController {

	// autowire the UsersService class
	@Autowired
	private UsersRepository usersRepository;

	// get user. creating a get mapping that retrieves all the users detail from the
	// database
	@GetMapping("/users")
	public List<Users> getAllusers() {
		return this.usersRepository.findAll();
	}

	// get user by id
	@GetMapping("/users/{id}")
	public ResponseEntity<Users> getUsersById(@PathVariable(value = "id") Long usersId)
			throws ResourceNotFoundException {
		Users users = usersRepository.findById(usersId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + usersId));
		return ResponseEntity.ok().body(users);
	}

	// save user
	@PostMapping("users")
	public Users createUsers(@RequestBody Users users) {
		// check if user exist
		List<Users> existingUser = this.usersRepository.findByEmail(users.getEmail());
		if (existingUser!=null && !existingUser.isEmpty()) {
			return existingUser.get(0);
		} else {
			// if yes - dont save- return existing user
			// else: save to DB
			return this.usersRepository.save(users);
		}
	}
	
	// login user
		@PostMapping("users/login")
		public Users loginUser(@RequestBody Users users) {
			// check if user exist
			List<Users> loginUser = this.usersRepository.findByEmailAndPassword(users.getEmail(), users.getPassword());
			if (loginUser!=null && !loginUser.isEmpty()) {
				return loginUser.get(0);
			} else {
				// if yes - dont save- return existing user
				// else: save to DB
				return this.usersRepository.save(users);
			}
		}

	// update book
	@PutMapping("/users/{id}")
	public ResponseEntity<Users> updateUsers(@PathVariable(value = "id") Long usersId,
			@Validated @RequestBody Users usersDetails) throws ResourceNotFoundException {
		Users users = usersRepository.findById(usersId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + usersId));

		users.setFirstName(usersDetails.getFirstName());
		users.setLastName(usersDetails.getLastName());
		users.setStreet(usersDetails.getStreet());
		users.setCity(usersDetails.getCity());
		users.setCountry(usersDetails.getCountry());
		users.setZipcode(usersDetails.getZipcode());
		users.setTelephone(usersDetails.getTelephone());
		users.setEmail(usersDetails.getEmail());
		users.setUserName(usersDetails.getUserName());
		users.setPassword(usersDetails.getPassword());
		users.setJoinedDate(usersDetails.getJoinedDate());

		final Users updatedUsers = usersRepository.save(users);
		return ResponseEntity.ok(updatedUsers);
	}

	// delete user
	@DeleteMapping("/users/{id}")
	public Map<String, Boolean> deleteUsers(@PathVariable(value = "id") Long usersId) throws ResourceNotFoundException {
		Users users = usersRepository.findById(usersId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + usersId));

		usersRepository.delete(users);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
