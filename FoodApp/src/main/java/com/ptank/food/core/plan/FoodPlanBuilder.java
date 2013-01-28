package com.ptank.food.core.plan;

import java.util.ArrayList;
import java.util.List;

import com.ptank.food.core.FoodItem;
import com.ptank.food.core.cooking.Recipe;
import com.ptank.food.core.cooking.RecipeLibrary;
import com.ptank.food.core.scheduler.Meal;
import com.ptank.food.core.scheduler.MealSchedule;
import com.ptank.food.core.scheduler.MealScheduleDay;
import com.ptank.food.core.scheduler.RequiredFoodAmountCalculator;

public class FoodPlanBuilder {

	private RecipeLibrary recipeLibrary;
	private VariationPicker variationPicker;
	private RequiredFoodAmountCalculator foodAmountCalculator;
	
	public FoodPlanBuilder(RecipeLibrary recipeLibrary, VariationPicker variationPicker, RequiredFoodAmountCalculator requiredFoodAmountCalculator) {
		this.recipeLibrary = recipeLibrary;
		this.variationPicker = variationPicker;
		this.foodAmountCalculator = requiredFoodAmountCalculator;
	}
	
	public FoodPlan createFoodPlan(MealSchedule schedule, int numDays) {
		List<DayPlan> dayPlans = new ArrayList<DayPlan>();
		List<FoodItem> neededItems = new ArrayList<FoodItem>();
		for(MealScheduleDay daySchedule : schedule.getDaySchedules()) {
			DayPlan dayPlan = createDayPlan(daySchedule,neededItems);
			dayPlans.add(dayPlan);
		}
		return new FoodPlan(dayPlans,neededItems);
	}
	
	private DayPlan createDayPlan(MealScheduleDay daySchedule, List<FoodItem> neededItems) {
		List<MealPlan> mealPlans = new ArrayList<MealPlan>();
		for(Meal meal : daySchedule.getMeals()) {
			mealPlans.add(createMealPlan(meal,neededItems));
		}
		return new DayPlan(mealPlans);
	}
	
	private Recipe pickVariation(FoodItem neededItem, List<Recipe> recipes) {
		ArrayList<Recipe> usableRecipes = new ArrayList<Recipe>();
		for(Recipe recipe : recipes) {
			for(FoodItem foodItem : recipe.getYield()) {
				if(foodItem.getFoodConcept().equals(neededItem.getFoodConcept())) {
					usableRecipes.add(recipe);
				}
			}
		}
		return variationPicker.pick(usableRecipes);
	}
	
	private MealPlan createMealPlan(Meal meal,List<FoodItem> neededItems) {
		List<FoodItem> neededFoodItems = meal.getFoodItemsRequiredForMeal(foodAmountCalculator);
		List<Recipe> recipes = new ArrayList<Recipe>();
		while(!neededFoodItems.isEmpty()) {
			FoodItem foodItem = neededFoodItems.remove(0);
			Recipe result = pickVariation(foodItem, recipeLibrary.getRecipes());
			if(result != null) {
				recipes.add(result);
				neededFoodItems.addAll(result.getIngredients());
			} else {
				neededItems.add(foodItem);
			}
		}
		return new MealPlan(meal,recipes);
	}
}
