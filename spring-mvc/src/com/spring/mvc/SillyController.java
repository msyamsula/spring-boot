package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/silly") // parent mapping, all below request fall under /silly/* directory
public class SillyController {
	
	@RequestMapping("/showForm")
	public String displayForm() {
		return "hello-world-form";
	}
}
