package com.rentalsforshare.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rentalsforshare.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	@Query("FROM Category c WHERE c.name LIKE %:keyword%")
	Page<Category> getByPageAndKeyword(@Param("keyword")String filter, Pageable pageable);
	
	Category getByName(String name);
	
	Category getById(Integer id);
	
//	@Modifying
//	void insert(Category category) throws Exception;
	
}
