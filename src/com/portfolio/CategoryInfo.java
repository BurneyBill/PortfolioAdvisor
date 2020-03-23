package com.portfolio;

/*
 * CategoryInfo
 * 
 * Contains information calculated for category during the process of determining changes.
 * 
 */
public class CategoryInfo {

	private int index;
	private boolean valueLow;
	private boolean valueHigh;
	private double value;
	private double changeNeeded;
	private double percentOfTotal;
	private double percentDifferent;

	public int getIndex() {
		return index;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public boolean isValueLow() {
		return valueLow;
	}
	
	public void setValueLow(boolean valueLow) {
		this.valueLow = valueLow;
	}
	
	public boolean isValueHigh() {
		return valueHigh;
	}
	
	public void setValueHigh(boolean valueHigh) {
		this.valueHigh = valueHigh;
	}
	
	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	public double getChangeNeeded() {
		return changeNeeded;
	}
	
	public void setChangeNeeded(double changeNeeded) {
		this.changeNeeded = changeNeeded;
	}
	
	public double getPercentOfTotal() {
		return percentOfTotal;
	}
	
	public void setPercentOfTotal(double percentOfTotal) {
		this.percentOfTotal = percentOfTotal;
	}
	
	public double getPercentDifferent() {
		return percentDifferent;
	}
	
	public void setPercentDifferent(double percentDifferent) {
		this.percentDifferent = percentDifferent;
	}
}
