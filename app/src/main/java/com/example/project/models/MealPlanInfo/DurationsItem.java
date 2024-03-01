package com.example.project.models.MealPlanInfo;

import com.google.gson.annotations.SerializedName;

public class DurationsItem{

	@SerializedName("duration")
	private String duration;

	@SerializedName("suspend")
	private String suspend;

	@SerializedName("price")
	private String price;

	@SerializedName("non_stop_price")
	private String nonStopPrice;

	@SerializedName("enable_modification")
	private String enableModification;

	public void setDuration(String duration){
		this.duration = duration;
	}

	public String getDuration(){
		return duration;
	}

	public void setSuspend(String suspend){
		this.suspend = suspend;
	}

	public String getSuspend(){
		return suspend;
	}

	public void setPrice(String price){
		this.price = price;
	}

	public String getPrice(){
		return price;
	}

	public void setNonStopPrice(String nonStopPrice){
		this.nonStopPrice = nonStopPrice;
	}

	public String getNonStopPrice(){
		return nonStopPrice;
	}

	public void setEnableModification(String enableModification){
		this.enableModification = enableModification;
	}

	public String getEnableModification(){
		return enableModification;
	}

	@Override
 	public String toString(){
		return 
			"DurationsItem{" + 
			"duration = '" + duration + '\'' + 
			",suspend = '" + suspend + '\'' + 
			",price = '" + price + '\'' + 
			",non_stop_price = '" + nonStopPrice + '\'' + 
			",enable_modification = '" + enableModification + '\'' + 
			"}";
		}
}