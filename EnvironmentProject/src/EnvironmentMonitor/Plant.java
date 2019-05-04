package EnvironmentMonitor;

import java.time.LocalDate;

public class Plant extends Organism {

	public Plant(LocalDate lastCounted, int amount, Species species) {
		super(lastCounted, amount, species);
	}
}
