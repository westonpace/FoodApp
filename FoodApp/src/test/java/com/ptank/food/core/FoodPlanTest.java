package com.ptank.food.core;

import org.junit.Test;

public class FoodPlanTest {

	@Test
	public void testBuildingGroceryList() {
		FoodApp foodApp = new DataBuilder().createFoodAppWithBasicData();
		foodApp.createGroceryList(2);
	}
	
}
