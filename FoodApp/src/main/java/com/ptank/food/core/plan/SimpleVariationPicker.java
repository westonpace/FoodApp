package com.ptank.food.core.plan;

import java.util.List;

import com.ptank.food.core.cooking.Recipe;

public class SimpleVariationPicker implements VariationPicker {

	@Override
	public Recipe pick(List<Recipe> recipes) {
		if(recipes.size() > 0) {
			return recipes.get(0);
		} else {
			return null;
		}
	}

}
