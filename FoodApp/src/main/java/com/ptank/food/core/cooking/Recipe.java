package com.ptank.food.core.cooking;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.ptank.food.core.FoodItem;

/**
 * A recipe requires food products and produces food products.  It also contains
 * instructions on how to craft the output products from the input products.
 */
@XmlType(propOrder={"name","prepTime","bakingTime","instructions","ingredients","yield"})
public class Recipe {

	private String name;
	private List<FoodItem> ingredients;
	private List<FoodItem> yield;
	private String instructions;
	private int prepTime;
	private int bakingTime;
	
	protected Recipe() {
		
	}
	
	public Recipe(String name, List<FoodItem> ingredients, List<FoodItem> yield, String instructions, int prepTime, int bakingTime) {
		this.name = name;
		this.ingredients = new ArrayList<FoodItem>(ingredients);
		this.yield = new ArrayList<FoodItem>(yield);
		this.instructions = instructions;
		this.prepTime = prepTime;
		this.bakingTime = bakingTime;
	}
	
	@XmlElement(name="ingredient")
	public List<FoodItem> getIngredients() {
		return ingredients;
	}
	
	public void setIngredients(List<FoodItem> ingredients) {
		this.ingredients = ingredients;
	}
	
	@XmlElement(name="yieldedItem")
	public List<FoodItem> getYield() {
		return yield;
	}
	
	public void setYield(List<FoodItem> yield) {
		this.yield = yield;
	}
	
	public String getInstructions() {
		return instructions;
	}
	
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	
	public int getPrepTime() {
		return prepTime;
	}
	
	public void setPrepTime(int prepTime) {
		this.prepTime = prepTime;
	}
	
	public int getBakingTime() {
		return bakingTime;
	}
	
	public void setBakingTime(int bakingTime) {
		this.bakingTime = bakingTime;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		String result = "Recipe: " + name + "\n\n";
		result += "Prep Time: " + prepTime + "\n";
		result += "Cook Time: " + bakingTime + "\n";
		result += "Ingredients:\n";
		for(FoodItem item : ingredients) {
			result += "\t" + item + "\n";
		}
		result += "Instructions:\n";
		result += "\t" + instructions + "\n";
		result += "Yields:\n";
		for(FoodItem item : yield) {
			result += "\t" + item + "\n";
		}
		return result;
	}
}
