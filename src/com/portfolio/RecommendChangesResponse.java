package com.portfolio;

import java.util.ArrayList;

/*
 * RecommendChangesResponse
 * 
 * JSON value returned from recommendChanges request.
 * 
 */
public class RecommendChangesResponse {

	private String description;
	private ArrayList<Transaction> transactions;
	
	public RecommendChangesResponse(String desc, ArrayList<Transaction> trans) {
		this.description = desc;
		this.transactions = trans;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}
	
	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}	
}
