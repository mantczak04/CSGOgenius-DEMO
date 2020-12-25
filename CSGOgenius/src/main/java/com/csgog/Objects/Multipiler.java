package com.csgog.Objects;

import java.util.Random;

public class Multipiler {
	
	private double multipiler;
	
	public Multipiler() {
			Random random = new Random();
			
			double multipil = random.nextDouble();
			multipil = Math.round(multipil*100.0) / 100.0;
			
			boolean crash=false;
			int integer=0;
			
			do {
			int chance=random.nextInt(100);
			if(chance%4==0) {
				crash=true;
			}
			integer++;
			}while(crash==false);
			multipiler = multipil+integer;
	}

	public double getMultipiler() {
		return multipiler;
	}

	public void setMultipiler(double multipiler) {
		this.multipiler = multipiler;
	}
	
	
}
