package com.example.project.models.Home;

import com.google.gson.annotations.SerializedName;

public class MealPlansItem{

	@SerializedName("meal_types")
	private String mealTypes;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	public void setMealTypes(String mealTypes){
		this.mealTypes = mealTypes;
	}

	public String getMealTypes(){
		return mealTypes;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"MealPlansItem{" + 
			"meal_types = '" + mealTypes + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}