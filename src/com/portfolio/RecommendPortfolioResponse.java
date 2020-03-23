package com.portfolio;

/*
 * RecommendPortfolioResponse
 * 
 * JSON value returned from recommendPortfolio request.
 * 
 */
public class RecommendPortfolioResponse {
	
	private String description;
	private Portfolio portfolio;
	
	public RecommendPortfolioResponse(String desc, Portfolio portfolio) {
		this.description = desc;
		this.portfolio = portfolio;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}
}
