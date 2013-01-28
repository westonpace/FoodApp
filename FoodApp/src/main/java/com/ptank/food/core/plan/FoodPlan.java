package com.ptank.food.core.plan;

import java.util.ArrayList;
import java.util.List;

import com.ptank.food.core.FoodItem;
import com.ptank.food.core.grocery.OfferedFoodProduct;

public class FoodPlan {

	private List<DayPlan> dayPlans = new ArrayList<DayPlan>();
	private List<FoodItem> neededFoodItems = new ArrayList<FoodItem>();
	
	public FoodPlan(List<DayPlan> dayPlans,List<FoodItem> neededFoodItems) {
		this.dayPlans.addAll(dayPlans);
		this.neededFoodItems.addAll(neededFoodItems);
	}
	
	public void addDayPlan(DayPlan dayPlan) {
		dayPlans.add(dayPlan);
	}
	
	public String toString() {
		String result = "===Food Plan===\n";
		result += "==Day Plans==";
		for(DayPlan dayPlan : dayPlans) {
			result += "\n" + dayPlan;
		}
		result += "\n==Needed Items==";
		for(FoodItem neededItem : neededFoodItems) {
			result += "\n" + neededItem;
		}
		return result;
	}
	
}
