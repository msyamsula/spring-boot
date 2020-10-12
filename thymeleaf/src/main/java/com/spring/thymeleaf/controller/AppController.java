package com.spring.thymeleaf.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    
    @GetMapping("/api")
    public String api(Model model){
        model.addAttribute("date", new Date());
        return "init-page";
    }
}
