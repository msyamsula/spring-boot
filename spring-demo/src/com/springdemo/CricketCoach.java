package com.springdemo;

public class CricketCoach implements Coach {
	

	// private field
	private FortuneService fortuneService;
	private String email;
	private String team;
	
	
	
	// constructor
	public CricketCoach() {
		System.out.println("Constructor for cricket coach");
	}
	
	
	// getter email
	public String getEmail() {
		return email;
	}

	// setter email
	public void setEmail(String email) {
		this.email = email;
	}

	// getter team
	public String getTeam() {
		return team;
	}

	// setter team
	public void setTeam(String team) {
		this.team = team;
	}

	// getter fortunate service
	public FortuneService getFortuneService() {
		return fortuneService;
	}
	
	// setter fortunate service
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	
	//	method
	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "Practice fast bowling for 15 minutes";
	}
	

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
