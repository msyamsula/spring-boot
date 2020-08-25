package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// @Controller specify that class is spring controller
@Controller()
public class HomeController {
	
	// map this method into / path
	@RequestMapping("/")
	public String showPage() {
		return "main-menu";
	}

}
