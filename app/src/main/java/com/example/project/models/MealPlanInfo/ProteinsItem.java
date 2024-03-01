package com.example.project.models.MealPlanInfo;

import com.google.gson.annotations.SerializedName;

public class ProteinsItem{

	@SerializedName("proteins")
	private String proteins;

	@SerializedName("proteins_price")
	private String proteinsPrice;

	public void setProteins(String proteins){
		this.proteins = proteins;
	}

	public String getProteins(){
		return proteins;
	}

	public void setProteinsPrice(String proteinsPrice){
		this.proteinsPrice = proteinsPrice;
	}

	public String getProteinsPrice(){
		return proteinsPrice;
	}

	@Override
 	public String toString(){
		return 
			"ProteinsItem{" + 
			"proteins = '" + proteins + '\'' + 
			",proteins_price = '" + proteinsPrice + '\'' + 
			"}";
		}
}