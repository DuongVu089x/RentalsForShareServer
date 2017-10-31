package com.rentalsforshare.service.admin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentalsforshare.entity.admin.User;
import com.rentalsforshare.repository.admin.UserRepository;
import com.rentalsforshare.service.admin.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User getByEmail(String email) {
		return userRepository.getByEmail(email);
	}

}
