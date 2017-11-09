package com.rentalsforshare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rentalsforshare.common.util.Constants;

import com.rentalsforshare.entity.Comment;
import com.rentalsforshare.repository.CommentRepository;
import com.rentalsforshare.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Override
	public Comment getById(Integer id)
	{
		return commentRepository.getById(id);
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean insertComment(Comment comment) throws Exception
	{
		return commentRepository.saveAndFlush(comment) != null ? true : false;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean updateComment(Comment comment) throws Exception
	{
		return commentRepository.save(comment) != null ? true : false;
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean delete(Integer id) throws Exception
	{
		boolean result = false;
		try {
			commentRepository.delete(id);
			result = true;
		} catch (Exception e) {
			throw (e);
		}
		return result;
	}
	

	@Override
	public Page<Comment> getByPageAndKeyword(int page,  String filter) throws Exception {
		PageRequest request = new PageRequest(page - 1, Constants.PAGE_SIZE, Sort.Direction.ASC, "id");
		return commentRepository.getByPageAndKeyword(filter, request);
	}
}
