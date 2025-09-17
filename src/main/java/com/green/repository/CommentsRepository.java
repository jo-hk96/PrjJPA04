package com.green.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.green.dto.Comments;



@Repository
public interface CommentsRepository extends JpaRepository	<Comments , Long> {
	

	//List<Comments> findByArticleId(Long articleId);
	
	@Query(value = "select * from comments where article_id = :articleId" ,nativeQuery = true)
	List<Comments> findByArticleId(Long articleId);

	Comments save(Long updateId);

	//native query xml
	//src/main/resource/META-INF/orm.xml // 폴더와 파일을 생성 해야함
	//orm.xml 에 sql을 저장해서 findByNickname()함수 호출
		
	//List<Comments> findByNickname(String nickname);
}