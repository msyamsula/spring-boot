package com.spring.java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.annotations.BasketCoach;
import com.spring.annotations.TennisCoach;

public class mainSpringJava {

	public static void main(String[] args) {
		// load config file to context
		// used AnnotationConfigApplicationContext to load config from java file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		SwimCoach myCoach = context.getBean("swimCoach", SwimCoach.class);
		
		System.out.println(myCoach.getDailyWorkOut());
		System.out.println(myCoach.getDailyFortune());
		System.out.println(myCoach.getEmail());
		System.out.println(myCoach.getTeam());
		
		
		context.close();
	}

}
