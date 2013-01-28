package com.ptank.food.core.scheduler;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * A meal plan is a never-ending list of day plans.
 */
public class MealSchedule {

	private List<MealScheduleDay> daySchedules = new ArrayList<MealScheduleDay>();

	@XmlElement(name="daySchedule")
	public List<MealScheduleDay> getDaySchedules() {
		return daySchedules;
	}

	public void setDaySchedules(List<MealScheduleDay> daySchedules) {
		this.daySchedules = daySchedules;
	}
	
	public void addDaySchedule(MealScheduleDay dayPlan) {
		daySchedules.add(dayPlan);
	}
	
}
