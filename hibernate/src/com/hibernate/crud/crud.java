package com.hibernate.crud;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class crud {

	public static void main(String[] args) {
		// connect to db via hibernate config file
		// create new session factory
		SessionFactory factory = new Configuration().configure("hibernate.crud.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
		
		// create new session
		Session session;
		
		// clean up database block
		try {
			// new session and begin transactions
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// delete all data
			session.createQuery("delete Employee e").executeUpdate();
			
			// commit
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
		// insert block
		try {
			// create new session and begin transactions
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// insert 5 data
			Employee e1 = new Employee("syamsul", "arifin", "alterra");
			Employee e2 = new Employee("dhea", "lana", "bank indonesia");
			Employee e3 = new Employee("awan", "rahagung", "telkom");
			Employee e4 = new Employee("ahsan", "abdurahman", "sirkel");
			Employee e5 = new Employee("ikip", "faiz", "smartadeco");
			Employee e6 = new Employee("fadhil", "abdulkarim", "alterra");
			
			// save above data
			List<Employee> employees = new ArrayList<>();
			employees.add(e1);
			employees.add(e2);
			employees.add(e3);
			employees.add(e4);
			employees.add(e5);
			employees.add(e6);
			
			for(Employee e : employees) {
				session.save(e);
			}
			
			// commit
			session.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
		// read block
		try {
			// new session and begin transactions
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// get all data
			List<Employee> emp = session.createQuery("from Employee").getResultList();
			display(emp);
			
			// get all alterra
			emp = session.createQuery("from Employee e where e.company = 'alterra'").getResultList();
			display(emp);
			
			// commit
			session.getTransaction().commit();
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		// update block
		try {
			// new session and begin transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// update
			session.createQuery("update Employee e set e.company = 'google', e.id = 10 where e.firstName = 'syamsul'").executeUpdate();
			
			// commit
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
		// delete block
		try {
			// new session and begin transactions
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// delete
			session.createQuery("delete Employee e where e.firstName != 'syamsul'").executeUpdate();
			
			// commit
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		factory.close();
		
	}

	private static void display(List<Employee> emp) {
		for(Employee e : emp) {
			System.out.println(e.extended());
		}
	}

}
