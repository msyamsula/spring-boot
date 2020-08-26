package com.hibernate.mapping;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class mainDelete {

	public static void main(String[] args) {
		// connect to db with session factory via hibernate config file
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		// get session		
		Session session = factory.getCurrentSession();
		
		try {
			// get new session and transactions
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// directly delete without retrieving it
			session.createQuery("delete from Student s where s.id > 4").executeUpdate();
			
			// another approach is to get the data and delete it on by on
//			List<Student> students = session.createQuery("from Student s where s.id > 4").getResultList();
//			for(Student s : students) {
//				session.delete(s);
//			}
			
			// commit
			session.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			factory.close();
		}

	}

}
