package com.learn.controller;

import java.security.Principal;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.entity.Users;
import com.learn.exceptions.ApiException;
import com.learn.exceptions.ResourceNotFoundException;
import com.learn.payloads.JwtAuthRequest;
import com.learn.payloads.JwtAuthResponse;
import com.learn.payloads.UserDTO;
import com.learn.repositary.UserRepo;
import com.learn.service.UserService;
import com.learn.service.Security.JwtTokenHelper;
@RestController
@RequestMapping("/api/v1/auth/")
public class AuthController {
	
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity< JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception
	{
		this.authenicate(request.getUsername(),request.getPassword());
		UserDetails loadUserByUsername = this.userDetailsService.loadUserByUsername(request.getUsername());
		String generateToken = this.jwtTokenHelper.generateToken( loadUserByUsername);
		
		JwtAuthResponse response=new JwtAuthResponse();
		response.setToken(generateToken);
		return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);
	}

	private void authenicate(String username, String password) throws Exception {
		
		UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(username, password);
		
		try {
		this.authenticationManager.authenticate(authenticationToken);
		}
		catch(BadCredentialsException e) {
			
			 throw new ResourceNotFoundException("password is invlaid", password, 0);
		}
		
		
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<UserDTO> registerUser(@Valid @RequestBody UserDTO userDto) {
		UserDTO registeredUser = this.userService.registerNewUser(userDto);
		return new ResponseEntity<UserDTO>(registeredUser, HttpStatus.CREATED);
	}

}
