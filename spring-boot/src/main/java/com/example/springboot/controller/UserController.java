package com.example.springboot.controller;

import java.util.List;

import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/user/all")
    public List<User> getAll(){
        return userService.findall();
    }

    @PostMapping("/user")
    public String postUser(@RequestBody User user){

        userService.postUser(user);

        return "success";
    }

    @GetMapping("/user/role/{role}")
    public List<User> getUserByRole(@PathVariable String role){
        return userService.getUserByRole(role);
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Integer id){
        User ans = userService.getById(id);
        System.out.println("==================");
        System.out.println(ans);
        return ans;
    }
}
