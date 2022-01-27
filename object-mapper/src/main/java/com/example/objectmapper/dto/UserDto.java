package com.example.objectmapper.dto;

import java.util.List;

public class UserDto {

	private String name;
	private int age;
	private List<CarDto> cars;
	
	// Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<CarDto> getCars() {
		return cars;
	}
	public void setCars(List<CarDto> cars) {
		this.cars = cars;
	}
	
	// toString
	@Override
	public String toString() {
		return "UserDto [name=" + name + ", age=" + age + ", cars=" + cars + "]";
	}
}
