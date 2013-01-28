package com.ptank.food.core.scheduler;

import com.ptank.food.core.FoodConcept;
import com.ptank.food.core.FoodItem;
import com.ptank.food.core.UnitType;

public class SimpleRequiredFoodAmountCalculator implements RequiredFoodAmountCalculator {

	@Override
	public FoodItem getAmountRequired(FoodConcept foodConcept, int numberOfPeople) {
		return new FoodItem(foodConcept,UnitType.Unit,1);
	}

}
