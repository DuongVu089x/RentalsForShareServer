package com.rentalsforshare.controller;

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
import com.rentalsforshare.entity.Category;

import com.rentalsforshare.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired 
	private CategoryService categoryService;
	
	@RequestMapping(value = "/get-by-name", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> getByName(@RequestBody Category data) throws Exception {
		//System.out.println(data.getName());
		Category category = categoryService.getByName(data.getName());			
		
		if (category != null) {
			return new ResponseEntity<>(category,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}
	
	@RequestMapping(value = "/get-by-id", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> getById(@RequestBody Category data) throws Exception {
		System.out.println(data.getName());
		Category category = categoryService.getById(data.getId());
		
		
		if (category != null) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> insert(@RequestBody Category data) throws Exception  {
		//System.out.println(data.getName());	
		if(categoryService.getByName(data.getName()) != null)
		{
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		if(categoryService.insertCategory(data))
		{
			return new ResponseEntity<>(new String ("Insert success"), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		
	}
	@RequestMapping(value = "/insert", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> updateCategory(@RequestParam(required = true, defaultValue = "0", value = "id") int id,
			 		@RequestBody Category data) throws Exception 
	{
		if(categoryService.getById(id) == null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if(categoryService.updateCategory(data))
		{
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> deleteCategory(@RequestParam(required = true, defaultValue = "0", value = "id") int id) throws Exception  {
		if(categoryService.getById(id) != null)
		{
			if(categoryService.delete(id))
			{
				return new ResponseEntity<>(new String("Delete success"), HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
		
	}
	
}