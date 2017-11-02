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
	public boolean insertCategory(Category category) throws Exception
	{
		return categoryRepository.saveAndFlush(category) != null ? true : false;
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean updateCategory(Category category) throws Exception
	{
		return categoryRepository.save(category) != null ? true : false;
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean delete(Integer id) throws Exception
	{
		boolean result = false;
		try {
			categoryRepository.delete(id);
			result = true;
		} catch (Exception e) {
			throw (e);
		}
		return result;
		
	}
}
