package com.rentalsforshare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.rentalsforshare.entity.Vote;
import com.rentalsforshare.repository.VoteRepository;
import com.rentalsforshare.service.VoteService;

@Service
public class VoteServiceImpl implements VoteService {
	
	@Autowired
	private VoteRepository voteRepository;
	
	@Override
	public Vote getById(Integer id)
	{
		return voteRepository.getById(id);
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean insertVote(Vote vote) throws Exception
	{
		return voteRepository.saveAndFlush(vote) != null ? true : false;
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean updateVote(Vote vote) throws Exception
	{
		return voteRepository.save(vote) != null ? true : false;
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean delete(Integer id) throws Exception
	{
		boolean result = false;
		try {
			voteRepository.delete(id);
			result = true;
		} catch (Exception e) {
			throw (e);
		}
		return result;
		
	}

}
