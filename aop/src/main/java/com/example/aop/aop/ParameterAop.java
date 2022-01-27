package com.example.aop.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ParameterAop {

	@Pointcut("execution(* com.example.aop.controller..*.*(..))")  // com.example.aop.controller 하위의 모든 method
	private void pointCut() {}
	
	// 해당 api가 호출되어서 응답이 오기전에 실행된다.
	@Before("pointCut()")
	public void before(JoinPoint joinPoint) {
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();
		System.out.println(method.getName());
		Object[] args = joinPoint.getArgs();
		for (Object obj : args) {
			System.out.println("type : " + obj.getClass().getSimpleName());
			System.out.println("value : " + obj);
		}
	}
	
	// 해당 api가 호출되어서 응답이 온 후에 실행된다.
	@AfterReturning(value = "pointCut()", returning = "returnObj")
	public void afterReturn(JoinPoint joinPoint, Object returnObj) {
		System.out.println("return obj");
		System.out.println(returnObj);
	}
}
