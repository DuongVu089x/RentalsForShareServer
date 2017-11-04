package com.rentalsforshare.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rentalsforshare.common.util.Constants;
import com.rentalsforshare.entity.Comment;
import com.rentalsforshare.entity.Vote;
import com.rentalsforshare.service.CommentService;
import com.rentalsforshare.service.VoteService;

@RestController
@RequestMapping("api/vote")
public class VoteController {
	@Autowired
	private VoteService voteService;
	
	
	@RequestMapping(value = "/get-by-id", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> getById(@RequestBody Vote data) throws Exception {
		Vote vote = voteService.getById(data.getId());
		if (vote != null) {
			return new ResponseEntity<>(data, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> insert(@RequestBody Vote data) throws Exception {
		
		/*CHECK SOMETHING HERE?*/
		
		
		if (voteService.insertVote(data)) {
			Map<String, String> result = new HashMap<>();
			result.put(Constants.STR_RESULT, Constants.STR_INSERT_SUCCESS);
			return new ResponseEntity<>(result, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> updateCommnet(@RequestParam(required = true, defaultValue = "0", value = "id") int id,
			@RequestBody Vote data) throws Exception {
		if (voteService.getById(id) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if (voteService.updateVote(data)) {
			Map<String, String> result = new HashMap<>();
			result.put(Constants.STR_RESULT, Constants.STR_UPDATE_SUCCESS);
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> deleteComment(@RequestParam(required = true, defaultValue = "0", value = "id") int id)
			throws Exception {
		if (voteService.getById(id) != null) {
			if (voteService.delete(id)) {
				Map<String, String> result = new HashMap<>();
				result.put(Constants.STR_RESULT, Constants.STR_DELETE_SUCCESS);
				return new ResponseEntity<>(result, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
}
