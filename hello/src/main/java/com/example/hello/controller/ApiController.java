package com.example.hello.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hello.dto.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController  // 해당 Class는 REST API 처리하는 Controller
@RequestMapping("/api")  // RequestMapping URI를 지정해주는 Annotation
public class ApiController {

	@GetMapping("/hello")  // http://localhost:8080/api/hello
	public String hello() {
		return "Hello SpringBoot :)";
	}
	
	// text 데이터
	@GetMapping("/text")
	public String text(@RequestParam String account) {
		return account;
	}
	
	// json 데이터
	// request -> object mapper -> object -> method -> object -> object mapper -> json -> reponse
	@PostMapping("/json")
	public UserDto json(@RequestBody UserDto user) {
		return user;
	}
	
	//  ResponseEntity를 사용하면 응답에 대한 값을 명확하게 해줄 수 있다.
	@PutMapping("/response")
	public ResponseEntity<UserDto> response(@RequestBody UserDto user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
}
