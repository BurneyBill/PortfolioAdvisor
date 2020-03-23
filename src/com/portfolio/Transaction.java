package com.portfolio;

/*
 * Transaction
 * 
 * Contains the information for each recommended transaction.
 * 
 */
public class Transaction {

	double amount;
	String fromCategory;
	String toCategory;

	public Transaction(double a, String from, String to) {
		this.amount = a;
		this.fromCategory = from;
		this.toCategory = to;
	}

	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getFromCategory() {
		return fromCategory;
	}
	
	public void setFromCategory(String fromCategory) {
		this.fromCategory = fromCategory;
	}
	
	public String getToCategory() {
		return toCategory;
	}
	
	public void setToCategory(String toCategory) {
		this.toCategory = toCategory;
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Amount: " + this.amount);
		result.append(", From: " + this.fromCategory);
		result.append(", To: " + this.toCategory);

		return result.toString();
	}
}
