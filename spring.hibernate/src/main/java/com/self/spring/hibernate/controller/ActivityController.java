package com.self.spring.hibernate.controller;


import java.util.List;

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

import com.self.spring.hibernate.entity.Activity;
import com.self.spring.hibernate.entity.JsonTest;
import com.self.spring.hibernate.entity.Person;

// keep in mind there is "@Controller" and "@RestController"
// if you want to return full page use "@Controller"
@RestController
@RequestMapping("/activity")
public class ActivityController {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@GetMapping("/list/person/{personId}")
	@Transactional
	public List<Activity> getList(@PathVariable Integer personId) {
		Session session = sessionFactory.getCurrentSession();
		
		String hql = "from Activity a where a.personId = " + personId;
		
		System.out.println(hql);
		
		List<Activity> activities = session.createQuery(hql).getResultList();
		
		return activities;
	}
	
	@GetMapping("/test")
	public JsonTest Test() {
		JsonTest a = new JsonTest("waw", 10, "wiw");
		System.out.println(a);
		
		return a;
	}
	
	@PostMapping("/person/{personId}")
	@Transactional
	public List<Activity> addActivity(@RequestBody Activity activity, @PathVariable Integer personId){
		Session session = sessionFactory.getCurrentSession();
		Person person = session.get(Person.class, personId);
		
		activity.setPersonId(personId);
		
		person.addActivity(activity);
		System.out.println(person.getActivities());
		System.out.println(activity.getDone());
		session.save(activity);
		
		return person.getActivities();
	}
}
