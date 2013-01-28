package com.ptank.food.core.cooking;

import org.junit.Test;

import com.ptank.food.core.DataBuilder;
import com.ptank.food.core.FoodLibrary;

public class RecipeTest {

	@Test
	public void testPrintRecipe() {
		DataBuilder db = new DataBuilder();
		FoodLibrary library = db.createBasicFoodLibrary();
		Recipe recipe = db.createHamburgerRecipe(library);
		System.out.println(recipe);
		
		recipe = db.createTacoRecipe(library);
		System.out.println(recipe);
	}
	
}
