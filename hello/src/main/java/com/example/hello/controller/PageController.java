package com.example.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.hello.dto.UserDto;

@Controller
public class PageController {

	@RequestMapping("/main")
	public String main() {
		return "main.html";
	}
	
	// ResponseEntity
	@ResponseBody
	@GetMapping("/user")
	public UserDto user() {
		UserDto user = new UserDto();
		user.setName("pepe");
		user.setAddress("herium");
		return user;
	}
}
