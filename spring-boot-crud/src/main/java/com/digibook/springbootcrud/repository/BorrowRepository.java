package com.digibook.springbootcrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.digibook.springbootcrud.model.Borrow;
import com.digibook.springbootcrud.model.Users;

@Repository
public interface BorrowRepository extends JpaRepository <Borrow, Long> {
	
	List< Borrow >findByReturnDateIsNull();

	List<Borrow> findByReturnDateIsNullAndUsers(Users user);
	

}
