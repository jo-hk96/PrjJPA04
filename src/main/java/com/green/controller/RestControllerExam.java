package com.green.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //@ResponseBody 붙일필요 없음
public class RestControllerExam {
	//Method
	//GET
	//POST
	//DELETE
	
	
	
	//select
	@GetMapping("/exam")
	//@ResponseBody
	public String getExam() {
		
		return "Get Data";
		
	}
	
	
	//data 추가 : Insert
	@PostMapping("/exam")
	//@ResponseBody
	public String postExam() {
		
		return "Post Data";
		
	}
	
	//data 삭제: Delete
	@DeleteMapping("/exam")
	//@ResponseBody
	public String deleteExam() {
		
		return "delete Data";
		
	}
	
	//일부 data 수정 :Update
	@PatchMapping("/exam")
	//@ResponseBody
	public String PatchExam() {
		
		return "Patch Data";
		
	}
	
	
	//전체 data  수정 :Update
	@PutMapping("/exam")
	//@ResponseBody
	public String putExam() {
		
		return "put Data";
		
	}
	
	
}
