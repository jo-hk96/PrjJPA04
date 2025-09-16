package com.green.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
		name = "comments_seq",
		sequenceName = "comments_seq",
		initialValue = 1,
		allocationSize = 1
		)
public class Comments {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "comments_seq")
	private Long id;
	
	//컬럼이름 : body , nullable 허용여부 ,  length 길이
	//11g varchar2 최대 4000 -> clob
	//12C varchar2 최대 32000 -> 별도 설정 필요
	@Column(name = "body", nullable = true , length = 255 )
	private String body;
	
	@Column
	private String nickname;
	
	@ManyToOne 					     //외래키 다대일
	@JoinColumn(name = "article_id") // 외래키 컬럼
	private article article ;        //연결될 entity 객체의 이름
	
	
}
