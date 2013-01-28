package com.ptank.food.core;

import java.text.DecimalFormat;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;

import com.ptank.food.util.Fraction;

/**
 * A food item is a food concept instantiated with an amount.  That amount is
 * parameterized by a unit type.  Food items are required by and produced by
 * recipes.  Food items are also produced by food products bought from the store.
 * 
 * This is an immutable value type
 */
public class FoodItem {

	private FoodConcept foodConcept;
	private UnitType unitType;
	private double amount;
	
	private static final DecimalFormat dropTrailingZeroFormatter = new DecimalFormat("0.##"); 
	
	protected FoodItem() {
		
	}
	
	public FoodItem(FoodConcept foodConcept, UnitType unitType, double amount) {
		this.foodConcept = foodConcept;
		this.unitType = unitType;
		this.amount = amount;
	}
	
	@XmlIDREF
	public FoodConcept getFoodConcept() {
		return foodConcept;
	}
	
	@XmlElement
	public UnitType getUnitType() {
		return unitType;
	}
	
	@XmlElement
	public double getAmount() {
		return amount;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((foodConcept == null) ? 0 : foodConcept.hashCode());
		result = prime * result
				+ ((unitType == null) ? 0 : unitType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FoodItem other = (FoodItem) obj;
		if (Double.doubleToLongBits(amount) != Double
				.doubleToLongBits(other.amount))
			return false;
		if (foodConcept == null) {
			if (other.foodConcept != null)
				return false;
		} else if (!foodConcept.equals(other.foodConcept))
			return false;
		if (unitType != other.unitType)
			return false;
		return true;
	}

	public String toString() {
		if(unitType == UnitType.NoUnit) {
			return foodConcept.getName();
		} 
		if (unitType == UnitType.Unit && amount == 1) {
			return "1 " + foodConcept.getName();
		} 
		String amountString = dropTrailingZeroFormatter.format(amount);
		if(Fraction.fromDouble(amount) != null) {
			amountString = Fraction.fromDouble(amount).getName();
		}
		if (unitType == UnitType.Unit) {
			return amountString + " " + foodConcept.getPluralName();
		}
		if(amount == 1) {
			return "" + amountString + " " + unitType + " of " + foodConcept.getName();
		}
		
		return "" + amountString + " " + unitType.getPlural() + " of " + foodConcept.getName();
	}
}
