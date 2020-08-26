package com.hibernate.mapping;

import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class mainRead {

	public static void main(String[] args) {
		
		// connect to db with session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create current session
		Session session = factory.getCurrentSession();
		
		// use session to save/retrieve object
		try {
			/*
			 * this block is used for insert data to db
			 * */
			
			// create new data
			Student newStudent = new Student("syamsul", "arifin", "msyamsula1995@gmail.com");
			Student newStudent2 = new Student("fajar", "imam", "fajarimam@gmail.com");
			Student newStudent3 = new Student("sukarno", "st", "sukarno@gmail.com");
			Student newStudent4 = new Student("daffy", "duck", "daffy@gmail.com");
			
			// start transactions
			session.beginTransaction();
			
			// save the student object
			session.save(newStudent);
			session.save(newStudent2);
			session.save(newStudent3);
			session.save(newStudent4);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("done!");
			
			
			/*
			 * this part is used for read data from db
			 * */
			
//			// start new session and transactions
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			
//			Student query = session.get(Student.class, 3);
//			
//			System.out.println(query.getFullName());
//			
//			// commit
//			session.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			factory.close();
		}
		

	}

}
