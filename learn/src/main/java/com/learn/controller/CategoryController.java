package com.learn.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.payloads.APIResponse;
import com.learn.payloads.CategoryDTO;
import com.learn.payloads.UserDTO;
import com.learn.service.CategoryService;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

	
	@Autowired
	private CategoryService categoryService;
	
	//create
	@PostMapping("/")
	public ResponseEntity<CategoryDTO> createCategories(@Valid @RequestBody CategoryDTO userDto) {
		CategoryDTO createdUser = this.categoryService.createUser(userDto);
		return new ResponseEntity<CategoryDTO>(createdUser, HttpStatus.CREATED);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<CategoryDTO> update(@Valid @RequestBody CategoryDTO userDto, @PathVariable("id") int id) {
		CategoryDTO createdUser = this.categoryService.updateUser(userDto, id);
		return new ResponseEntity<CategoryDTO>(createdUser, HttpStatus.OK);
	}
	
	//Get all
	@GetMapping("getAll")
	public ResponseEntity<List<CategoryDTO>> getAll() {
		List<CategoryDTO> createdUser = this.categoryService.getAllUser();
		return new ResponseEntity<List<CategoryDTO>>(createdUser, HttpStatus.OK);
	}
	
	// get particular user
	@GetMapping("get/{id}")
	public ResponseEntity<CategoryDTO> getParticularUser(@PathVariable("id") int id) {
		CategoryDTO createdUser = this.categoryService.getUserById(id);
		return new ResponseEntity<CategoryDTO>(createdUser, HttpStatus.OK);
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<APIResponse> delete( @PathVariable("id") int id) {
		this.categoryService.deleteUser(id);
		return new ResponseEntity<APIResponse>(new APIResponse("User Got Deleted", true), HttpStatus.OK);
	}
	
	
}
