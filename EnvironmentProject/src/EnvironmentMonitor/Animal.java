package EnvironmentMonitor;

import java.time.LocalDate;

public class Animal extends Organism {

	public Animal(LocalDate lastCounted, int amount) {
		super(lastCounted, amount, speciesName);
	}

	@Override
	public Integer getlastCounted() {
		// TODO Auto-generated method stub
		return amount;
	}
	
	@Override
	public String speciesName() {
		// TODO Auto-generated method stub
		return speciesName;
	}
	public String toString() {
		return super.toString();
	}

}
