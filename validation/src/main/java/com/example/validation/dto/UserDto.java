package com.example.validation.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.validation.annotation.YearMonth;

public class UserDto {

	@NotBlank
	private String name;
	@Min(value = 5)
	private int age;
	@Email  // spring 내부 validation
	private String email;
	@Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "휴대폰 번호의 양식과 맞지 않습니다. 010-XXXX-XXXX")  // 직접 정규식 등록, 직접 메세지 등록
	private String phoneNumber;
	@YearMonth
	private String reqYearMonth;  // yyyyMMdd
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getReqYearMonth() {
		return reqYearMonth;
	}
	public void setReqYearMonth(String reqYearMonth) {
		this.reqYearMonth = reqYearMonth;
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
		return "UserDto [name=" + name + ", age=" + age + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", reqYearMonth=" + reqYearMonth + ", cars=" + cars + "]";
	}
}
