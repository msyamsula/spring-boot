package com.springrest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.entity.Student;

@RestController // tell that this class is a rest controller
@RequestMapping("/api") // specify root for this class
public class StudentController {
	
	private static List<Student> students;
	
	private static void loadData() {
		Student a = new Student("a", "a"), b = new Student("b", "b"), c = new Student("c", "c");
		
		List<Student> ans = new ArrayList<Student>();
		ans.add(a);
		ans.add(b);
		ans.add(c);
		
		students = ans;
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello World from spring-rest";
	}
	
	@GetMapping("/students")
	public List<Student> getStudent(){
		loadData();
		return students;
	}
	
	@GetMapping("/students/{studentId}") // use variable in url
	public Student getSingleStudent(@PathVariable Integer studentId) {
		loadData();
		Integer n = students.size();
		System.out.println(n);
		System.out.println(studentId);
		return students.get(studentId);
	}
}
