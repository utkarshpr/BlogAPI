package com.learn.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
