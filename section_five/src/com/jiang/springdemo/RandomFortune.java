package com.jiang.springdemo;

import java.util.ArrayList;
import java.util.Random;

public class RandomFortune implements FortuneService {
	
	private ArrayList<String> fortuneList = new ArrayList<String>();
	
	public RandomFortune() {
		super();
		fortuneList.add("fortune-1");
		fortuneList.add("fortune-2");
		fortuneList.add("fortune-3");
	}

	@Override
	public String getFortune() {
		Random rand = new Random();
		int  n = rand.nextInt(3) ;
		return "Today's fortune is " + fortuneList.get(n);
	}

}
