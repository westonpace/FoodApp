package com.ptank.food.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlID;

/**
 * A food concept represents an abstract foodlike thing.  Much of the time the code
 * deals with food items instead.  A food item is a food
 * concept instantiated with a quantity.  A food product is something that you
 * buy that provides food items.  A recipe requires food items and produces food
 * items.
 * 
 * Food concepts are mostly referred to in meal plans.  A user thinks "I want to
 * have pan fried chicken tonight".  They do not think "I want to have 2.4 pan
 * fried chicken breasts tonight".
 */
public class FoodConcept {

	private String name;
	private String pluralName;
	private List<FoodConcept> children = new ArrayList<FoodConcept>();
	private List<FoodConcept> parents = new ArrayList<FoodConcept>();

	protected FoodConcept() {
		
	}
	
	public FoodConcept(String name, String pluralName) {
		this.name = name;
		this.pluralName = pluralName;
	}
	
	@XmlID
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPluralName() {
		return pluralName;
	}

	public void setPluralName(String pluralName) {
		this.pluralName = pluralName;
	}
	
	public Collection<FoodConcept> getParents() {
		return parents;
	}
	
	public Collection<FoodConcept> getChildren() {
		return children;
	}
	
	public void establishRelationshipWithChild(FoodConcept to) {
		children.add(to);
		to.parents.add(this);
	}
	
	public String toString() {
		return name;
	}
	
}
