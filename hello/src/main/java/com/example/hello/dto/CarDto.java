package com.example.hello.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)  // 일괄적으로 모든 Naming규칙을 설정할 수 있다.
public class CarDto {
	
	private String name;
	private String carNumber;
	
	// Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	
	// toString
	@Override
	public String toString() {
		return "CarDto [name=" + name + ", carNumber=" + carNumber + "]";
	}
}
