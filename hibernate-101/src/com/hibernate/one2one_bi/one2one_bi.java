package com.hibernate.one2one_bi;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class one2one_bi {

	public static void main(String[] args) {
		
		// load hibernate config file and create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class) // register InstructorDetail
				.addAnnotatedClass(Instructor.class) // register Instructor
				.buildSessionFactory();
		
		// session
		Session session;
		
		// delete instructor detail without cascade
		try {
			
			// new session and begin transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// get instruction detail
			InstructorDetail ins = session.get(InstructorDetail.class, 11);
			
			System.out.println(ins.detailExtended());
			
			ins.getInstructor().setInstructorDetail(null);
			
			// delete instruction detail
			session.delete(ins);
			
			// commit
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// leak demo
//		try {
//			// new session and begin transactions
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			// get non exist data
//			Instructor ins = session.get(Instructor.class, 10);
//			
////			System.out.println(ins.extended());
//			
//			// commit
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			System.out.println(e.toString());
//		}
		
		// get block
//		try {
//			// new session and begin transactions
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			// get certain instructor
//			List<InstructorDetail> ins = session.createQuery("from InstructorDetail insd where insd.hobby = 'wakwaw'").getResultList();
//			
//			for(InstructorDetail i : ins) {
//				System.out.println(i.detailExtended());
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
////			InstructorDetail detail = new InstructorDetail("freeyoutube.com", "tidur");
//			
//			// attach detail to instructor via setter in instructor
////			instructor.setInstructorDetail(detail);
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
