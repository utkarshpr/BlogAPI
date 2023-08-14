package com.learn.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.entity.Category;
import com.learn.exceptions.ResourceNotFoundException;
import com.learn.payloads.CategoryDTO;
import com.learn.repositary.CategoryRepo;
import com.learn.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo cRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDTO createUser(CategoryDTO categoryDto) {
		Category category = dtoTouser(categoryDto);
		Category savedcategory = this.cRepo.save(category);
		return this.usersTousetDto(savedcategory);
	}

	@Override
	public CategoryDTO updateUser(CategoryDTO categoryDTO, Integer userId) {
		Category users = this.cRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("users", "id", userId));
				
		users.setCategoryDesc(categoryDTO.getCategoryDesc());
		users.setCategoryTitle(categoryDTO.getCategoryTitle());
		Category updatedUser = this.cRepo.save(users);
		return this.usersTousetDto(updatedUser);
	}

	@Override
	public CategoryDTO getUserById(Integer userId) {
		Category getusers = this.cRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "id", userId));
		return this.usersTousetDto(getusers);
	}

	@Override
	public List<CategoryDTO> getAllUser() {
		List<Category> userDtoList = this.cRepo.findAll();
		List<CategoryDTO> listofUserDto = userDtoList.stream().map(user -> this.usersTousetDto(user))
				.collect(Collectors.toList());
		return listofUserDto;
	}

	@Override
	public void deleteUser(Integer userId) {
		Category getusers = this.cRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		this.cRepo.delete(getusers);

	}

	private Category dtoTouser(CategoryDTO cdto) {
		Category users = this.modelMapper.map(cdto, Category.class);
		return users;

	}

	private CategoryDTO usersTousetDto(Category userDto) {
		CategoryDTO users = this.modelMapper.map(userDto, CategoryDTO.class);
		return users;
	}

}
