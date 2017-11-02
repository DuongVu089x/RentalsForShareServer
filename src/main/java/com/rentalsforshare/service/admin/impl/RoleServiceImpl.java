package com.rentalsforshare.service.admin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentalsforshare.entity.admin.Role;
import com.rentalsforshare.repository.admin.RoleRepository;
import com.rentalsforshare.service.admin.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role getByName(String name) {
		return roleRepository.getByName(name);
	}


}
