package com.example.hello.ioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		String url = "www.google.com/books/it?page=10&size=20&name=spring-boot";
		
		/*
		 * // Base 64 encoding 
		 * Base64Encoder encoder = new Base64Encoder(); 
		 * String result = encoder.encode(url); 
		 * System.out.println(result);
		 * 
		 * // url encoding 
		 * UrlEncoder urlEncoder = new UrlEncoder(); 
		 * String urlResult = urlEncoder.encode(url); 
		 * System.out.println(urlResult);
		 */
		
		
		/*
		 * // IEncoder // Encoder encoder = new Encoder(new Base64Encoder()); Encoder
		 * encoder = new Encoder(new UrlEncoder()); String result = encoder.encode(url);
		 * System.out.println(result);
		 */
		 
		
		
		  SpringApplication.run(Main.class, args); 
		  ApplicationContext context = ApplicationContextProvider.getContext();
		  
		  Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
		  //UrlEncoder urlEncoder = context.getBean(UrlEncoder.class); 
		  Encoder encoder = new Encoder(base64Encoder);
		  
		  String result = encoder.encode(url); 
		  System.out.println(result);
		 
	}

}
