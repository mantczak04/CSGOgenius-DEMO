package com.csgog.Objects;

import java.util.Random;

public class Field {
	private String number;
	private String HTMLclass;
	
	public Field(){
		Random generator = new Random();
		int num=generator.nextInt(37);
		number=Integer.toString(num)+" ";
		if(num % 2 == 0 && num!=0) {
			HTMLclass="card-text text-danger";
		}
		else if(num % 2 != 0) {
			HTMLclass="card-text text-secondary";
		}
		else HTMLclass="card-text text-success";
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	

	public String getHTMLclass() {
		return HTMLclass;
	}

	public void setHTMLclass(String hTMLclass) {
		HTMLclass = hTMLclass;
	}
}
