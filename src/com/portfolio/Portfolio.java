package com.portfolio;

/*
 * Portfolio
 * 
 * Portfolio definition. And ID number and the categories with names and percentages.
 * 
 */
public class Portfolio {

	private int portfolioNumber;
	private Category[] categories;

	public Portfolio() {};
	
	public Portfolio(int pNum, int[] catValues, String[] catNames) {
		this.portfolioNumber = pNum;
		this.categories = new Category[Constants.NUM_CATEGORIES];	
		for (int i = 0; i < Constants.NUM_CATEGORIES; i++) {
			this.categories[i] = new Category(catValues[i], catNames[i]);
		}
	}
	
	public int getPortfolioNumber() {
		return portfolioNumber;
	}

	public Category getCategory(int index) {
		return this.categories[index];
	}

	public int getCategoryValue(int index) {
		return this.categories[index].value;
	}

	public String getCategoryName(int index) {
		return this.categories[index].name;
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Portfolio details: ");
		result.append("number:" + this.portfolioNumber);
		
		for (int i = 0; i < Constants.NUM_CATEGORIES; i++) {
			result.append(", " + this.categories[i].name + ":" + this.categories[i].value);
		}

		return result.toString();
	}
}
