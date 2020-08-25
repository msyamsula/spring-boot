package com.springdemo;

public class HappyFortuneService implements FortuneService {
	
	private String arr[] = {"Today is your lucky day", "I'm not so lucky today", "Today is a bad day"};

	@Override
	public String getFortune() {
		long num = (long)(Math.random()*3);
		return arr[(int)num];
	}

}
