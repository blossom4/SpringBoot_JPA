package com.example.exception.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDto {

	@NotEmpty
	@Size(min = 1, max = 10)
	private String name;
	@Min(1)
	@NotNull
	private Integer age;
	
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
	public void setAge(Integer age) {
		this.age = age;
	}
	
	// toString
	@Override
	public String toString() {
		return "UserDto [name=" + name + ", age=" + age + "]";
	}
}
