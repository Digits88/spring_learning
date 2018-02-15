/*
 * This is an example to show the procedure of reading objects 
 * from MySQL DB using any query condition with Hibernate.
 * 
 * @Author
 * Yuming Jiang
 */

package com.jiang.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jiang.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			// Query MySQL with Hibernate
			// Student is the class name of the linked object
			List<Student> query_result = session
					.createQuery("from Student")
					.getResultList();
			
			query_result.forEach(student -> System.out.println(student));
			
			// first_name is the property of the object not the column name in MySQL
			query_result = session
					.createQuery("from Student s where s.first_name='Yuming'")
					.getResultList();
			query_result.forEach(student -> System.out.println(student));
			
			query_result = session
					.createQuery("from Student s where s.email like '%@163.com'")
					.getResultList();
			query_result.forEach(student -> System.out.println(student));
			
			session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
