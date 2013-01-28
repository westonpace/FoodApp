package com.ptank.food.core.plan;

import java.util.List;

import com.ptank.food.core.cooking.Recipe;
import com.ptank.food.core.grocery.OfferedFoodProduct;
import com.ptank.food.core.scheduler.Meal;

public class MealPlan {

	private Meal meal;
	private List<Recipe> recipes;
	
	public MealPlan(Meal meal, List<Recipe> recipes) {
		this.meal = meal;
		this.recipes = recipes;
	}
	
	public String toString() {
		String result = meal + "\n";
		for(Recipe recipe : recipes) {
			result += "Recipe: " + recipe.getName() + "\n";
		}
		return result;
	}
	
}
