package com.ptank.food.util;

public class Fraction {
	
	private double value;
	private String name;
	
	private Fraction(double value, String name) {
		this.value = value;
		this.name = name;
	}
	
	public static Fraction OneEighth = new Fraction(1.0/8.0, "one eighth");
	public static Fraction OneFourth = new Fraction(1.0/4.0, "one fourth");
	public static Fraction OneThird = new Fraction(1.0/3.0, "one third");
	public static Fraction OneHalf = new Fraction(1.0/2.0, "one half");
	public static Fraction TwoThirds = new Fraction(2.0/3.0, "two thirds");
	public static Fraction ThreeFourths = new Fraction(3.0/4.0, "three fourths");
	public static Fraction SevenEighths = new Fraction(7.0/8.0, "seven eighths");

	public static Fraction [] OrderedFractions = {OneEighth,OneFourth,OneThird,OneHalf,
		                                          TwoThirds,ThreeFourths,SevenEighths};
	
	public String getName() {
		return name;
	}
	
	public double getValue() {
		return value;
	}
	
	public static Fraction fromDouble(double value) {
		for(Fraction fraction : OrderedFractions) {
			if(Math.abs(value - fraction.value) <= 0.0005) {
				return fraction;
			}
		}
		return null;
	}
	
}
