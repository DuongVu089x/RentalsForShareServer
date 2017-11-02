package com.rentalsforshare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.rentalsforshare.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	Category getByName(String name);
	
	Category getById(Integer id);
	
//	@Modifying
//	void insert(Category category) throws Exception;
	
}
