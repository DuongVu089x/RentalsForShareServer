package com.rentalsforshare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rentalsforshare.entity.Category;
import com.rentalsforshare.repository.CategoryRepository;
import com.rentalsforshare.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category getByName(String name){
		return categoryRepository.getByName(name);
	}
	
	@Override
	public Category getById(Integer id){
		return categoryRepository.getById(id);
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertCategory(Category category) throws Exception
	{
		categoryRepository.save(category);
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delete(Integer id) throws Exception
	{
		categoryRepository.delete(id);
	}
}
