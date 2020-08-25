package com.springdemo;

public class TrackCoach implements Coach {
	// private field
	private FortuneService fortuneService;
	
	// constructor
	public TrackCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "Run hard 5K";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	// add init-method
	public void startUp() {
		System.out.println("Object is started");
	}
	
	// add destroy-method
	public void cleanUp() {
		System.out.println("Object is destroyed");
	}

}
