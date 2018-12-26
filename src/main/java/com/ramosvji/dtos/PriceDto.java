package com.ramosvji.dtos;

import java.io.Serializable;

public class PriceDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private double amount;
	private String currency;
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	@Override
	public String toString() {
		return "PriceDto [amount=" + amount + ", currency=" + currency + "]";
	}
		
}
