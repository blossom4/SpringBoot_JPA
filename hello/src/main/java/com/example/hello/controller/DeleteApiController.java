package com.example.hello.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DeleteApiController {

	@DeleteMapping("/delete/{userId}")  // 기존 데이터를 잘 삭제했든, 애초에 해당 데이터가 없었든 200 OK를 Return한다.
	public void delete(
			@PathVariable String userId,
			@RequestParam String account
			) {
		System.out.println(userId);
		System.out.println(account);
	}
}
