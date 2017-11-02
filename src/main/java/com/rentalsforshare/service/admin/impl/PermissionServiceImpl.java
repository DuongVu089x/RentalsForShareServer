package com.rentalsforshare.service.admin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentalsforshare.repository.admin.PermissionRepository;
import com.rentalsforshare.service.admin.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService{
	
	@Autowired
	private PermissionRepository permissionRepository;

}
