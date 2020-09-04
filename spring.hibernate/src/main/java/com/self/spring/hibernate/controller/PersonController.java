package com.self.spring.hibernate.controller;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.self.spring.hibernate.entity.Person;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@PostMapping("/")
	@Transactional
	public Person addPerson(@RequestBody Person person) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println(person);
		session.save(person);
		
		return person;
	}
	
	@GetMapping("/{personId}")
	@Transactional
	public Person getPerson(@PathVariable Integer personId) {
		Session session = sessionFactory.getCurrentSession();
		
		Person person = session.get(Person.class, personId);
//		person.setActivities(person.getActivities());
		System.out.println(person.getActivities());
		
		return person;
	}
}
