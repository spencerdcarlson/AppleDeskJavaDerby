package com.sc.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graph {
	List<String> categories;
	List<Float> values;
	List<Bar> bars;
	public static int usableWidth;
	public static int usableHeight;
	private float maxValue;
	private int numberOfBars;

	
	public Graph(){
		categories = new ArrayList<String>();
		values = new ArrayList<Float>();
		bars = new ArrayList<Bar>();
	}
	
	public void setData(ArrayList<String> categories, ArrayList<Float> values){
		bars.clear();
		this.categories = categories;
		this.values = values;
		for(int i = 0; i < categories.size(); i++){
			bars.add(new Bar(categories.get(i),values.get(i)));
//			System.out.println("Category(" + i +") " + categories.get(i) );
//			System.out.println("Value(" + i +") " + values.get(i) );
		}
		numberOfBars = this.categories.size();
		maxValue = Collections.max(values);
		setBarHeights();
		
		
	}
	public int getNumberOfBars(){
		return numberOfBars;
	}
	public List<Bar> getBars(){
		return bars;
	}

	private void setBarHeights() {
		for(Bar b: bars){
			if (b.getValue() == maxValue){
				b.setMaxBar(true);
			}
			b.setHeight((int)((b.getValue()/maxValue) * usableHeight));
			b.setWidth((int)( usableWidth / numberOfBars ));
		}
	}
	public String toString(){
		String string = "[GRAPH] Usable Height: " + usableHeight + " Usable Width: " + usableWidth + 
				" Max Value: " + maxValue + " Number of Bars: " + numberOfBars;
		for(Bar b: bars){
			string += b.toString();
		}
		return string;
	}

	
	
}
