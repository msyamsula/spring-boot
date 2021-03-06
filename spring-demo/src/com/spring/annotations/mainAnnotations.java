package com.spring.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mainAnnotations {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("./SpringAnnotations.xml");
		
		TennisCoach myCoach = context.getBean("tennisCoach", TennisCoach.class);
		BasketCoach coach = context.getBean("basketCoach", BasketCoach.class);
		
		System.out.println(myCoach.getDailyWorkOut());
		System.out.println(myCoach.getDailyFortune());
		System.out.println(myCoach.getTeam());
		System.out.println(myCoach.getEmail());
		System.out.println(coach.getFortuneService());
		
		context.close();

	}

}
