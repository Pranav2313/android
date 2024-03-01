package com.example.project.models.Home;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data{

	@SerializedName("meal_categories")
	private List<MealCategoriesItem> mealCategories;

	@SerializedName("notification_count")
	private int notificationCount;

	@SerializedName("banners")
	private List<BannersItem> banners;

	public void setMealCategories(List<MealCategoriesItem> mealCategories){
		this.mealCategories = mealCategories;
	}

	public List<MealCategoriesItem> getMealCategories(){
		return mealCategories;
	}

	public void setNotificationCount(int notificationCount){
		this.notificationCount = notificationCount;
	}

	public int getNotificationCount(){
		return notificationCount;
	}

	public void setBanners(List<BannersItem> banners){
		this.banners = banners;
	}

	public List<BannersItem> getBanners(){
		return banners;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"meal_categories = '" + mealCategories + '\'' + 
			",notification_count = '" + notificationCount + '\'' + 
			",banners = '" + banners + '\'' + 
			"}";
		}
}