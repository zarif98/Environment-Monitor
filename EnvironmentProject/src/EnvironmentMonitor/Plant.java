package EnvironmentMonitor;

import java.time.LocalDate;

public class Plant extends Organism {

	public Plant(LocalDate lastCounted, int amount, String speciesName) {
		super(lastCounted, amount, speciesName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Integer getlastCounted() {
		// TODO Auto-generated method stub
		return amount;
	}

	@Override
	public String getspeciesName() {
		// TODO Auto-generated method stub
		return speciesName;
	}
	public String toString() {
		return super.toString();
	}

}
