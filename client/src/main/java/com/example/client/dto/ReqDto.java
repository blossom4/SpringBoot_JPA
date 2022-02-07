package com.example.client.dto;

public class ReqDto<T> {

	private Header header;
	private T body;
	
	public static class Header {
		private String responseCode;

		// Getters and Setters
		public String getResponseCode() {
			return responseCode;
		}
		public void setResponseCode(String responseCode) {
			this.responseCode = responseCode;
		}
		
		// toString
		@Override
		public String toString() {
			return "Header [responseCode=" + responseCode + "]";
		}
	}

	// Getters and Setters
	public Header getHeader() {
		return header;
	}
	public void setHeader(Header header) {
		this.header = header;
	}
	public T getBody() {
		return body;
	}
	public void setBody(T body) {
		this.body = body;
	}
	
	// toString
	@Override
	public String toString() {
		return "ReqDto [header=" + header + ", body=" + body + "]";
	}	
}
