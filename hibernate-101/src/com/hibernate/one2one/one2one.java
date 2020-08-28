package com.hibernate.one2one;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class one2one {

	public static void main(String[] args) {
		
		// load hibernate config file and create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class) // register InstructorDetail
				.addAnnotatedClass(Instructor.class) // register Instructor
				.buildSessionFactory();
		
		// session
		Session session;
		
		// get block
//		try {
//			// new session and begin transactions
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			// get certain instructor
//			List<Instructor> ins = session.createQuery("from Instructor").getResultList();
//			
//			for(Instructor i : ins) {
//				System.out.println(i.extended());
//			}
//			
//			// commit 
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			System.out.println(e.toString());
//		}
		
		// delete block
//		try {
//			// new session and begin transactions
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			// delete certain instructor
//			List<Instructor> ins = session.createQuery("from Instructor i where i.firstName = 'fajar'").getResultList();
//			
//			for(Instructor i : ins) {
//				session.delete(i);
//			}
//			
//			// commit 
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			System.out.println(e.toString());
//		}
		
		
		// insert block
//		try {
//			// get new session and begin transactions
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			// create object
//			Instructor instructor = new Instructor("fajar", "imam");
//			InstructorDetail detail = new InstructorDetail("freeyoutube.com", "tidur");
//			
//			// attach detail to instructor via setter in instructor
//			instructor.setInstructorDetail(detail);
//			
//			System.out.println(instructor.getDetailId());
//			
//			session.save(instructor);
//			
//			// commit
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			System.out.println(e.toString());
//		}
		
		// update block
//		try {
//			// new session and begin trx
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			// update
//			session.createQuery("update Instructor i set i.detailId = 6 where i.firstName='fajar'").executeUpdate();
//			
//			// commit
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			System.out.println(e.toString());
//		}
		
		factory.close();

	}

}
