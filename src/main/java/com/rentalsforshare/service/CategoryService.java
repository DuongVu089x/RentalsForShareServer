package com.rentalsforshare.service;

import com.rentalsforshare.entity.Category;

public interface CategoryService {
	Category getByName(String name);
	
	Category getById(Integer id);
	
	void insertCategory(Category category) throws Exception;
	
	void delete(Integer id) throws Exception;
}
