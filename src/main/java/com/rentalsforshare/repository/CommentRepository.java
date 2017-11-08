package com.rentalsforshare.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rentalsforshare.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
	
	@Query("FROM Comment c WHERE c.message LIKE %:keyword%")
	Page<Comment> getByPageAndKeyword(@Param("keyword")String filter, Pageable pageable);
	
	
	Comment getById(Integer id);
	
	
	
	

}
