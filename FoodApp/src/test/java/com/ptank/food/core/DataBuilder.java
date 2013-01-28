package com.ptank.food.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ptank.food.core.cooking.Recipe;
import com.ptank.food.core.grocery.FoodProduct;
import com.ptank.food.core.grocery.FoodStore;
import com.ptank.food.core.grocery.OfferedFoodProduct;
import com.ptank.food.core.scheduler.Meal;
import com.ptank.food.core.scheduler.MealScheduleDay;

public class DataBuilder {

	public FoodConcept createFoodConceptByName(String name, String plural) {
		return new FoodConcept(name,plural);
	}
	
	public List<FoodConcept> createBasicFoodConcepts() {
		List<FoodConcept> result = new ArrayList<FoodConcept>();
		result.add(createFoodConceptByName("hamburger","hamburgers"));
		result.add(createFoodConceptByName("ground beef",null));
		result.add(createFoodConceptByName("lettuce","heads of lettuce"));
		result.add(createFoodConceptByName("tomato","tomatoes"));
		result.add(createFoodConceptByName("ketchup",null));
		result.add(createFoodConceptByName("mustard",null));
		result.add(createFoodConceptByName("mayonnaise",null));
		result.add(createFoodConceptByName("hamburger bun","hamburger buns"));
		result.add(createFoodConceptByName("cheddar",null));
		result.add(createFoodConceptByName("taco", "tacos"));
		result.add(createFoodConceptByName("taco shell", "taco shells"));
		result.add(createFoodConceptByName("sour cream", null));
		return result;
	}
	
	public FoodLibrary createBasicFoodLibrary() {
		FoodLibrary result = new FoodLibrary();
		result.createNewFoodConcepts(createBasicFoodConcepts());
		return result;
	}
	
	public FoodItem createFoodItem(FoodLibrary foods, String foodName, double amount, UnitType unit) {
		FoodConcept foodConcept = foods.findByName(foodName);
		if(foodConcept == null) {
			throw new RuntimeException("Can't find food concept with name: " + foodName);
		}
		return new FoodItem(foodConcept, unit, amount);
	}
	
	public Recipe createHamburgerRecipe(FoodLibrary foods) {
		List<FoodItem> yield = new ArrayList<FoodItem>();
		List<FoodItem> ingredients = new ArrayList<FoodItem>();
		yield.add(createFoodItem(foods, "hamburger", 4, UnitType.Unit));
		ingredients.add(createFoodItem(foods, "ground beef", 1, UnitType.Pound));
		ingredients.add(createFoodItem(foods, "lettuce",0.25,UnitType.Unit));
		ingredients.add(createFoodItem(foods, "tomato",1,UnitType.Unit));
		ingredients.add(createFoodItem(foods, "ketchup",1,UnitType.NoUnit));
		ingredients.add(createFoodItem(foods, "mustard",1,UnitType.NoUnit));
		ingredients.add(createFoodItem(foods, "mayonnaise",1,UnitType.NoUnit));
		ingredients.add(createFoodItem(foods, "hamburger bun",4,UnitType.Unit));
		ingredients.add(createFoodItem(foods, "cheddar",0.25,UnitType.Cup));
		int bakingTime = 10;
		int prepTime = 15;
		String instructions = "Form ground beef into patties.  Cook patties.  Place cooked patties and other ingredients onto hamburger buns.";
		return new Recipe("Hamburgers",ingredients,yield,instructions,prepTime,bakingTime);
	}
	
	public Recipe createTacoRecipe(FoodLibrary foods) {
		List<FoodItem> yield = new ArrayList<FoodItem>();
		List<FoodItem> ingredients = new ArrayList<FoodItem>();
		yield.add(createFoodItem(foods, "taco", 4, UnitType.Unit));
		ingredients.add(createFoodItem(foods, "ground beef", 0.5, UnitType.Pound));
		ingredients.add(createFoodItem(foods, "lettuce", 0.25, UnitType.Unit));
		ingredients.add(createFoodItem(foods, "tomato", 1, UnitType.Unit));
		ingredients.add(createFoodItem(foods, "cheddar", 2, UnitType.Ounce));
		ingredients.add(createFoodItem(foods, "taco shell", 4, UnitType.Unit));
		ingredients.add(createFoodItem(foods, "sour cream", 1, UnitType.NoUnit));
		int bakingTime = 10;
		int prepTime = 15;
		String instructions = "Brown ground beef.  Shred lettuce.  Dice tomato.  Shred cheese.  Add beef, lettuce, tomato, cheddar, and sour cream to taco shell.";
		return new Recipe("Tacos",ingredients,yield,instructions,prepTime,bakingTime);
	}
	
	public Meal createMeal(FoodLibrary foodLibrary, String ... foodNames) {
		List<FoodConcept> foods = new ArrayList<FoodConcept>();
		for(String foodName : foodNames) {
			FoodConcept food = foodLibrary.findByName(foodName);
			if(food == null) {
				throw new RuntimeException("Couldn't find food by the name of " + foodName);
			}
			foods.add(food);
		}
		return new Meal(Meal.Dinner, foods, 2);
	}
	
	public MealScheduleDay createDaySchedule(Meal ... meals) {
		MealScheduleDay result = new MealScheduleDay();
		result.addMeals(Arrays.asList(meals));
		return result;
	}
	
	private void addBasicRecipes(FoodApp foodApp) {
		foodApp.getRecipeLibrary().addNewRecipe(createHamburgerRecipe(foodApp.getFoodLibrary()));
		foodApp.getRecipeLibrary().addNewRecipe(createTacoRecipe(foodApp.getFoodLibrary()));
	}
	
	private void addBasicFoodConcepts(FoodApp foodApp) {
		foodApp.getFoodLibrary().createNewFoodConcepts(createBasicFoodConcepts());
	}
	
	private void addBasicMealSchedule(FoodApp foodApp) {
		FoodLibrary foodLibrary = foodApp.getFoodLibrary();
		foodApp.getMealSchedule().addDaySchedule(createDaySchedule(createMeal(foodLibrary,"hamburger")));
		foodApp.getMealSchedule().addDaySchedule(createDaySchedule(createMeal(foodLibrary, "taco")));
	}
	
	public FoodProduct createFoodProduct(FoodItem foodItem, String name) {
		return new FoodProduct(name, Arrays.asList(foodItem));
	}
	
	public OfferedFoodProduct createOfferedFoodProduct(FoodItem foodItem, String name, BigDecimal cost, String location) {
		return new OfferedFoodProduct(createFoodProduct(foodItem, name), cost, location);
	}
	
	public FoodStore createFoodStore(FoodLibrary foods) {
		FoodStore result = new FoodStore();
		result.getOfferedProducts().add(createOfferedFoodProduct(
				                        createFoodItem(foods, "lettuce", 1, UnitType.Unit),
				                        "Iceburg lettuce head", new BigDecimal("1.29"), 
				                        "Produce Aisle"));
		return result;
	}
	
	public FoodApp createFoodAppWithBasicData() {
		FoodApp foodApp = new FoodApp();
		addBasicFoodConcepts(foodApp);
		addBasicRecipes(foodApp);
		addBasicMealSchedule(foodApp);
		return foodApp;
	}
	
}
