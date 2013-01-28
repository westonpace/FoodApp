package com.ptank.food.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ptank.food.core.FoodApp;

public class FoodAppApplication {

	public static void main(String [] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		FoodApp app = context.getBean(FoodApp.class);
		System.out.println(app);
	}
	
}
