package com.example.aop.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.aop.annotation.Decode;
import com.example.aop.annotation.Timer;
import com.example.aop.dto.UserDto;

@RestController
@RequestMapping("/api")
public class RestApiController {

	@GetMapping("/get/{id}")
	public String get(@PathVariable Long id, @RequestParam String name) {
		System.out.println("get method");
		System.out.println("id : " + id);
		System.out.println("name : " + name);
		return id + " " + name;
	}
	
	@PostMapping("/post")
	public UserDto post(@RequestBody UserDto user) {
		System.out.println("post method : " + user );
		return user;
	}
	
	@Timer
	@DeleteMapping("/delete")
	public void delete() throws InterruptedException {
		
		// DB logic
		
		Thread.sleep(1000 * 2);
	}
	
	@Decode
	@PutMapping("/put")
	public UserDto put(@RequestBody UserDto user) {
		System.out.println(user);
		return user;
	}
}
