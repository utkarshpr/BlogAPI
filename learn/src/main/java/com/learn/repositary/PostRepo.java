package com.learn.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.learn.entity.Category;
import com.learn.entity.Post;
import com.learn.entity.Users;

public interface PostRepo extends JpaRepository<Post, Integer>{
	List<Post> findByUser(Users user);
	List<Post> findByCategory(Category category);	
	
	@Query("select p from Post p where p.title like :key")
	List<Post> searchByTitle(@Param("key") String title);
}
