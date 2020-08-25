package com.spring.annotations;

import org.springframework.stereotype.Component;

@Component()
public class UnhappyFortuneService implements FortuneService {

	@Override
	public String getFortuneService() {
		// TODO Auto-generated method stub
		return "I'm feeling unhappy";
	}

}
