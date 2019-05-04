package EnvironmentMonitor;

import java.time.LocalDate;

public class Animal extends Organism {

	public Animal(LocalDate lastCounted, int amount, Species species) {
		super(lastCounted, amount, species);
	}
}
