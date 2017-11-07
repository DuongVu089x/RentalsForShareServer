package com.rentalsforshare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rentalsforshare.common.util.Constants;
import com.rentalsforshare.entity.Category;
import com.rentalsforshare.repository.CategoryRepository;
import com.rentalsforshare.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	@Transactional(readOnly = true)
	public Category getByName(String name) throws Exception {
		return categoryRepository.getByName(name);
	}

	@Override
	@Transactional(readOnly = true)
	public Category getById(Integer id) throws Exception {
		return categoryRepository.getById(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean insertCategory(Category category) throws Exception {
		return categoryRepository.saveAndFlush(category) != null ? true : false;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean updateCategory(Category category) throws Exception {
		return categoryRepository.save(category) != null ? true : false;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean delete(Integer id) throws Exception {
		boolean result = false;
		try {
			categoryRepository.delete(id);
			result = true;
		} catch (Exception e) {
			throw (e);
		}
		return result;

	}

	@Override
	public Page<Category> getByPageAndKeyword(int page,  String filter) throws Exception {
		PageRequest request = new PageRequest(page - 1, Constants.PAGE_SIZE, Sort.Direction.ASC, "id");
		return categoryRepository.getByPageAndKeyword(filter, request);
	}
}
