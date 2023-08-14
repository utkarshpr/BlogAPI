package com.learn.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.entity.Users;
import com.learn.payloads.APIResponse;
import com.learn.payloads.UserDTO;
import com.learn.service.UserService;

@RestController
@RequestMapping("/api/users")
public class MainController {

	@Autowired
	private UserService userService;

	// post mapping

	@PostMapping("/")
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDto) {
		UserDTO createdUser = this.userService.createUser(userDto);
		return new ResponseEntity<UserDTO>(createdUser, HttpStatus.CREATED);
	}

	// Put update mapping

	@PutMapping("update/{id}")
	public ResponseEntity<UserDTO> update(@Valid @RequestBody UserDTO userDto, @PathVariable("id") int id) {
		UserDTO createdUser = this.userService.updateUser(userDto, id);
		return new ResponseEntity<UserDTO>(createdUser, HttpStatus.OK);
	}
	
	//Get all
	@GetMapping("getAll")
	public ResponseEntity<List<UserDTO>> getAll() {
		List<UserDTO> createdUser = this.userService.getAllUser();
		return new ResponseEntity<List<UserDTO>>(createdUser, HttpStatus.OK);
	}
	
	// get particular user
	@GetMapping("get/{id}")
	public ResponseEntity<UserDTO> getParticularUser(@PathVariable("id") int id) {
		UserDTO createdUser = this.userService.getUserById(id);
		return new ResponseEntity<UserDTO>(createdUser, HttpStatus.OK);
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<APIResponse> delete( @PathVariable("id") int id) {
		this.userService.deleteUser(id);
		return new ResponseEntity<APIResponse>(new APIResponse("User Got Deleted", true), HttpStatus.OK);
	}
	
	
	
}
