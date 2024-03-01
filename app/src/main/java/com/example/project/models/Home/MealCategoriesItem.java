package com.example.project.models.Home;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MealCategoriesItem{

	@SerializedName("image")
	private String image;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("meal_plans")
	private List<MealPlansItem> mealPlans;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
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

	public void setMealPlans(List<MealPlansItem> mealPlans){
		this.mealPlans = mealPlans;
	}

	public List<MealPlansItem> getMealPlans(){
		return mealPlans;
	}

	@Override
 	public String toString(){
		return 
			"MealCategoriesItem{" + 
			"image = '" + image + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",meal_plans = '" + mealPlans + '\'' + 
			"}";
		}
}