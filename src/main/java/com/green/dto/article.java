package com.green.dto;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;


//실제 데이터베이스에 테이블을 생성해준다
//import jakarta.peristence.

@Data
@Entity
@SequenceGenerator(
		name = "article_seq",
		sequenceName = "article_seq",
		initialValue = 1,
		allocationSize = 1
		)
public class article {
	
	@Id             	//primary key
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "article_seq")
	private Long id; //integer : null 입력가능 , int <- null x 
	
	@Column              // 데이터베이스 컬럼
	private String title;
	
	@Column              // 데이터베이스 컬럼
	private String content;

	
	//기본생성자 @noArgsConstructor
	
	public article() {};	
	//생성자 @AllArgsConstructor
	public article(Long id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}
	
	//toString @ToString 
	@Override
	public String toString() {
		return "article [id=" + id + ", title=" + title + ", content=" + content + "]";
	}

	
	public Long getId() {
		return this.id;
	}
	
	
	
	
}
