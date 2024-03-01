package com.example.project.models.MealPlanInfo;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("amount")
	private String amount;

	@SerializedName("quantity")
	private String quantity;

	public void setAmount(String amount){
		this.amount = amount;
	}

	public String getAmount(){
		return amount;
	}

	public void setQuantity(String quantity){
		this.quantity = quantity;
	}

	public String getQuantity(){
		return quantity;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"amount = '" + amount + '\'' + 
			",quantity = '" + quantity + '\'' + 
			"}";
		}
}