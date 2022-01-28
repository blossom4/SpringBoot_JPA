package com.example.validation.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.validation.dto.UserDto;

@RestController
@RequestMapping("/api")
public class ApiController {

	@PostMapping("/post")
	// validation 어노테이션을 사용했다면 @Valid를 넣어주어야 한다.
	public ResponseEntity user(@Valid @RequestBody UserDto user, BindingResult bindingResult) {
		System.out.println(user);
		
		if (bindingResult.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			bindingResult.getAllErrors().forEach(objectError -> {
				FieldError field = (FieldError) objectError;
				String message = objectError.getDefaultMessage();
				sb.append("field : " + field.getField());
				sb.append(" | message : " + message + "\n");
			});
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
		}
		
		return ResponseEntity.ok(user);
	}
}
