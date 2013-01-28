package com.ptank.food.core.plan;

import java.util.List;

import com.ptank.food.core.cooking.Recipe;

/**
 * There are two ways that a particular food concept can be obtained.  One can
 * either buy it at a store or make it from a recipe.
 * 
 * Often there are many different products that could be purchased and recipes
 * that produce the same food product.  It is the variation picker's job to
 * figure out how a food product should be obtained.
 */
public interface VariationPicker {
	
	public Recipe pick(List<Recipe> recipes);
	
}
