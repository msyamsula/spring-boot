package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScope {

	public static void main(String[] args) {
		
		// load spring config to context
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("BeanScope.xml");
		
		// load object
		Coach myCoach = context.getBean("track", Coach.class);
		
		Coach alphaCoach = context.getBean("track", Coach.class);
		
		// check if they are the same object
		boolean result = myCoach == alphaCoach;
		
		System.out.println(result);
		System.out.println(myCoach);
		System.out.println(alphaCoach);
		
		context.close();
		

	}

}
