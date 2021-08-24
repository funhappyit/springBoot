package com.example.controller;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.SearchParam;

@RestController
@RequestMapping("/api")
public class PostController {

	/*HTML <Form>
	 ajax 검색 
	 http post body -> data
	 json, xml, multipart-form / text-plain
	 
	 
	 
	 */
	
	//@PostMapping(value="/postMethod", produces = {"application-json"})
	@PostMapping(value="/postMethod")
	public SearchParam postMethod(@RequestBody SearchParam searchParam) {
		
		return searchParam;
	}
	
	@PutMapping("/putMethod")
	public void put() {
		
	}
	@PatchMapping("/patchMethod")
	public void patch() {
		
	}
	/*
	 spring: 스프링 설정 버전 충돌 에러 등 발생 
	 spring boot: 기본적으로 설정을 해야하는 라이브러리들이 미리 내장 
	 */
	
}
