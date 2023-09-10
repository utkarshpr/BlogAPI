package com.learn.service.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learn.entity.Users;
import com.learn.exceptions.ResourceNotFoundException;
import com.learn.repositary.UserRepo;



@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = this.userRepo.findByEmailId(username).orElseThrow(
				()-> new ResourceNotFoundException("User ", " email : " + username, 0));
				
				
				//.orElseThrow(()-> new ResourceNotFoundException("User ", " email : " + username, 0));

		return user;
	}

	

}