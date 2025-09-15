package com.green.dto;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;


//실제 데이터베이스에 테이블을 생성해준다
//import jakarta.peristence.

@Data
@Entity
public class article {
	
	@Id             	//primary key
	@GeneratedValue 	//시퀀스 :번호자동증가
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
