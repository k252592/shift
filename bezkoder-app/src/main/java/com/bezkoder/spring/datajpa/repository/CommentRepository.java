package com.bezkoder.spring.datajpa.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.datajpa.model.Comment;

public interface CommentRepository extends JpaRepository <Comment, Long> {

}