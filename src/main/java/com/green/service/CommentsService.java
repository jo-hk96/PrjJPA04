package com.green.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.dto.ArticleDTO;
import com.green.dto.Comments;
import com.green.dto.article;
import com.green.repository.CommentsRepository;

@Service
public class CommentsService {

	@Autowired
	private CommentsRepository commentsRepository;

	
	
	//id에 해당하는 댓글 리스트
	public List<Comments> getComments(Long id) {
		List<Comments> comments = commentsRepository.findByArticleId(id);
	
		return comments;
		
		
	}
	
//  닉네임의 해당하는 댓글 리스트
//	public List <Comments> getNickname(String nickname){
//		List<Comments> commentsNickname = commentsRepository.findByNickName(nickname);
//		
//		return commentsNickname;
//	}
	
	
	
}
