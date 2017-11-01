package com.rentalsforshare.service;

import com.rentalsforshare.entity.Customer;

public interface CustomerService {
	Customer getById(int id) throws Exception;

	Customer getByEmail(String email) throws Exception;

	boolean updateCustomer(Customer customer) throws Exception;

	boolean inserCustomer(Customer customer) throws Exception;

	boolean deleteCustomer(Integer id) throws Exception;

}
