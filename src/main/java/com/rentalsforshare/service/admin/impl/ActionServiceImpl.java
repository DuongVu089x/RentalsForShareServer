package com.rentalsforshare.service.admin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentalsforshare.entity.admin.Action;
import com.rentalsforshare.repository.admin.ActionRepository;
import com.rentalsforshare.service.admin.ActionService;

@Service
public class ActionServiceImpl implements ActionService {
	
	@Autowired
	private ActionRepository actionRepository;

	@Override
	public Action getByName(String name) {
		return actionRepository.getByName(name);
	}


}
