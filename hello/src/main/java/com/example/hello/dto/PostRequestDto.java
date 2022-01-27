package com.example.hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostRequestDto {

	private String account;
	private String email;
	private String address;
	private String password;
	@JsonProperty("phone_number")  // camelCase가 아니거나, 기존과 다른 특정 이름으로 값을 받아올 수 있다.
	private String phoneNumber;  // phone_number
	@JsonProperty("OTP")
	private String OTP;
	
	// Getters and Setters
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getOTP() {
		return OTP;
	}
	public void setOTP(String oTP) {
		OTP = oTP;
	}
	
	//  toString
	@Override
	public String toString() {
		return "PostRequestDto [account=" + account + ", email=" + email + ", address=" + address + ", password="
				+ password + ", phoneNumber=" + phoneNumber + ", OTP=" + OTP + "]";
	}
}
