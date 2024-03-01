package com.example.project.models.MealPlanInfo;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ExtrasItem{

	@SerializedName("data")
	private List<DataItem> data;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
		return data;
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
			"ExtrasItem{" + 
			"data = '" + data + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}