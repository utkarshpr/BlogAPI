package com.learn.service;

import java.util.List;

import com.learn.payloads.CategoryDTO;

public interface CategoryService {
	CategoryDTO createUser(CategoryDTO category);
	CategoryDTO updateUser(CategoryDTO category, Integer userId);
	CategoryDTO getUserById(Integer userId);
	List<CategoryDTO> getAllUser();
	void deleteUser(Integer userId);
}
