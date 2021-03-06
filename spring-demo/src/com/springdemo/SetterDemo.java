package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemo {

	public static void main(String[] args) {
		// load spring configuration to variable "context"
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); 
		
		// load object
		CricketCoach myCoach = context.getBean("cricket", CricketCoach.class);
		
		
		// call method
		System.out.println(myCoach.getDailyWorkOut());
		System.out.println(myCoach.getDailyFortune());
		System.out.println(myCoach.getTeam());
		System.out.println(myCoach.getEmail());
		
		// close context
		context.close();
	}

}
