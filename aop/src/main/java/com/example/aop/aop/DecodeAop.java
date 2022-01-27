package com.example.aop.aop;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.example.aop.dto.UserDto;

public class DecodeAop {

	@Pointcut("execution(* com.example.aop.controller..*.*(..))")
	private void pointCut() {}
	
	@Pointcut("@annotation(com.example.aop.annotation.Timer)")
	private void enableDecode() {}
	
	@Before("cut() && enableDecode()")
	public void before(JoinPoint joinPoint) throws UnsupportedEncodingException {
		Object[] args = joinPoint.getArgs();
		
		for (Object arg : args) {
			if (arg instanceof UserDto) {
				UserDto user = UserDto.class.cast(args);
				String base64Email = user.getEmail();
				String email = new String(Base64.getDecoder().decode(base64Email), "UTF-8");
				user.setEmail(email);
			}
		}
	}
	
	@AfterReturning(value = "cut() && enableDecode()", returning = "returnObj")
	public void afterReturn(JoinPoint joinPoint, Object returnObj) {
		if (returnObj instanceof UserDto) {
			UserDto user = UserDto.class.cast(returnObj);
			String email = user.getEmail();
			String Base64Email = Base64.getEncoder().encodeToString(email.getBytes());
			user.setEmail(Base64Email);
		}
	}
}
