package com.ptank.food.core.scheduler;

import com.ptank.food.core.FoodConcept;
import com.ptank.food.core.FoodItem;

public interface RequiredFoodAmountCalculator {

	public FoodItem getAmountRequired(FoodConcept foodConcept, int numberOfPeople);
	
}
