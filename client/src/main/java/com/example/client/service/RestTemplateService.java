package com.example.client.service;

import java.net.URI;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.client.dto.ReqDto;
import com.example.client.dto.UserRequestDto;
import com.example.client.dto.UserResponseDto;

@Service
public class RestTemplateService {

	// http://localhost/api/server/hello
	// response
	public UserResponseDto hello() {
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:9090")
				.path("/api/server/hello")
				.queryParam("name", "pepe")
				.queryParam("age", 7)
				.encode()
				.build()
				.toUri();
		System.out.println(uri.toString());
		
		RestTemplate restTemplate = new RestTemplate();
		// String result = restTemplate.getForObject(uri, String.class);
		// return result;
		ResponseEntity<UserResponseDto> result = restTemplate.getForEntity(uri, UserResponseDto.class);
		System.out.println(result.getBody());  // 내용
		System.out.println(result.getStatusCode());  // 상태코드
		return result.getBody();
	}
	
	// http://localhost:9090/api/server/user/{userId}/name/{userName}
	public UserResponseDto post() {
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:9090")
				.path("/api/server/user/{userId}/name/{userName}")
				.encode()
				.build()
				.expand("100", "pepe")  // 괄호에 차례차례 매칭된다. - {userId} - {userName}
				.toUri();
		System.out.println(uri);
		
		// http body -> object -> object mapper -> json -> rest template -> http body json
		UserRequestDto req = new UserRequestDto();
		req.setName("pepe");
		req.setAge(10);
		RestTemplate restTemplate = new RestTemplate();
		// 지금은 UserResponseDto를 통해서 데이터를 보여주지만 굳이 응답을 반환하지 않고 그냥 void함수로 해서 String으로 찍어낼 수도 있다.
		ResponseEntity<UserResponseDto> response = restTemplate.postForEntity(uri, req, UserResponseDto.class);
		System.out.println(response.getHeaders());
		System.out.println(response.getBody());
		System.out.println(response.getStatusCode());
		return response.getBody();
	}
	
	public UserResponseDto exchange() {
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:9090")
				.path("/api/server/user/{userId}/name/{userName}")
				.encode()
				.build()
				.expand("100", "pepe")  // 괄호에 차례차례 매칭된다. - {userId} - {userName}
				.toUri();
		System.out.println(uri);
		
		// http body -> object -> object mapper -> json -> rest template -> http body json
		UserRequestDto req = new UserRequestDto();
		req.setName("pepe");
		req.setAge(10);
		RequestEntity<UserRequestDto> requestEntity = RequestEntity
				.post(uri)
				.contentType(MediaType.APPLICATION_JSON)
				.header("x-authorization", "blossom")
				.header("custom-header", "temp")
				.body(req);
				
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<UserResponseDto> response = restTemplate.exchange(requestEntity, UserResponseDto.class);
		return response.getBody();
	}
	
	public ReqDto<UserResponseDto> genericExchange() {
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:9090")
				.path("/api/server/user/{userId}/name/{userName}")
				.encode()
				.build()
				.expand("100", "pepe")  // 괄호에 차례차례 매칭된다. - {userId} - {userName}
				.toUri();
		System.out.println(uri);
		
		// http body -> object -> object mapper -> json -> rest template -> http body json
		UserRequestDto userRequest = new UserRequestDto();
		userRequest.setName("pepe");
		userRequest.setAge(10);
		ReqDto<UserRequestDto> req = new ReqDto<>();
		req.setHeader(new ReqDto.Header());
		req.setBody(userRequest);
		RequestEntity<ReqDto<UserRequestDto>> requestEntity = RequestEntity
				.post(uri)
				.contentType(MediaType.APPLICATION_JSON)
				.header("x-authorization", "blossom")
				.header("custom-header", "temp")
				.body(req);	
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ReqDto<UserResponseDto>> response = 
				restTemplate.exchange(requestEntity, new ParameterizedTypeReference<ReqDto<UserResponseDto>>() {});
		return response.getBody();
	}
}
