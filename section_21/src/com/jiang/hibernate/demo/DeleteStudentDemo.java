/*
 * This is an example to show the procedure of deleting objects 
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

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			// Delete the student's information whose id is 4
			Student query_result = session.get(Student.class, 4);
			session.delete(query_result);
			session.getTransaction().commit();
			
			// Delete the student's information whose last name is jiang
			session = factory.getCurrentSession();
			session.beginTransaction();
			session
			.createQuery("delete from Student"
					+ " where last_name='Jiang'")
			.executeUpdate();
			session.getTransaction().commit();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
