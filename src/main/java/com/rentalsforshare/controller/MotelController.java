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
import com.rentalsforshare.entity.Motel;
import com.rentalsforshare.service.MotelService;

@RestController
@RequestMapping("/api/motel")
public class MotelController {

	@Autowired
	private MotelService motelService;

	@RequestMapping(value = "/get-by-page-and-keyword", params = { "keyword", "page" }, method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> search(@RequestParam(value = "keyword") String keyword,
			@RequestParam(value = "page") int page) throws Exception {
		return new ResponseEntity<>(motelService.searchByPageAndKeyword(keyword, page), HttpStatus.OK);

	}

	@RequestMapping(value = "/get-by-id", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> getById(@RequestParam(required = true, defaultValue = "0", value = "id") int id)
			throws Exception {
		Motel motel = motelService.getById(id);
		if (motel != null) {
			return new ResponseEntity<>(motel, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/* CITY */
	@RequestMapping(value = "/get-by-city", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> getByCity(@RequestBody Motel data) throws Exception {
		Motel motel = motelService.getByCity(data.getCity());
		if (motel != null) {
			return new ResponseEntity<>(motel, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	/* WARD */
	@RequestMapping(value = "/get-by-ward", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> getByWard(@RequestBody Motel data) throws Exception {
		Motel motel = motelService.getByCity(data.getWard());
		if (motel != null) {
			return new ResponseEntity<>(motel, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	/* STREET */
	@RequestMapping(value = "/get-by-street", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> getByStreet(@RequestBody Motel data) throws Exception {
		Motel motel = motelService.getByStreet(data.getStreet());
		if (motel != null) {
			return new ResponseEntity<>(motel, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> insert(@RequestBody Motel data) throws Exception {

		/* CHECK SOMETHING HERE? */
		if (motelService.getByAddress(data.getAddress()) != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

		if (motelService.insertMotel(data)) {
			Map<String, String> result = new HashMap<>();
			result.put(Constants.STR_RESULT, Constants.STR_INSERT_SUCCESS);
			return new ResponseEntity<>(result, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> updateMotel(@RequestParam(required = true, defaultValue = "0", value = "id") int id,
			@RequestBody Motel data) throws Exception {
		if (motelService.getById(id) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if (motelService.updateMotel(data)) {
			Map<String, String> result = new HashMap<>();
			result.put(Constants.STR_RESULT, Constants.STR_UPDATE_SUCCESS);
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> deleteMotel(@RequestParam(required = true, defaultValue = "0", value = "id") int id)
			throws Exception {
		if (motelService.getById(id) != null) {
			if (motelService.delete(id)) {
				Map<String, String> result = new HashMap<>();
				result.put(Constants.STR_RESULT, Constants.STR_DELETE_SUCCESS);
				return new ResponseEntity<>(result, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

}
