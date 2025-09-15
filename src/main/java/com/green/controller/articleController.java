package com.green.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.green.dto.ArticleDTO;
import com.green.dto.article;
import com.green.repository.ArticleRepository;

@Controller
public class articleController {

	
	@Autowired
	private ArticleRepository articleRepository; 
	
	
	@GetMapping("/article/list")
	public  String  list(Model model) {
		long totalCount = articleRepository.count();
		System.out.println("전체자료수" + totalCount);
		articleRepository.findAll();
		Iterable<article> articleEntityList = articleRepository.findAll();
		
		
		model.addAttribute("articleList" , articleEntityList);
		return "article/list";   
		// greetings.mustache  화면을 보여줄 template 이름
		// resources/template package 에 생성
	}
	
	
	@GetMapping("/article/WriteForm")
	public  String  writeForm(Model model) {
		return "article/write";   
		// greetings.mustache  화면을 보여줄 template 이름
		// resources/template package 에 생성
	}
	
	
	
	
	@PostMapping("/article/Write")
	public  String  write(ArticleDTO articleDTO) {
		System.out.println(articleDTO);
		article article = articleDTO.toEntity();
		article saved = articleRepository.save(article);
		System.out.println(saved.getId());

		return "redirect:/article/list"; 
	}
	
	@GetMapping("/article/updateForm/{id}")
	public  String  updateForm(@PathVariable("id") Long id , Model model) {
		Optional<article> article = articleRepository.findById(id);
		
		        model.addAttribute("article", article.get());
		        return "article/update";
		}
		
	
	
	//@ModelAttribute: get으로 update 폼에서 가져올필요없이 알아서 해줌
	@PostMapping("/article/update/{id}")
	public String update(@PathVariable("id") Long id, @ModelAttribute ArticleDTO articleDto) {
	    // 1. DTO 객체를 Article 엔티티 객체로 변환
	    article articleEntity = new article(id,articleDto.getTitle(),articleDto.getContent());
	    // 2. Article 엔티티 객체를 save() 메서드에 전달
	    articleRepository.save(articleEntity);
	    return "redirect:/article/list";
	}
	
	
	//해당 게시글 상세보기
	@GetMapping("/article/view/{id}")
	public  String  view(@PathVariable("id") Long id , Model model) {
		Optional<article> article = articleRepository.findById(id);
		model.addAttribute("article",article.get());
		return "article/view"; 
	}
	
	
	//게시글 삭제
	@GetMapping("/article/delete/{id}")
	public  String  delete(@PathVariable("id") Long id , RedirectAttributes re) {
		articleRepository.deleteById(id);
		re.addFlashAttribute("message" , "삭제완료");
		return "redirect:/article/list"; 
	}
	
	
	
	
	
	
}
