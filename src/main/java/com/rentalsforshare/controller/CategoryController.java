package com.rentalsforshare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rentalsforshare.entity.Category;

import com.rentalsforshare.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired 
	private CategoryService categoryService;
	
	@RequestMapping(value = "/get-by-name", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> getByName(@RequestBody Category data) throws Exception {
		System.out.println(data.getName());
		Category category = categoryService.getByName(data.getName());	
		
		
		if (category != null) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
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
	public String insert(@RequestBody Category data)  {
		System.out.println(data.getName());			
			try {
				categoryService.insertCategory(data);
				return "Success";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "Fail";
			}
			
		
		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public String insert(@RequestBody Integer id) throws Exception  {
		Category category = categoryService.getById(id);
		System.out.println(category.getName());
		if(category != null)
		{
			String ms = "Delete student " + category.getName();
			//categoryService.delete(id);
			
			return ms;
		}
		else
			return "Not found";
		
		
	}
	
}