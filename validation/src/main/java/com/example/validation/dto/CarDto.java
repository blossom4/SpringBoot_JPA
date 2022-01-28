package com.example.validation.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CarDto {

	@NotBlank
	private String name;
	@NotBlank
	@JsonProperty("car_number")
	private String carNumber;
	@NotBlank
	@JsonProperty("TYPE")
	private String type;
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	// toString
	@Override
	public String toString() {
		return "CarDto [name=" + name + ", carNumber=" + carNumber + ", type=" + type + "]";
	}
}
