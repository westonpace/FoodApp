package com.ptank.food.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class FoodLibrary {

	private List<FoodConcept> foods = new ArrayList<FoodConcept>();

	@XmlElement(name="food")
	public List<FoodConcept> getFoods() {
		return foods;
	}

	public void setFoods(List<FoodConcept> foods) {
		this.foods = foods;
	}
	
	public void createNewFoodConcept(FoodConcept foodConcept) {
		this.foods.add(foodConcept);
	}
	
	public void createNewFoodConcepts(Collection<? extends FoodConcept> foodConcepts) {
		this.foods.addAll(foodConcepts);
	}
	
	public FoodConcept findByName(String name) {
		for(FoodConcept foodConcept : foods) {
			if(foodConcept.getName().equals(name)) {
				return foodConcept;
			}
		}
		return null;
	}
}
