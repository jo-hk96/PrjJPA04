package com.green.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home () {
		return "index.html";
	}
	
	@GetMapping("/hi")
	public  String   hi(Model model) {
       model.addAttribute("username", "홍규" );
		return "hello.html";   
		  // greetings.mustache  화면을 보여줄 template 이름
		 // resources/template package 에 생성
	}
	@GetMapping("/hi2")
	public  String   hi2(Model model) {
		model.addAttribute("username", "홍규2" );
		return "greetings";   
		// greetings.mustache  화면을 보여줄 template 이름
		// resources/template package 에 생성
	}
	
	@GetMapping("/hi3")
	public  String   hi3(Model model) {
       model.addAttribute("username", "홍규3" );
		return "greetings2";   
		  // greetings.mustache  화면을 보여줄 template 이름
		 // resources/template package 에 생성
	}
	
	@GetMapping("/hi4")
	public  String   hi4(Model model) {
		model.addAttribute("username", "홍규4" );
		return "greetings3";   
		// greetings.mustache  화면을 보여줄 template 이름
		// resources/template package 에 생성
	}

	
	
	
}
