package com.learn.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.entity.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
