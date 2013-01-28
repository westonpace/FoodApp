package com.ptank.food.core.cooking;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;


/**
 * A recipe library is a collection of recipes.
 */
public class RecipeLibrary {

	private List<Recipe> recipes = new ArrayList<Recipe>();

	@XmlElement(name="recipe")
	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}
	
	public void addNewRecipe(Recipe recipe) {
		this.recipes.add(recipe);
	}
	
}
