/*
 * This is an example to show the procedure of creating objects 
 * and store those objects into MySQL DB with Hibernate.
 * 
 * @Author
 * Yuming Jiang
 */

package com.jiang.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jiang.hibernate.demo.entity.Instructor;
import com.jiang.hibernate.demo.entity.InstructorDetail;
import com.jiang.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int theId = 2;
			Instructor tmpInstructor = session.get(Instructor.class, theId);
			if(tmpInstructor != null) {
				session.delete(tmpInstructor);
			}else {
				System.out.println("This instructor has already been deleted.");
			}
			
			session.getTransaction().commit();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
