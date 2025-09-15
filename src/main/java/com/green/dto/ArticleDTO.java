package com.green.dto;

import lombok.Data;

@Data
public class ArticleDTO {
	//Field
	private String title;
	private String content;
	
	//Getter Setter
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	//toString
	@Override
	public String toString() {
		return "ArticleDTO [title=" + title + ", content=" + content + "]";
	}
	public article toEntity() {
		article article = new article(null, this.title, this.content);
		return article;
	}
	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
