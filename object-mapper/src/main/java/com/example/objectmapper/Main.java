package com.example.objectmapper;

import java.util.Arrays;
import java.util.List;

import com.example.objectmapper.dto.CarDto;
import com.example.objectmapper.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Main {

	public static void main(String args[]) throws JsonProcessingException {
		System.out.println("MAIN");
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		UserDto user = new UserDto();
		user.setName("pepe");
		user.setAge(7);
		
		CarDto car1 = new CarDto();
		car1.setName("Mercedes Benz");
		car1.setCarNumber("11가 1111");
		car1.setType("S CLASS");
		
		CarDto car2 = new CarDto();
		car2.setName("Ferrari");
		car2.setCarNumber("22나 2222");
		car2.setType("SPORTS");
		
		List<CarDto> carList = Arrays.asList(car1, car2);
		user.setCars(carList);
		System.out.println(user);  // user 데이터 확인
		
		String json = objectMapper.writeValueAsString(user);
		System.out.println(json);  // json형태로 데이터 출력
		
		// json구조의 각 노드의 데이터를 확인
		JsonNode jsonNode = objectMapper.readTree(json);  // 단순 1:1 key:value 관계일 경우
		String _name = jsonNode.get("name").asText();
		int _age = jsonNode.get("age").asInt();
		System.out.println("name : " + _name + " / age : " + _age);
		
		JsonNode cars = jsonNode.get("cars");
		ArrayNode arrayNode = (ArrayNode) cars;
		List<CarDto> _cars = objectMapper.convertValue(arrayNode, new TypeReference<List<CarDto>>(){});  // List와 같이 1:N key:value 관계일 경우
		System.out.println(_cars);
		
		ObjectNode objectNode = (ObjectNode) jsonNode;
		objectNode.put("name", "pair");
		objectNode.put("age", 10);
		System.out.println(objectNode.toPrettyString());
	}
}
