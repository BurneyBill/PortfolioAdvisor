package com.portfolio;

/*
 * Category
 * 
 * Contains a category name and value.
 * 
 */
public class Category {

	String name;
	int value;
	
	Category(int value, String name) {
		this.value = value;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
}
