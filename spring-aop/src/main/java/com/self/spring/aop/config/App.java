package com.self.spring.aop.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.self.spring.aop.dao.AccountDAO;

public class App {

	public App() {
	}

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SpringConfig.class);
		
		// get the bean from spring container
		AccountDAO dao = context.getBean("accountDAO", AccountDAO.class);
		
		// call the business method
		System.out.println(dao.addAccount());
		System.out.println("call again");
		System.out.println(dao.addAccount());
		
		// close context
		context.close();
	}

}
