package EnvironmentMonitor;

import java.time.LocalDate;

public abstract class Organism {
	
	protected LocalDate lastCounted;
	protected int amount;
	protected String speciesName;
	
	public Organism(LocalDate lastCounted, int amount, String speciesName) {
		lastCounted = lastCounted.now();
		this.speciesName = speciesName;
		this.amount = amount;
	}
	public abstract Integer getlastCounted();
	public abstract String speciesName();
	
	public String toString() {
		return amount + " " +speciesName + " were spotted at" + lastCounted.toString()  ;
	}

}
