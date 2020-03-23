package com.portfolio;

/*
 * PortfolioConfig
 * 
 * Portfolio configuration. Definition of portfolio for each risk level and category names.
 * 
 */
public class PortfolioConfig {

	private Portfolio[] portfolios;
	private String[] categoryNames;
	
	PortfolioConfig(Portfolio[] portfolios, String[] categoryNames) {
		this.portfolios = new Portfolio[Constants.NUM_PORTFOLIOS];
		this.categoryNames = new String[Constants.NUM_CATEGORIES];
		this.portfolios = portfolios;
		this.categoryNames = categoryNames;
	}

	public Portfolio[] getPortfolios() {
		return portfolios;
	}

	public void setPortfolios(Portfolio[] portfolios) {
		this.portfolios = portfolios;
	}

	public Portfolio getPortfolio(int index) {
		return portfolios[index];
	}

	public String[] getCategoryNames() {
		return categoryNames;
	}

	public void setCategoryNames(String[] categoryNames) {
		this.categoryNames = categoryNames;
	}
	
	public String getCategoryName(int index) {
		return categoryNames[index];
	}

}
