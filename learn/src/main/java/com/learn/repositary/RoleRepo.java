package com.learn.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
