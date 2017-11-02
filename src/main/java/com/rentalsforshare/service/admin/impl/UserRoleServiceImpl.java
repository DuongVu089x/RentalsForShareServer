package com.rentalsforshare.service.admin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentalsforshare.repository.admin.UserRoleRepository;
import com.rentalsforshare.service.admin.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	
	@Autowired
	private UserRoleRepository userRoleRepository;

}
