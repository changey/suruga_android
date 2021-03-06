package com.suruga.tabandroid.listview;

import java.io.Serializable;

public class Detail implements Serializable {
	private static final long serialVersionUID = -5435670920302756945L;
	
	private String name = "";
	private String value = "";
	private boolean selected=true;
	private int id=0;

	public Detail(int id, String name, String value, boolean selected) {
		this.setId(id);
		this.setName(name);
		this.setValue(value);
		this.setSelected(selected);
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id=id;
	}
	
	public boolean getSelected(){
		return selected;
	}
	
	public void setSelected(boolean selected){
		this.selected=selected;
	}
	
	public String getValue(){
		return value;
	}
	
	public void setValue(String value){
		this.value=value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}