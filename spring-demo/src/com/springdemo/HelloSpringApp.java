package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		// load spring container config and save it in variabel "context"
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");  
		
		// retrieve bean/object from spring container
		Coach myCoach1 = context.getBean("baseball", Coach.class);
		Coach myCoach2 = context.getBean("track", Coach.class);
		Coach myCoach3 = context.getBean("f1", Coach.class);
		
		// call method on bean
		String str = myCoach1.getDailyWorkOut();
		System.out.println(str);
		str = myCoach2.getDailyWorkOut();
		System.out.println(str);
		str = myCoach3.getDailyWorkOut();
		System.out.println(str);
		
		String fortune = myCoach3.getDailyFortune();
		System.out.println(fortune);
		fortune = myCoach1.getDailyFortune();
		System.out.println(fortune);
		fortune = myCoach2.getDailyFortune();
		System.out.println(fortune);
		
		System.out.println("Test");
		
		// close the context
		context.close();
	}

}
