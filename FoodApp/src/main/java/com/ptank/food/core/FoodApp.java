package com.ptank.food.core;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.ptank.food.core.cooking.RecipeLibrary;
import com.ptank.food.core.grocery.FoodStore;
import com.ptank.food.core.grocery.OfferedFoodProduct;
import com.ptank.food.core.plan.FoodPlan;
import com.ptank.food.core.plan.FoodPlanBuilder;
import com.ptank.food.core.plan.SimpleVariationPicker;
import com.ptank.food.core.plan.VariationPicker;
import com.ptank.food.core.scheduler.MealSchedule;
import com.ptank.food.core.scheduler.RequiredFoodAmountCalculator;
import com.ptank.food.core.scheduler.SimpleRequiredFoodAmountCalculator;

/**
 * This is the top level class for the app.
 * @author Pace
 *
 */
@XmlRootElement
public class FoodApp {

	private RecipeLibrary recipeLibrary = new RecipeLibrary();
	private List<FoodStore> foodStores = new ArrayList<FoodStore>();
	private MealSchedule mealSchedule = new MealSchedule();
	private FoodLibrary foodLibrary = new FoodLibrary();
	
	public RecipeLibrary getRecipeLibrary() {
		return recipeLibrary;
	}
	
	public void setRecipeLibrary(RecipeLibrary recipeLibrary) {
		this.recipeLibrary = recipeLibrary;
	}
	
	public List<FoodStore> getFoodStores() {
		return foodStores;
	}
	
	public void setFoodStores(List<FoodStore> foodStores) {
		this.foodStores = foodStores;
	}
	
	public MealSchedule getMealSchedule() {
		return mealSchedule;
	}
	
	public void setMealSchedule(MealSchedule mealSchedule) {
		this.mealSchedule = mealSchedule;
	}

	public FoodLibrary getFoodLibrary() {
		return foodLibrary;
	}

	public void setFoodLibrary(FoodLibrary foodLibrary) {
		this.foodLibrary = foodLibrary;
	}
	
	public List<OfferedFoodProduct> createGroceryList(int numberOfDays) {
		VariationPicker variationPicker = new SimpleVariationPicker();
		RequiredFoodAmountCalculator foodAmountCalculator = new SimpleRequiredFoodAmountCalculator();
		FoodPlanBuilder foodPlanBuilder = new FoodPlanBuilder(recipeLibrary,variationPicker,foodAmountCalculator);
		FoodPlan foodPlan = foodPlanBuilder.createFoodPlan(mealSchedule, numberOfDays);
		System.out.println(foodPlan);
		//Go from food plan to list of items to buy
		return null;
	}
	
}
