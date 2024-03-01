package com.example.project.models.MealPlanInfo;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("meal_plan")
	private MealPlan mealPlan;

	@SerializedName("carbs")
	private List<CarbsItem> carbs;

	@SerializedName("proteins")
	private List<ProteinsItem> proteins;

	@SerializedName("non_stop_check_day")
	private String nonStopCheckDay;

	@SerializedName("start_date_range")
	private int startDateRange;

	@SerializedName("extras")
	private List<ExtrasItem> extras;

	@SerializedName("plan_start_buffer")
	private int planStartBuffer;

	@SerializedName("current_subscription_id")
	private int currentSubscriptionId;

	public void setMealPlan(MealPlan mealPlan){
		this.mealPlan = mealPlan;
	}

	public MealPlan getMealPlan(){
		return mealPlan;
	}

	public void setCarbs(List<CarbsItem> carbs){
		this.carbs = carbs;
	}

	public List<CarbsItem> getCarbs(){
		return carbs;
	}

	public void setProteins(List<ProteinsItem> proteins){
		this.proteins = proteins;
	}

	public List<ProteinsItem> getProteins(){
		return proteins;
	}

	public void setNonStopCheckDay(String nonStopCheckDay){
		this.nonStopCheckDay = nonStopCheckDay;
	}

	public String getNonStopCheckDay(){
		return nonStopCheckDay;
	}

	public void setStartDateRange(int startDateRange){
		this.startDateRange = startDateRange;
	}

	public int getStartDateRange(){
		return startDateRange;
	}

	public void setExtras(List<ExtrasItem> extras){
		this.extras = extras;
	}

	public List<ExtrasItem> getExtras(){
		return extras;
	}

	public void setPlanStartBuffer(int planStartBuffer){
		this.planStartBuffer = planStartBuffer;
	}

	public int getPlanStartBuffer(){
		return planStartBuffer;
	}

	public void setCurrentSubscriptionId(int currentSubscriptionId){
		this.currentSubscriptionId = currentSubscriptionId;
	}

	public int getCurrentSubscriptionId(){
		return currentSubscriptionId;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"meal_plan = '" + mealPlan + '\'' + 
			",carbs = '" + carbs + '\'' + 
			",proteins = '" + proteins + '\'' + 
			",non_stop_check_day = '" + nonStopCheckDay + '\'' + 
			",start_date_range = '" + startDateRange + '\'' + 
			",extras = '" + extras + '\'' + 
			",plan_start_buffer = '" + planStartBuffer + '\'' + 
			",current_subscription_id = '" + currentSubscriptionId + '\'' + 
			"}";
		}
}