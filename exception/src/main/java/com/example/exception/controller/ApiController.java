package com.example.exception.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.dto.UserDto;

@RestController
@RequestMapping("/api/user")
public class ApiController {
	
	@GetMapping("")  // 원래 @RequestParam을 사용했으면 뒤에 ?key=value query parameter가 붙어야하지만, required = true로 해주면 생략가능하다
	public UserDto get(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age) {
		UserDto user = new UserDto();
		user.setName(name);
		user.setAge(age);
		System.out.println();
		return user;
	}
	
	@PostMapping("")
	public UserDto post(@Valid @RequestBody UserDto user) {
		System.out.println(user);
		return user;
	}
	
}
