package com.sc.main;

public class Bar {
	private String category;
	private float value;
	private int height;
	private int width;
	private Boolean maxBar;
	
	public Bar(String category,float value){
		this.category = category;
		this.value = value;
		this.maxBar = false;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	public Boolean getMaxBar() {
		return maxBar;
	}

	public void setMaxBar(Boolean maxBar) {
		this.maxBar = maxBar;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	public String toString(){
		return "[BAR] Category: " + category + " Value: " + value + " Max? " + maxBar + " Width: " + width + " Height: " + height + " ";
	}

}
