package com.green.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.green.dto.ArticleDTO;
import com.green.dto.article;
import com.green.repository.ArticleRepository;

@Service
public class ArticleService {

	@Autowired
	public ArticleRepository articleRepository;
	
	
	
	
	//게시글 목록
	public Iterable<article> getList(){
	
	Iterable<article> arList = articleRepository.findAll();
	return arList;
	
	}	
	
	//id의 해당하는 리스트 가져오기
	public Optional<article> getById(Long getId){
		return articleRepository.findById(getId);
		
	}	
	
	
	//게시글 추가
	public article create(ArticleDTO articleDTO) {
	    // 1. DTO를 Entity로 변환
	    article article = articleDTO.toEntity();

	    // 2. ID가 이미 있으면 null 반환 (새로운 글을 만들 때 같은 ID가 있으면 안됨)
	    if (article.getId() != null) {
	        return null;
	    }

	    // 3. Entity를 저장하고, 저장된 Entity를 saved 변수에 할당
	    article saved = articleRepository.save(article);
	    
	    // 4. 저장된 Entity 반환
	    return saved; 
	}
	
	
	//게시글 수정
	public article update(Long updateId, ArticleDTO articleDTO) {
	    // 해당 id의 게시글을 불러옴
	    // .orElse(null)을 사용해서 게시글이 없으면 null을 반환
	    article article = articleRepository.findById(updateId).orElse(null);

	    // 2. 만약 게시글이 존재한다면
	    if (article != null) {
	        // 3. DTO의 내용으로 기존 게시글의 필드를 업데이트
	        //    (article.setTitle(), article.setContent() 사용)
	        if (articleDTO.getTitle() != null) {
	            article.setTitle(articleDTO.getTitle());
	        }
	        if (articleDTO.getContent() != null) {
	            article.setContent(articleDTO.getContent());
	        }

	        // 4. 업데이트된 게시글을 저장하고 반환
	        article updatedArticle = articleRepository.save(article);
	        return updatedArticle;
	    }

	    // 5. 게시글이 존재하지 않으면 null을 반환
	    return null;
	}
	
	
	//게시글 삭제
	public void delete(Long delId) {
		articleRepository.deleteById(delId);
		
	}

	
	//실패케이스 :예약 처리
	//테스트 :TalendAPI 로 테스트
	//오류가 있어 모두 저장되면 안됨 ->전부취소
	public List<article> createArticleList(List<ArticleDTO> dtos) {
		//1.넘어온 DTO 들을 Article 엔티티 묶음으로 변환
		List<article> articleList = new ArrayList<>();
		for (ArticleDTO dto  : dtos ) {
			article article = dto.toEntity();
			articleList.add(article);
		}
		
		//2.db에 반복저장
		for(article article : articleList) {
			articleRepository.save(article);
		}
		//강제로 에러 발생 - 찾다가 없으면 예외발생 (id - 1)
		articleRepository.findById(-1L).orElseThrow(
				() -> new IllegalArgumentException("결제실패"));
		
		
		return null;
	}
	
	
	//결제취소성공케이스 :예약 처리
	//테스트 :TalendAPI 로 테스트
	//오류가 있어 모두 저장되면 안됨 ->전부취소
	//@Transactional : 두작업을 하나의 작업으로 묶어서 하나라도 실패하면 실행안댐 
	@Transactional 
	public List<article> createArticleList2(List<ArticleDTO> dtos) {
		//1.넘어온 DTO 들을 Article 엔티티 묶음으로 변환
		List<article> articleList = new ArrayList<>();
		for (ArticleDTO dto  : dtos ) {
			article article = dto.toEntity();
			articleList.add(article);
		}
		
		//2.db에 반복저장
		for(article article : articleList) {
			articleRepository.save(article);
		}
		//강제로 에러 발생 - 찾다가 없으면 예외발생 (id - 1)
		articleRepository.findById(-1L).orElseThrow(
				() -> new IllegalArgumentException("결제실패"));
		
		
		return null;
	}
	
	
	
	
}
