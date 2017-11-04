package com.rentalsforshare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rentalsforshare.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
	
	Comment getById(Integer id);
	
	
	
	

}
