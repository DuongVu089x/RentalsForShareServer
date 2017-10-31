package com.rentalsforshare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentalsforshare.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
