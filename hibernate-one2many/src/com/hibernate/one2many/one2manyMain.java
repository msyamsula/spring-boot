package com.hibernate.one2many;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class one2manyMain {

	public static void main(String[] args) {
		// get hibernate config and save it in session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
				
		Session session;
		
//		try {
//			// new session and begin trx
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			// create instructor with course
//			Instructor instructor = new Instructor("syamsul", "arifin");
//			Course course = new Course("wakwaw");
//			InstructorDetail instructorDetail = new InstructorDetail("wah", "enak nih");
//			
//			instructor.setInstructorDetail(instructorDetail);
//			instructor.addCourse(course);
//			
//			session.save(instructorDetail);
//			session.save(instructor);
//			session.save(course);
//			
//			// commit
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println(e.toString());
//		}
		
		// update block
//		try {
//			// new session, begin trx
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			// get syamsul
//			Instructor instructor = (Instructor) session.createQuery("from Instructor i where i.firstName = 'syamsul'").getSingleResult();
//			// create course
//			Course a = new Course("mandi"), b = new Course("makan");
//			instructor.addCourse(a);
//			instructor.addCourse(b);
//			
//			session.save(instructor);
//			session.save(a);
//			session.save(b);
//			
//			// commit
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			System.out.println(e.toString());
//		}
		
		// delete instructor without deleting course
//		try {
//			// new session, begin trx
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			// get course makan
//			Instructor instructor = (Instructor) session.createQuery("from Instructor i where i.firstName = 'syamsul'").getSingleResult();
//			
//			List<Course> courses = instructor.getCourses();
//			
//			for(Course c : courses) {
//				c.setInstructor(null);
//			}
//			
//			session.delete(instructor);
//			
//			// commit
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			System.out.println(e.toString());
//		}
		
		
		// directly delete instructor;
		try {
			// new session, begin trx
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// get course makan
			Instructor instructor = (Instructor) session.createQuery("from Instructor i where i.firstName = 'syamsul'").getSingleResult();
			
//			List<Course> courses = instructor.getCourses();
//			
//			for(Course c : courses) {
//				c.setInstructor(null);
//			}
			
			session.delete(instructor);
			
			// commit
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		factory.close();
	}

}
