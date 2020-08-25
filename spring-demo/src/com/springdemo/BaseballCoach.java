package com.springdemo;

public class BaseballCoach implements Coach {
	// private for injection
	private FortuneService fortuneService;
	
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	// constructor for injection
	
	
	@Override
	public String getDailyWorkOut() {
		return "get 30 minutes of batting practice";
	}

	@Override
	public String getDailyFortune() {
		// use fortuneService injection
		return fortuneService.getFortune();
	}
}
