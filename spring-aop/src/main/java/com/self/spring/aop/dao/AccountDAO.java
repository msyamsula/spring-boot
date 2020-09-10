package com.self.spring.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	public AccountDAO() {
	}
	
	public String addAccount() {
		return "adding an account";
	}

}
