package com.self.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login-page";
	}
	
	@GetMapping("/leaders")
	public String leaderPage() {
		return "leader-page";
	}
	
	@GetMapping("/admins")
	public String adminPage() {
		return "system-admin";
	}
}
