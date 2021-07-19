package com.digibook.springbootcrud.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.digibook.springbootcrud.model.Users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository <Users, Long>{

	List<Users> findByEmail(String email);
	//public Users findByUsername(String username); 

	List<Users> findByEmailAndPassword(String email, String password);
		

}

