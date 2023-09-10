package com.learn.repositary;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.entity.Users;

public interface UserRepo  extends JpaRepository<Users, Integer>{

	Optional<Users> findByEmailId(String emailId);
}
