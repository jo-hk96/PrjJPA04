package com.green.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.green.dto.CommentsDTO;
import com.green.repository.CommentsRepository;
import com.green.service.CommentsService;

@RestController
public class CommentAPIController {
		
	
	@Autowired
	private CommentsRepository commentsRepository; 
	
	@Autowired
	private CommentsService commentsService; 
	
	
	//댓글 쓰기
	@PostMapping("/api/articles/{articleId}/comments")
	public ResponseEntity<CommentsDTO> create (@PathVariable("articleId") Long articleId,
											@RequestBody CommentsDTO commentsDto){
		
		// 서비스로  DTO와 게시글 ID를 전달
		CommentsDTO createdDto =  commentsService.create(articleId, commentsDto);
	
		return ResponseEntity.ok(createdDto);
	}
	
	
	//댓글 삭제
	 @DeleteMapping("/api/articles/comments/{commentId}")
	    public ResponseEntity<Void> delete(@PathVariable Long commentId) {
	        commentsService.delete(commentId);
	        
	        // HTTP 상태 코드 204(No Content)를 반환하여
	        // 삭제가 성공했음을 명확히 알림
	        return ResponseEntity.noContent().build();
	 }
	
	 
	//댓글 수정
	 @PatchMapping("/api/articles/comments/{updateId}")
	 public ResponseEntity<CommentsDTO> update(@PathVariable("updateId") Long updateId,
			 								   @RequestBody CommentsDTO commentsDto){
	CommentsDTO updateDto = commentsService.update(updateId ,commentsDto);	 
	return ResponseEntity.ok(updateDto);
}
	
	
	
	
	
	
	
	
}
