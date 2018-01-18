package com.jiang.springdemo;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RandomFortune implements FortuneService {
	
	private ArrayList<String> fortuneList = new ArrayList<String>();
	@Value("${fortune_1}")
	private String fortune_1;
	@Value("${fortune_2}")
	private String fortune_2;
	@Value("${fortune_3}")
	private String fortune_3;

	@Override
	public String getFortune() {
		fortuneList.add(fortune_1);
		fortuneList.add(fortune_2);
		fortuneList.add(fortune_3);
		System.out.println(fortuneList);
		Random rand = new Random();
		int  n = rand.nextInt(3) ;
		return "Today's fortune is " + fortuneList.get(n);
	}

}
