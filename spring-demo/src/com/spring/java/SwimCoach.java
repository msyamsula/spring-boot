package com.spring.java;

import org.springframework.beans.factory.annotation.Value;

import com.spring.annotations.FortuneService;
import com.springdemo.Coach;

public class SwimCoach implements Coach {
	
	private FortuneService fortuneService;
	
	private String team;
	
	private String email;
	
	
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	// if you want to inject at constructor use below construction
	// inject t and e at spring config level
	public SwimCoach(FortuneService fs, String t, String e) {
		super();
		this.fortuneService = fs;
		this.email = e;
		this.team = t;
	}
	

	@Override
	public String getDailyWorkOut() {
		return "Swim back and forth 20 times";
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortuneService();
	}

}
