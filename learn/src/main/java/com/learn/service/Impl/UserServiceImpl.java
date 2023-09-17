package com.learn.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.learn.exceptions.ResourceNotFoundException;
import com.learn.config.AppConstants;
import com.learn.entity.Role;
import com.learn.entity.Users;
import com.learn.payloads.UserDTO;
import com.learn.repositary.RoleRepo;
import com.learn.repositary.UserRepo;
import com.learn.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RoleRepo roleRepo;
	@Override
	public UserDTO createUser(UserDTO user) {
		Users users = dtoTouser(user);
		Users saveduser = this.userRepo.save(users);
		return this.usersTousetDto(saveduser);
	}

	@Override
	public UserDTO updateUser(UserDTO userDto, Integer userId) {
		Users users = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		users.setAbout(userDto.getAbout());
		users.setEmailId(userDto.getEmailId());
		users.setName(userDto.getName());
		users.setPassword(userDto.getPassword());
		Users updatedUser = this.userRepo.save(users);
		return this.usersTousetDto(updatedUser);
	}

	@Override
	public UserDTO getUserById(Integer userId) {
		Users getusers = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		return this.usersTousetDto(getusers);
	}

	@Override
	public List<UserDTO> getAllUser() {
		List<Users> userDtoList = this.userRepo.findAll();
		List<UserDTO> listofUserDto = userDtoList.stream().map(user -> this.usersTousetDto(user))
				.collect(Collectors.toList());
		return listofUserDto;
	}

	@Override
	public void deleteUser(Integer userId) {
		Users getusers = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		this.userRepo.delete(getusers);

	}

	private Users dtoTouser(UserDTO userDto) {
		Users users =this.modelMapper.map(userDto, Users.class);
//		users.setId(userDto.getId());
//		users.setAbout(userDto.getAbout());
//		users.setEmailId(userDto.getEmailId());
//		users.setName(userDto.getName());
//		users.setPassword(userDto.getPassword());
		return users;

	}

	private UserDTO usersTousetDto(Users userDto) {
		UserDTO users = this.modelMapper.map(userDto, UserDTO.class);
//		users.setId(userDto.getId());
//		users.setAbout(userDto.getAbout());
//		users.setEmailId(userDto.getEmailId());
//		users.setName(userDto.getName());
//		users.setPassword(userDto.getPassword());
		return users;
	}

	@Override
	public UserDTO registerNewUser(UserDTO userDto) {
		Users user = this.modelMapper.map(userDto, Users.class);
		// encoded the password
				user.setPassword(this.passwordEncoder.encode(user.getPassword()));

				// roles
				Role role = this.roleRepo.findById(AppConstants.NORMAL_USER).get();

				user.getRoles().add(role);

				Users newUser = this.userRepo.save(user);

				return this.modelMapper.map(newUser, UserDTO.class);

		
	}

}
