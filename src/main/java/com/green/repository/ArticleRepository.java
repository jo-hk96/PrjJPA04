package com.green.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.green.dto.article;



@Repository
public interface ArticleRepository extends CrudRepository<article , Long> {
	
}