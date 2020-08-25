package com.spring.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BasketCoach implements Coach {
	
	// directly inject autowired to field.
	// beside it can be inject to method/constructor, @Autowired also can be used to the field
	// @Qualifier used to specify object that has many implementations, the argument is object/bean id
	@Autowired()
	@Qualifier("unhappyFortuneService")
	private FortuneService fortuneService;

	@Override
	public String getDailyWorkOut() {
		return "Do three point 100 times";
	}
	
	public String getFortuneService() {
		return fortuneService.getFortuneService();
	}

}
