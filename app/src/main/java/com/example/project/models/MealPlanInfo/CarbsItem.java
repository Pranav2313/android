package com.example.project.models.MealPlanInfo;

import com.google.gson.annotations.SerializedName;

public class CarbsItem{

	@SerializedName("carbs")
	private String carbs;

	@SerializedName("carbs_price")
	private String carbsPrice;

	public void setCarbs(String carbs){
		this.carbs = carbs;
	}

	public String getCarbs(){
		return carbs;
	}

	public void setCarbsPrice(String carbsPrice){
		this.carbsPrice = carbsPrice;
	}

	public String getCarbsPrice(){
		return carbsPrice;
	}

	@Override
 	public String toString(){
		return 
			"CarbsItem{" + 
			"carbs = '" + carbs + '\'' + 
			",carbs_price = '" + carbsPrice + '\'' + 
			"}";
		}
}