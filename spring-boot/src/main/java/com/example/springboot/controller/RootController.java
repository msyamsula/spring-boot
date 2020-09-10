package com.example.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @Value("${team1}")
    private String team1;

    @Value("${team2}")
    private String team2;

    private List<String> ls;
    
    @GetMapping("/")
    public List<String> listOfString(){
        this.ls = null;
        this.ls = new ArrayList<String>();
        this.ls.add(team1); this.ls.add(team2);
        return ls;
    }
}
