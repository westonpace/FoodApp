package com.ptank.food.core.io;

import java.io.OutputStreamWriter;

import org.junit.Test;

import com.ptank.food.core.DataBuilder;
import com.ptank.food.core.FoodApp;
import com.ptank.food.core.grocery.FoodStore;

public class FoodAppXmlIOTest {

	
	@Test
	public void testSerializeFoodApp() {
		FoodApp foodApp = new DataBuilder().createFoodAppWithBasicData();
		FoodAppXmlIO io = new FoodAppXmlIO();
		io.save(foodApp, new OutputStreamWriter(System.out));
	}

	@Test
	public void testSerializeFoodStore() {
		FoodApp foodApp = new DataBuilder().createFoodAppWithBasicData();
		FoodStore foodStore = new DataBuilder().createFoodStore(foodApp.getFoodLibrary());
		FoodAppXmlIO io = new FoodAppXmlIO();
		io.save(foodStore, new OutputStreamWriter(System.out));
	}
	
}
