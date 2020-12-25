package com.csgog.Forms;

public class BidForm {
	private int amount;
	
	//roulette
	private String type;
	
	//crash
	private double multipiler;
	
	//matchbetting
	private int which;
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public double getMultipiler() {
		return multipiler;
	}
	public void setMultipiler(double multipiler) {
		this.multipiler = multipiler;
	}
	
	
	public int getWhich() {
		return which;
	}
	public void setWhich(int which) {
		this.which = which;
	}
	@Override
	public String toString() {
		return "BidForm [amount=" + amount + ", type=" + type + "]";
	}
}
