package com.rentalsforshare.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rentalsforshare.common.util.Constants;
import com.rentalsforshare.entity.Category;
import com.rentalsforshare.service.CategoryService;

@RestController
@RequestMapping("api/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/get-by-name", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> getByName(@RequestBody Category data) throws Exception {
		Category category = categoryService.getByName(data.getName());
		if (category != null) {
			return new ResponseEntity<>(category, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	@RequestMapping(value = "/get-by-id", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> getById(@RequestBody Category data) throws Exception {
		Category category = categoryService.getById(data.getId());
		if (category != null) {
			return new ResponseEntity<>(data, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> insert(@RequestBody Category data) throws Exception {
		// System.out.println(data.getName());
		if (categoryService.getByName(data.getName()) != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

		if (categoryService.insertCategory(data)) {
			Map<String, String> result = new HashMap<>();
			result.put(Constants.STR_RESULT, Constants.STR_INSERT_SUCCESS);
			return new ResponseEntity<>(result, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> updateCategory(@RequestParam(required = true, defaultValue = "0", value = "id") int id,
			@RequestBody Category data) throws Exception {
		if (categoryService.getById(id) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if (categoryService.updateCategory(data)) {
			Map<String, String> result = new HashMap<>();
			result.put(Constants.STR_RESULT, Constants.STR_UPDATE_SUCCESS);
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> deleteCategory(@RequestParam(required = true, defaultValue = "0", value = "id") int id)
			throws Exception {
		if (categoryService.getById(id) != null) {
			if (categoryService.delete(id)) {
				Map<String, String> result = new HashMap<>();
				result.put(Constants.STR_RESULT, Constants.STR_DELETE_SUCCESS);
				return new ResponseEntity<>(result, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
	
	@RequestMapping(value = "/get-by-page-and-keyword", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?>  getByPageAndKeyword(
			@RequestParam(required = true, defaultValue = "0", value = "page") int page,
			@RequestParam(required = true, defaultValue = "", value = "filter") String filter) throws Exception {
		return new ResponseEntity<>(categoryService.getByPageAndKeyword(page, filter),HttpStatus.NOT_FOUND);
	}
}