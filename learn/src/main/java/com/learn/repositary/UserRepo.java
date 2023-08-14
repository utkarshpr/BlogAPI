package com.learn.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.entity.Users;

public interface UserRepo  extends JpaRepository<Users, Integer>{

}
