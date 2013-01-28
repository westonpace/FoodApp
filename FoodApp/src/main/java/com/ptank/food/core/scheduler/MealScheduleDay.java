package com.ptank.food.core.scheduler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * A DayPlan contains all the meals for a single day
 */
public class MealScheduleDay {

	private Date day;
	private List<Meal> meals = new ArrayList<Meal>();
	
	public Date getDay() {
		return day;
	}
	
	public void setDay(Date day) {
		this.day = day;
	}
	
	@XmlElement(name="meal")
	public List<Meal> getMeals() {
		return meals;
	}
	
	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}
	
	public void addMeal(Meal meal) {
		this.meals.add(meal);
	}
	
	public void addMeals(Collection<? extends Meal> meals) {
		this.meals.addAll(meals);
	}
}
