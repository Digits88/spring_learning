package com.jiang.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {
	
	@Autowired
	private FortuneService myFortuneService;

	@Override
	public String getDailyWorkout() {
		return "My coach is TrackCoach.";
	}

	@Override
	public String getDailyFortune() {
		return myFortuneService.getFortune();
	}

}
