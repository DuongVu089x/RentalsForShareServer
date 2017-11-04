package com.rentalsforshare.service;

import com.rentalsforshare.entity.Vote;

public interface VoteService {
	
	Vote getById(Integer id);
	
	boolean insertVote(Vote vote) throws Exception;
	
	boolean updateVote(Vote vote) throws Exception;
	
	boolean delete(Integer id) throws Exception;
	
	

}
