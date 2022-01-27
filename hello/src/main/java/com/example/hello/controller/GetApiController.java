package com.example.hello.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hello.dto.GetRequestDto;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

	@GetMapping(path = "/hello")  // http://localhost:8080/api/get/hello
	public String getHello() {
		return "Get Hello";
	}
	
	@RequestMapping(path="/hi", method = RequestMethod.GET)
	public String hi() {
		return "Hi :)";
	}
	
	@GetMapping(path = "/path-variable/{id}")  // http://localhost:8080/api/get/path-variable/{id}
	public String pathVariable(@PathVariable(name = "id") String pathName) {
		System.out.println("PathVariabe : " + pathName);
		return pathName;		
	}
	
	// {key}={value}
	// springboot 검색결과 query parameter
	// search?q=springboot
	// &oq=springboot&aqs=chrome..69i57j0i10i433i512j0i512l2j0i10i512l2j69i61l2.1963j0j9
	// &sourceid=chrome
	// &ie=UTF-8
	
	@GetMapping(path = "/query-param")  // http://localhost:8080/api/get/query-param?name=pepe&email=pepe@gmail.com&age=7
	public String queryParam(@RequestParam Map<String, String> queryParam) {
		StringBuilder sb = new StringBuilder();
		
		queryParam.entrySet().forEach( entry -> {
			System.out.println(entry.getKey() + ": " + entry.getValue());
			sb.append(entry.getKey() + ": " + entry.getValue() + "\n");
		});
		
		return sb.toString();
	}
	
	@GetMapping(path = "/query-param02")  // http://localhost:8080/api/get/query-param02?name=pair&email=pair@gmail.com&age=10
	public String queryParam02(
			@RequestParam String name,
			@RequestParam String email,
			@RequestParam int age
			) {
		System.out.println(name);
		System.out.println(email);
		System.out.println(age);
		
		return name + "\n" + email + "\n" + age;
	}
	
	@GetMapping(path = "/query-param03")  // http://localhost:8080/api/get/query-param03?name=pair&email=pair@gmail.com&age=10
	public String queryParam03(GetRequestDto getRequest) {  // dto - GetRequestDto에 미리 설정
		System.out.println(getRequest.getName());
		System.out.println(getRequest.getEmail());
		System.out.println(getRequest.getAge());
		
		return getRequest.toString();
	}
}
