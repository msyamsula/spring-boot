package com.spring.annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// @Component = annotation to register TennisCoach class to spring container with beanId = tennisCoach
@Component()
@Scope("singleton") // specify scope with @Scope annotations
public class TennisCoach implements Coach {
	
	
	// inject value from file that has been loaded from spring config file with @Value annotations
	@Value("${foo.team}")
	private String team;
	
	@Value("${foo.email}")
	private String email;
	
	private FortuneService FortuneService;
	
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

	public FortuneService getFortuneService() {
		return FortuneService;
	}
	
	// inject fortune spring to setter method
	@Autowired()
	@Qualifier("happyFortuneService")
	public void setFortuneService(FortuneService FortuneService) {
		this.FortuneService = FortuneService;
	}



	// constructor
	// using @Value and @Qualifier to inject specific object / file variable in constructor
	@Autowired()
	public TennisCoach(@Value("${foo.email}") String e, @Value("${foo.team}") String t) {
		super();
		System.out.println(e);
		System.out.println(t);
	}
	


	@Override()
	public String getDailyWorkOut() {
		return "Practice your backhand volley";
	}
	
	
	public String getDailyFortune() {
		return FortuneService.getFortuneService();
	}
	
	@PostConstruct()
	public void postConstruct() {
		System.out.println("object is created");
	}
	
	@PreDestroy()
	public void preDestroy() {
		System.out.println("object is destroyed");
	}
	
	

}
