package com.example.project.models.Home;

import com.google.gson.annotations.SerializedName;

public class BannersItem{

	@SerializedName("image")
	private String image;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

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

	@Override
 	public String toString(){
		return 
			"BannersItem{" + 
			"image = '" + image + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}