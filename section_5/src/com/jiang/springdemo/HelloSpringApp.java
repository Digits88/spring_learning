package com.jiang.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach myCoach = context.getBean("myCoach", Coach.class);
		
		System.out.println(myCoach.getDailyWorkout());
		
		System.out.println(myCoach.getDailyFortune());
		
		BasketballCoach mySetterCoach = context.getBean("mySetterCoach", BasketballCoach.class);
		
		System.out.println(mySetterCoach.getDailyWorkout());
		
		System.out.println(mySetterCoach.getDailyFortune());
		
		System.out.println(mySetterCoach.getEmail());
		
		System.out.println(mySetterCoach.getTeam());
		
		context.close();

	}

}
