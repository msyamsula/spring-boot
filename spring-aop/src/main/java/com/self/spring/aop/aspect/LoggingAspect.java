package com.self.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect // tell that this class is aspect
@Component
public class LoggingAspect {

	public LoggingAspect() {
	}
	@Pointcut("execution(public String com.self.spring.aop.dao.AccountDAO.addAccount(..))") // point cut declaration for addAccount method in certain package
	public void addAccount() {}
	
	// you can combine pointcut using and,or,not operation
	// e.g
	// @Before(pointcut 1 || pointcut 2)
	// @Before(pointcut 1 && pointcut 2)
	// @Before(pointcut 1 || !pointcut 2)
	
	@Before("addAccount()") // use point cut declaration
	public void beforeAddAccountService() {
		System.out.println("======= executing @Before advice on addAccount");
	}
	
	// this comment is made from vscode

}
