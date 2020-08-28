package com.hibernate.full;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.table.Course;
import com.hibernate.table.Instructor;
import com.hibernate.table.InstructorDetail;
import com.hibernate.table.Student;



public class HibernateFull {
	private static Session session;
	private static SessionFactory factory;
	
	private static void setFactory(SessionFactory f) {
		factory = f;
	}
	private static void getNewSession() {
		session = factory.getCurrentSession();
		session.beginTransaction();
	}
	private static void commit() {
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		// load hibernate config and save it to session factory
		SessionFactory fact = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		setFactory(fact);
		
		// get block
//		try {
//			// new session and begin trx
//			getNewSession();
//			
//			@SuppressWarnings("unchecked")
//			List<Instructor> instructors = session.createQuery("from Instructor").getResultList();
//			
//			for(Instructor instructor : instructors) {
//				System.out.println(instructor.toString());
//			}
//			
//			commit();
//			
//		} catch (Exception e) {
//			System.out.println(e.toString());
//		}
		
		// insert many to many
//		try {
//			getNewSession();
//			
//			// create student syamsul
//			Student student = (Student) session.createQuery("from Student s where s.first_name = 'fajar'").getSingleResult();
//			// get list course 4,5,6
//			List<Course> courses = session.createQuery("from Course c where c.id in (9,10)").getResultList();
//			
//			for(Course course : courses) {
//				student.addCourse(course);
//			}
//			
//			session.save(student);
//			for(Course course : courses) {
//				session.save(course);
//			}
//			
//			commit();
//		} catch (Exception e) {
//		}
		
		// insert one instructor many course
//		try {
//			getNewSession();
//			Instructor instructor = new Instructor("I am", "new");
//			// get course mandi and makan
//			List<Course> courses = session.createQuery("from Course c where c.title = 'mandi' OR c.title = 'makan'").getResultList();
//			for(Course course : courses) {
//				instructor.addCourse(course);
//				course.setInstructor(instructor);
//			}
//			
//			session.save(instructor);
//			for(Course course : courses) {
//				session.save(course);
//			}
//			
//			commit();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
		// delete duplicate mandi course
//		try {
//			getNewSession();
//			
//			Course course = session.get(Course.class, 5);
//			
//			session.delete(course);
//			
//			commit();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
		// new multiple course with new multiple student
//		try {
//			getNewSession();
//			
//			Student student1 = new Student("new Student", "one", "tes"), student2 = new Student("nubmer", "two", "tes");
//			Course course1 = new Course("course hit 1"), course2 = new Course("course hit 2");
//			
//			course1.addStudent(student1);
//			course1.addStudent(student2);
//			
//			course2.addStudent(student1);
//			course2.addStudent(student2);
//			
//			session.save(student1);
//			session.save(student2);
//			session.save(course1);
//			session.save(course2);
//			
//			commit();
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}

	}

}
