package com.rentalsforshare.service;

import org.springframework.data.domain.Page;

import com.rentalsforshare.entity.Category;

public interface CategoryService {

	Page<Category> getByPageAndKeyword(int page, String filter) throws Exception;

	Category getByName(String name) throws Exception;

	Category getById(Integer id) throws Exception;

	boolean insertCategory(Category category) throws Exception;

	boolean updateCategory(Category category) throws Exception;

	boolean delete(Integer id) throws Exception;
}
