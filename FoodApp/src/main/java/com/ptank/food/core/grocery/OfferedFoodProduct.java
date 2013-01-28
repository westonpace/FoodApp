package com.ptank.food.core.grocery;

import java.math.BigDecimal;

/**
 * An offered food product is an instantiation of a food product tied to a specific
 * store.  Two stores may offer a 12-pack of Lipton iced tea packets but those
 * stores may have the product at different prices and in different locations.
 */
public class OfferedFoodProduct {

	private FoodProduct foodProduct;
	private BigDecimal cost;
	private String location;
	
	protected OfferedFoodProduct() {
		super();
	}
	
	public OfferedFoodProduct(FoodProduct foodProduct, BigDecimal cost, String location) {
		this.foodProduct = foodProduct;
		this.cost = cost;
		this.location = location;
	}
	
	public BigDecimal getCost() {
		return cost;
	}
	
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}

	public FoodProduct getFoodProduct() {
		return foodProduct;
	}

	public void setFoodProduct(FoodProduct foodProduct) {
		this.foodProduct = foodProduct;
	}
	
}
