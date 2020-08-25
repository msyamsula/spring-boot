package com.spring.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mainBeanScopeAnnotations {

	public static void main(String[] args) {
		// load spring config to context
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("./SpringAnnotations.xml");
		
		TennisCoach coach = context.getBean("tennisCoach", TennisCoach.class);
		TennisCoach coach2 = context.getBean("tennisCoach", TennisCoach.class);
		
		boolean result = coach == coach2;
		
		System.out.println(result);
		System.out.println("Memory coach: " + coach);
		System.out.println("Memory coach2: " + coach2);
		
		context.close();
	}

}
