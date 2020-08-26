package com.spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// @Controller specify that class is spring controller
@Controller()
public class HomeController {
	
	// map this method into / path
	@RequestMapping("/")
	public String showPage() {
		return "main-menu";
	}
	
	// map showform
	@RequestMapping("/showForm")
	public String showForm(){
		return "hello-world-form";
	}
	
	// map showform
	@RequestMapping("/helloWorld")
	public String helloWorld(){
		return "hello-world";
	}
	
	@RequestMapping("/hellowWorldVersionThree")
	public String toUpper(HttpServletRequest request, Model model){
		
		// get param from request
		String nameString = request.getParameter("name");
		
		// convert data to all caps
		nameString = nameString.toUpperCase();
		
		// create the message
		String message = "Yo " + nameString;
		
		// add message to model
		model.addAttribute("message", message);
		
		return "hello-world";
	}
	
	
	// Use @RequestParam("paramName") to directly get param in request
	// instead of using HttpServletRequest
	@RequestMapping("/hellowWorldVersionTwo")
	public String toUpper(@RequestParam("name") String nameString, Model model){
		
		// convert data to all caps
		nameString = nameString.toUpperCase();
		
		// create the message
		String message = "Yo " + nameString + " waw";
		
		// add message to model
		model.addAttribute("message", message);
		
		return "hello-world";
	}

}
