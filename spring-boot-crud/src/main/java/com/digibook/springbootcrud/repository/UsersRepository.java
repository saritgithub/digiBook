package com.digibook.springbootcrud.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.digibook.springbootcrud.model.Users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository <Users, Long>{
	//public Users findByUsername(String username); 
		

}

