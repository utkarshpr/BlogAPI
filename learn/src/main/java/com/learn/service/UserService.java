package com.learn.service;

import java.util.List;

import com.learn.payloads.UserDTO;

public interface UserService {

	//register 
	UserDTO registerNewUser(UserDTO user);
	
	UserDTO createUser(UserDTO user);
	UserDTO updateUser(UserDTO user, Integer userId);
	UserDTO getUserById(Integer userId);
	List<UserDTO> getAllUser();
	void deleteUser(Integer userId);
}
