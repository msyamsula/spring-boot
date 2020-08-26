package com.hibernate.mapping;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class mainUpdate {

	public static void main(String[] args) {
		// connect to db with session factory via hibernate config file
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			// get new session and transactions
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve data
//			Student student = session.get(Student.class, 2);
			// update data
//			student.setEmail("fajar@gmail.com");
			
			// retrive data
			List<Student> students = session.createQuery("from Student s where" + " s.firstName = 'daffy' OR s.firstName = 'sukarno'").getResultList();
			
			for(Student s : students) {
				s.setEmail("bulkupdate@gmail.com");
			}
			
			// commit
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		} finally {
			factory.close();
		}
	}

}
