package com.rentalsforshare.service;

import org.springframework.data.domain.Page;


import com.rentalsforshare.entity.Comment;

public interface CommentService  {
	
	Page<Comment> getByPageAndKeyword(int page, String filter) throws Exception;
	
	Comment getById(Integer id);
	
	boolean insertComment(Comment comment) throws Exception;
	boolean updateComment(Comment comment) throws Exception;
	boolean delete(Integer id) throws Exception;
}
