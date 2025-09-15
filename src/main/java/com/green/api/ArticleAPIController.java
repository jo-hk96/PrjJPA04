package com.green.api;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.green.dto.ArticleDTO;
import com.green.dto.article;
import com.green.repository.ArticleRepository;
import com.green.service.ArticleService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
public class ArticleAPIController {
	
	@Autowired
	private ArticleRepository articleRepository; 
	
	@Autowired
	private ArticleService articleService; 
	
	
	@GetMapping(value = "/api/articles",produces = "application/json;charset = utf-8")
	/*produces = MediaType.APPLICATION_JSON_VALUE)*/
	public List<article> list() {
		List<article> list = (List<article>) articleRepository.findAll();
		log.info("list", list);
		return list;
	}
	
	
	//id 한개만 들고오기
	@GetMapping(value = "/api/article/{getId}",produces = "application/json;charset = utf-8")
	public ResponseEntity<article> list(@PathVariable Long getId) {
		Optional<article> articleOptional = articleRepository.findById(getId);
		   if (articleOptional.isPresent()) {
		        return ResponseEntity.ok(articleOptional.get());
		    } else {
		        // 3. 만약 게시글이 존재하지 않으면, 404 Not Found를 반환해.
		        return ResponseEntity.notFound().build();
		    }
		}
	
	
	
	//게시글 추가
	@PostMapping("/api/articles")
	public ResponseEntity<article> create(
		@RequestBody	ArticleDTO  articleDTO   ) {  
		   //  @RequestBody : 넘어오는 정보는 json 문자열
		
		article  created  =  articleService.create( articleDTO  );
		// saved : 저장된 id, title. content  를 돌려받늗다
		
		//http 상태코드
		ResponseEntity<article>  result = 
		  ( created != null )	
		     ? ResponseEntity.status(HttpStatus.OK).body( created )   // 200(ok) , 201(created)	  
			 : ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); // 400	 (Error)	
		
		return  result;
	}
	
	
	//게시글 수정
	@PatchMapping("/api/article/{updateId}")
	public ResponseEntity<article> update(
			//url{id} 	@PathVariable로 id를 받아옴
			@PathVariable Long updateId,
			//  @RequestBody : 넘어오는 정보는 json 문자열
			@RequestBody	ArticleDTO  articleDTO   ) {  
		
		//id 를 기준으로 수정
		article  update  =  articleService.update(updateId ,articleDTO);
		
		//http 상태코드
		ResponseEntity<article>  result = 
				( update != null )	
				? ResponseEntity.status(HttpStatus.OK).body( update )   // 200(ok) , 201(created)	  
				: ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); // 400	 (Error)	
		return  result;
	}
	
	
	
	//게시글 삭제
	@DeleteMapping("api/article/{delId}")
	public ResponseEntity<Void> delete(@PathVariable Long delId){
		//삭제할 id가 있는지 확인
		boolean exists = articleRepository.existsById(delId);
		
		//id가 잇다면 삭제
		if(exists) {
			articleService.delete(delId);
			return ResponseEntity.noContent().build();
		}else {
			//id가없다면 에러 응답
			return ResponseEntity.notFound().build();
		}
		
	}
	//3줄의 데이터
	/*
	 * [ 
	 * {"title" : "시간예약" , "content" : "1420"},
	 *  {"title" : "영화지정" , "content" :
	 * "케데헌"}, {"title" : "자리 지정" , "content" : "A2"} 
	 * ]
	 */
	// /api/transaction-test1
	//3개의 데이터를 받아서 서비스에 저장결과를 받는다.
	@PostMapping("/api/transaction-test1")
	public ResponseEntity<List<article>> transaction1(@RequestBody List<ArticleDTO> dtos){
		List <article> creatList = articleService.createArticleList(dtos);
		
		System.out.println(creatList);
		return null;
	}
	
	
	@PostMapping("/api/transaction-test2")
	public ResponseEntity<List<article>> transaction2(@RequestBody List<ArticleDTO> dtos){
		List <article> creatList = articleService.createArticleList2(dtos);
		
		System.out.println(creatList);
		return null;
	}
		
}
	
	
