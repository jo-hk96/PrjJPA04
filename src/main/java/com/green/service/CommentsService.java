package com.green.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.green.dto.Comments;
import com.green.dto.CommentsDTO;
import com.green.dto.article;
import com.green.repository.ArticleRepository;
import com.green.repository.CommentsRepository;

@Service
public class CommentsService {

	@Autowired
	private CommentsRepository commentsRepository;
	
	
	@Autowired
	private ArticleRepository articleRepository;
	
	
	
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
	
	
	
	//댓글생성
	public CommentsDTO create(Long articleId, CommentsDTO commentsDto) {
        
        // 1. 게시글 조회 및 예외 처리
        article article = articleRepository.findById(articleId)
            .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        
        // 2. DTO를 엔티티로 변환
        Comments comment = commentsDto.toEntity(article); // DTO에 toEntity() 메서드 추가 필요!

        // 3. 엔티티를 저장
        Comments created = commentsRepository.save(comment);

        // 4. 저장된 엔티티를 다시 DTO로 변환해 반환
        return CommentsDTO.createCommentsDTO(created);
    }
	
	//댓글삭제
	public void delete(Long commentsId) {
		commentsRepository.deleteById(commentsId);
	}
	
	
	//댓글 수정
	@Transactional
	public CommentsDTO update(Long updateId , CommentsDTO commentsDto) {
		Comments target = commentsRepository.findById(updateId)
				.orElseThrow(() -> new IllegalArgumentException("해당댓글없음"));
		target.setNickname(commentsDto.getNickname());
		target.setBody(commentsDto.getBody());
		return CommentsDTO.createCommentsDTO(target);
		
	}
	
}
	
	
