/*
 * This is an example to show the procedure of reading objects 
 * from MySQL DB using specific primary key with Hibernate.
 * 
 * @Author
 * Yuming Jiang
 */

package com.jiang.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jiang.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Student tmp_student = new Student("Yuming", "Jiang", "cjcjiang@gmail.com");
			session.beginTransaction();
			session.save(tmp_student);
			session.getTransaction().commit();
			
			// Reading objects with Hibernate
			session = factory.getCurrentSession();
			session.beginTransaction();
			Student retrieved_student = session.get(Student.class, tmp_student.getId());
			System.out.println(retrieved_student);
			session.getTransaction().commit();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
