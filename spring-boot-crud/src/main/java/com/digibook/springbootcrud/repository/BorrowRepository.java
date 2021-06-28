package com.digibook.springbootcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.digibook.springbootcrud.model.Borrow;

@Repository
public interface BorrowRepository extends JpaRepository <Borrow, Long> {

}
