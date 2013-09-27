package com.suruga.tabandroid;

import java.io.Serializable;

public class Item implements Serializable {
	private static final long serialVersionUID = -5435670920302756945L;
	
	private String name = "";
	private double value = 0;
	private String image = "";
	private int id=0;

	public Item(int id, String name, String img) {
		this.setId(id);
		this.setName(name);
		this.setImage(img);
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id=id;
	}
	
	public String getImage(){
		return image;
	}
	
	public void setImage(String img){
		this.image=img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}