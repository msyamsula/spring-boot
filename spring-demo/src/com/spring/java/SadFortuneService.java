package com.spring.java;

import com.spring.annotations.FortuneService;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortuneService() {
		return "Today is a sad day";
	}

}
