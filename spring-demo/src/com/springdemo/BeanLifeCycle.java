package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycle {

	public static void main(String[] args) {
		
		// load spring config to context
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("BeanLifeCycle.xml");
		
		// load object
		Coach myCoach = context.getBean("track", Coach.class);
		
		String str = myCoach.getDailyWorkOut();
		System.out.println(str);
		
		context.close();
		

	}

}
