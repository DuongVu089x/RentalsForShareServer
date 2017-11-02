package com.rentalsforshare.service;

import com.rentalsforshare.entity.Category;

public interface CategoryService {
	Category getByName(String name);
	
	Category getById(Integer id);
	
	boolean insertCategory(Category category) throws Exception;
	
	boolean updateCategory(Category category) throws Exception;
	
	boolean delete(Integer id) throws Exception;
}
