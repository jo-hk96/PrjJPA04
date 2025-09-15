package com.green;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.green.repository.ArticleRepository;





@SpringBootTest
class PrjJpa04ApplicationTests {

	@Autowired
	private ArticleRepository articleRepository;
	
	@Test
	void contextLoads() {
	}
	
	
	//단위 테스트를 위한 코드 작성
	@Test
	@DisplayName("나누기비교")
	public void test1() {
		double n1 = 6;
		double n2 = 2;
		double n  = n1 / n2 ;
		System.out.println("정답은!!:" + n);
		
		assertEquals(n , 3); //두값을 비교
	}
	
	@Test
	@DisplayName("아티클 게시글 수")
	public void test2() {
		long totCnt = articleRepository.count();
		System.out.println("정답은!!:" + totCnt);
		assertEquals(totCnt , 6); //두값을 비교
	}
	
}
