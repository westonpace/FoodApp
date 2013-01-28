package com.ptank.food.core.scheduler;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;

import com.ptank.food.core.FoodConcept;
import com.ptank.food.core.FoodItem;

/**
 * A meal is pretty self-explanatory.  It is a collection of food concepts
 * that is meant to be eaten in one sitting.
 */
public class Meal {

	public static final String Breakfast = "breakfast";
	public static final String Lunch = "lunch";
	public static final String Dinner = "dinner";
	
	private String name;
	private int numberOfDiners;
	private List<FoodConcept> foodConcepts;
	
	protected Meal() {
		
	}
	
	public Meal(String name, List<FoodConcept> foodConcepts, int numberOfDiners) {
		this.name = name;
		this.foodConcepts = foodConcepts;
		this.numberOfDiners = numberOfDiners;
	}
	
	public int getNumberOfDiners() {
		return numberOfDiners;
	}

	public void setNumberOfDiners(int numberOfDiners) {
		this.numberOfDiners = numberOfDiners;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlIDREF
	@XmlElement(name="foodConcept")
	public List<FoodConcept> getFoodConcepts() {
		return foodConcepts;
	}
	
	public void setFoodConcepts(List<FoodConcept> foodConcepts) {
		this.foodConcepts = foodConcepts;
	}

	public List<FoodItem> getFoodItemsRequiredForMeal(RequiredFoodAmountCalculator foodAmountCalculator) {
		ArrayList<FoodItem> foodItems = new ArrayList<FoodItem>();
		for(FoodConcept foodConcept : getFoodConcepts()) {
			FoodItem item = foodAmountCalculator.getAmountRequired(foodConcept, numberOfDiners);
			foodItems.add(item);
		}
		return foodItems;
	}
	
	public String toString() {
		return name + " (" + numberOfDiners + "): " + foodConcepts.toString();
	}
}
