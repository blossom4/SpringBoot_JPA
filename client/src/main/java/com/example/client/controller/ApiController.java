package com.example.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.client.dto.ReqDto;
import com.example.client.dto.UserResponseDto;
import com.example.client.service.RestTemplateService;

@RestController
@RequestMapping("/api/client")
public class ApiController {
	
//	@Autowired
//	private RestTemplateService restTemplateService;
	
	private final RestTemplateService restTemplateService;
	
	public ApiController(RestTemplateService restTemplateService) {
		this.restTemplateService = restTemplateService;
	}

	@GetMapping("/hello")
	public ReqDto<UserResponseDto> getHello() {
		// return restTemplateService.hello();
		// return restTemplateService.post();
		// return restTemplateService.exchange();
		return restTemplateService.genericExchange();
	}
}
