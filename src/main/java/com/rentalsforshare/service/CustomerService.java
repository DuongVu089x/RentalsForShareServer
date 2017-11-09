package com.rentalsforshare.service;

import org.springframework.data.domain.Page;

import com.rentalsforshare.entity.Customer;

public interface CustomerService {
	
	Page<Customer> getByPageAndKeyword(int page, String filter) throws Exception;
	
	Customer getById(int id) throws Exception;

	Customer getByEmail(String email) throws Exception;

	boolean updateCustomer(Customer customer) throws Exception;

	boolean inserCustomer(Customer customer) throws Exception;

	boolean deleteCustomer(Integer id) throws Exception;

}
