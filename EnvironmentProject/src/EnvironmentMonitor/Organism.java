package EnvironmentMonitor;

import java.time.LocalDate;

public class Organism {
	public Organism(LocalDate lastCounted, int amount) {
		super();
		this.lastCounted = lastCounted;
		this.amount = amount;
	}
	private LocalDate lastCounted;
	private int amount;

}
