package com.ptank.food.core.grocery;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.ptank.food.core.FoodItem;

/**
 * A food product represents something that you buy from a store.  It provides various
 * food items.  For example, a condiment variety pack may provide 48 oz. of ketchup,
 * 24 oz. of mustard, and 24 oz. of mayonnaise.
 * 
 * Food products may be provided by grocery stores in the form of an OfferedFoodProduct. 
 */
public class FoodProduct {

	private String productName;
	private List<FoodItem> providedFoodItems;

	protected FoodProduct() {
		
	}
	
	public FoodProduct(String productName, List<FoodItem> providedFoodItems) {
		this.productName = productName;
		this.providedFoodItems = new ArrayList<FoodItem>(providedFoodItems);
	}
	
	@XmlElement(name="providedFoodItem")
	public List<FoodItem> getProvidedFoodItems() {
		return providedFoodItems;
	}

	public void setProvidedFoodItems(List<FoodItem> providedFoodItems) {
		this.providedFoodItems = providedFoodItems;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}
