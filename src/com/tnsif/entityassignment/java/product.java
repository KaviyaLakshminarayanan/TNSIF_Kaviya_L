package com.tnsif.entityassignment.java;

public class product {
	private String name;
	private int amount;
	private String manufacturing_date;
	private String expiry_date;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public String getManufacturing_date() {
		return manufacturing_date;
	}


	public void setManufacturing_date(String manufacturing_date) {
		this.manufacturing_date = manufacturing_date;
	}


	public String getExpiry_date() {
		return expiry_date;
	}


	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}


	@Override
	public String toString() {
		return "product [name=" + name + ", amount=" + amount + ", manufacturing_date=" + manufacturing_date
				+ ", expiry_date=" + expiry_date + "]";
	}

}
