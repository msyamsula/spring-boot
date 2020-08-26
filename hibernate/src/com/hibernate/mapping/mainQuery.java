package com.hibernate.mapping;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class mainQuery {

	public static void main(String[] args) {
		// connect to db with session factory via hibernate config file
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();		
				
		// create current session
		Session session = factory.getCurrentSession();
		
		try {
			// get new session and transactions
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// do query
			List<Student> students = session.createQuery("from Student").getResultList();
			displayStudent(students);
			
			// query with where clause, override students
			students = session.createQuery("from Student s where s.lastName = 'arifin'").getResultList();
			displayStudent(students);
			
			// query with or clause and like, it's pretty much like sql
			// from {ObjectName} {ObjectVariable} where {ObjectVariable}.{ObjectField} = {target}
			// from {ObjectName} {ObjectVariable} where {ObjectVariable}.{ObjectField} like {regex}
			// from {ObjectName} {ObjectVariable} where {ObjectVariable}.{ObjectField} like {regex} or {other query}
			
			// commit
			session.getTransaction().commit();
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			
		}
	}

	private static void displayStudent(List<Student> students) {
		for (Student s : students) {
			System.out.println(s.getFullName());
		}
	}

}
