package com.csgog.Objects;

import java.util.Random;

public class Field {
	private String number;
	private String HTMLclass;
	private String color;
	
	public Field(){
		Random generator = new Random();
		int num=generator.nextInt(37);
		number=Integer.toString(num)+" ";
		
		String restOfClass=" card-text ml-4 mr-4";
		
		if(num % 2 == 0 && num!=0) {
			color="RED";
			HTMLclass="text-danger"+restOfClass;
		}
		else if(num % 2 != 0) {
			color="BLACK";
			HTMLclass="text-secondary"+restOfClass;
		}
		else { color="GREEN"; HTMLclass="text-success"+restOfClass; }
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}
