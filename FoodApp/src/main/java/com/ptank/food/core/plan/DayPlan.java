package com.ptank.food.core.plan;

import java.util.ArrayList;
import java.util.List;

public class DayPlan {

	private List<MealPlan> mealPlans = new ArrayList<MealPlan>();
	
	public DayPlan(List<MealPlan> mealPlans) {
		this.mealPlans.addAll(mealPlans);
	}
	
	public String toString() {
		String result = "Day Plan:";
		for(MealPlan mealPlan : mealPlans) {
			result += "\n" + mealPlan.toString();
		}
		return result;
	}
	
}
