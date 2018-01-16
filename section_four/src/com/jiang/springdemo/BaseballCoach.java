package com.jiang.springdemo;

public class BaseballCoach implements Coach{
	
	@Override
	public String getDailyWorkout() {
		return "my coach is baseball";
	}
}
