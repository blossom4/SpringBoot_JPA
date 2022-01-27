package com.example.hello.dto;

public class UserDto {

	private String name;
	private Integer age;  // default value -> int : 0, Integer : null
	private String phoneNumer;
	private String address;
	
	// Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPhoneNumer() {
		return phoneNumer;
	}
	public void setPhoneNumer(String phoneNumer) {
		this.phoneNumer = phoneNumer;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	// toString
	@Override
	public String toString() {
		return "UserDto [name=" + name + ", age=" + age + ", phoneNumer=" + phoneNumer + ", address=" + address + "]";
	}
}
