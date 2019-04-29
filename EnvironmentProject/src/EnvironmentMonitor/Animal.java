package EnvironmentMonitor;

import java.time.LocalDate;

public class Animal extends Organism {

	public Animal(LocalDate lastCounted, int amount) {
		super(lastCounted, amount, speciesName);
	}

	@Override
	public Integer getlastCounted() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String speciesName() {
		// TODO Auto-generated method stub
		return null;
	}
	public String toString() {
		return super.toString();
	}

}
