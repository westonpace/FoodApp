package com.ptank.food.core;

public enum UnitType {

	NoUnit(null),
	Unit(null),
	Cup("cups"),
	Teaspoon("teaspoons"),
	Tablespoon("tablespoons"),
	Ounce("ounces"),
	Pound("pound");
	
	private String plural;
	
	private UnitType(String plural) {
		this.plural = plural;
	}
	
	public String getPlural() {
		return plural;
	}
	
}
