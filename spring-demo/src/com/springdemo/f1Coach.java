package com.springdemo;

public class f1Coach implements Coach {
	//	private variable
	private FortuneService fortuneService;
	
	//	constructor
	public f1Coach(FortuneService fs) {
		fortuneService = fs;
	}
	
	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "go 10 laps in catalunya";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
