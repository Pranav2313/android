package com.example.project.models.MealPlanInfo;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class MealPlan{

	@SerializedName("meal_category_id")
	private int mealCategoryId;

	@SerializedName("image")
	private String image;

	@SerializedName("off_days")
	private List<String> offDays;

	@SerializedName("meal_category_name")
	private String mealCategoryName;

	@SerializedName("info_text")
	private String infoText;

	@SerializedName("name")
	private String name;

	@SerializedName("description")
	private String description;

	@SerializedName("durations")
	private List<DurationsItem> durations;

	@SerializedName("id")
	private int id;

	public void setMealCategoryId(int mealCategoryId){
		this.mealCategoryId = mealCategoryId;
	}

	public int getMealCategoryId(){
		return mealCategoryId;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setOffDays(List<String> offDays){
		this.offDays = offDays;
	}

	public List<String> getOffDays(){
		return offDays;
	}

	public void setMealCategoryName(String mealCategoryName){
		this.mealCategoryName = mealCategoryName;
	}

	public String getMealCategoryName(){
		return mealCategoryName;
	}

	public void setInfoText(String infoText){
		this.infoText = infoText;
	}

	public String getInfoText(){
		return infoText;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setDurations(List<DurationsItem> durations){
		this.durations = durations;
	}

	public List<DurationsItem> getDurations(){
		return durations;
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
			"MealPlan{" + 
			"meal_category_id = '" + mealCategoryId + '\'' + 
			",image = '" + image + '\'' + 
			",off_days = '" + offDays + '\'' + 
			",meal_category_name = '" + mealCategoryName + '\'' + 
			",info_text = '" + infoText + '\'' + 
			",name = '" + name + '\'' + 
			",description = '" + description + '\'' + 
			",durations = '" + durations + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}