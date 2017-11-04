package com.rentalsforshare.service;

import com.rentalsforshare.entity.Comment;

public interface CommentService  {
	
	Comment getById(Integer id);
	
	boolean insertComment(Comment comment) throws Exception;
	boolean updateComment(Comment comment) throws Exception;
	boolean delete(Integer id) throws Exception;
}
