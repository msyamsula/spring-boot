package com.self.spring.security.controller;


import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.self.spring.security.entity.User;
import com.self.spring.security.service.UserService;

@RestController
@RequestMapping("/api/user")
public class RestUserController {
	
	@Autowired
	private UserService userService;

	public RestUserController() {
	}
	
	@GetMapping("/")
	public List<User> getAll() {
		return userService.getAll();
	}
	
	@GetMapping("/id/{id}")
	public User getById(@PathVariable Integer id) {
		return userService.getById(id); 
	}
	
	@GetMapping("/name/{name}")
	public User getByName(@PathVariable String name) {
		return userService.getByName(name); 
	}
	
	@GetMapping("/name/{name}/remove/{role}")
	@Transactional
	public String removeRole(@PathVariable String name, @PathVariable String role) {
		userService.removeRole(name, role);
		return "redirect:/";
	}
	
	@GetMapping("/access/denied")
	public String denied() {
		return "denied";
	}

}
