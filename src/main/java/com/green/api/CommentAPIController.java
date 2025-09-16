package com.green.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.green.dto.Comments;
import com.green.repository.CommentsRepository;

@RestController
public class CommentAPIController {
		
	
	@Autowired
	private CommentsRepository commentsRepository; 
	
	
	//댓글 쓰기
	@PostMapping("/api/articles/{articleId}/comments")
	public ResponseEntity<Comments> create (@PathVariable("articleId") Long articleId, Comments comments){
	Comments created = commentsRepository.save( comments);
		System.out.println(comments);
	
		return ResponseEntity.ok(created);
	}
	
	
	
	//댓글 수정
	
	
	
	
	
	//댓글 삭제
	
	
	
	
	
	
}
