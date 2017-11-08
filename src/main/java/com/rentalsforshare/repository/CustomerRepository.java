package com.rentalsforshare.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.rentalsforshare.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	@Query("FROM Customer c WHERE c.email LIKE %:keyword%")
	Page<Customer> getByPageAndKeyword(@Param("keyword")String filter, Pageable pageable);
	
	Customer findByEmail(String email);
	
}
