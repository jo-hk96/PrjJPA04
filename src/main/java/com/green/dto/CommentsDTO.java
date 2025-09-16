package com.green.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentsDTO {
	private Long id;	//댓글id
	@JsonProperty("article_id")
	private Long articleId; //article의 부모글 id
	private String nickname;//닉네임
	private String body;	//댓글본문
	
	public static CommentsDTO
		createCommentsDTO(Comments comments) {
		return new CommentsDTO(
				comments.getId(),
				comments.getArticle().getId(),
				comments.getNickname(),
				comments.getBody()
				);
	}
}
