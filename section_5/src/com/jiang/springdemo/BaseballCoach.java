package com.jiang.springdemo;

public class BaseballCoach implements Coach{
	
private FortuneService myFortuneService;
	
	public BaseballCoach(FortuneService myFortuneService) {
		this.myFortuneService = myFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "My coach is BaseballCoach.";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return myFortuneService.getFortune();
	}
}
