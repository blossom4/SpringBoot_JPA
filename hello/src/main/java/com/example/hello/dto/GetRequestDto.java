package com.example.hello.dto;

public class GetRequestDto {
	
	private String name;
	private String email;
	private int age;

	// Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	// toString
	@Override
	public String toString() {
		return "UserRequest [name=" + name + ", email=" + email + ", age=" + age + "]";
	}
}
