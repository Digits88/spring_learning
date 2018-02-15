/*
 * This is an example to show the procedure of updating objects 
 * from MySQL DB with Hibernate.
 * 
 * @Author
 * Yuming Jiang
 */

package com.jiang.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jiang.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			// Update the student's email whose id is 4
			Student query_result = session.get(Student.class, 4);
			query_result.setEmail("cjcjiang@163.com");
			
			session.getTransaction().commit();
			
			// Update the student's email whose first name is yuming
			session = factory.getCurrentSession();
			session.beginTransaction();
			session
			.createQuery("update Student set email='test@qwe.com'"
					+ " where first_name='Yuming'")
			.executeUpdate();
			session.getTransaction().commit();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
