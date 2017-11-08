package com.rentalsforshare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rentalsforshare.common.util.Constants;
import com.rentalsforshare.entity.Category;
import com.rentalsforshare.entity.Customer;
import com.rentalsforshare.entity.admin.User;
import com.rentalsforshare.repository.CustomerRepository;
import com.rentalsforshare.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	@Transactional(readOnly = true)
	public Customer getByEmail(String email) throws Exception {
		return customerRepository.findByEmail(email);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean updateCustomer(Customer customer) throws Exception {
		return customerRepository.save(customer) != null ? true : false;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean inserCustomer(Customer customer) throws Exception {
		return customerRepository.saveAndFlush(customer) != null ? true : false;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean deleteCustomer(Integer id) throws Exception {
		boolean result = false;
		try {
			customerRepository.delete(id);
			result = true;
		} catch (Exception ex) {
			throw (ex);
		}
		return result;
	}

	@Override
	public Customer getById(int id) throws Exception {
		return customerRepository.findOne(id);
	}


	@Override
	public Page<Customer> getByPageAndKeyword(int page,  String filter) throws Exception {
		PageRequest request = new PageRequest(page - 1, Constants.PAGE_SIZE, Sort.Direction.ASC, "id");
		return customerRepository.getByPageAndKeyword(filter, request);
	}
}
