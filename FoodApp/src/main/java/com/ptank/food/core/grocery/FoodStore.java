package com.ptank.food.core.grocery;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A food store sales a variety of food products in the form of OfferedFoodProducts.
 * A grocery store also has a location and hours.
 */
@XmlRootElement
public class FoodStore {

	private List<OfferedFoodProduct> offeredProducts = new ArrayList<OfferedFoodProduct>();

	@XmlElement(name="offeredProduct")
	public List<OfferedFoodProduct> getOfferedProducts() {
		return offeredProducts;
	}

	public void setOfferedProducts(List<OfferedFoodProduct> offeredProducts) {
		this.offeredProducts = offeredProducts;
	}
	
}
