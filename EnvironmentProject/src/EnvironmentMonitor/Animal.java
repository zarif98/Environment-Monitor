package EnvironmentMonitor;

import java.time.LocalDate;

public class Animal extends Organism {

	/**
	 * Constructor for Animal class
	 * @param lastCounted
	 * @param amount
	 * @param species
	 */
	public Animal(LocalDate lastCounted, int amount, Species species) {
		super(lastCounted, amount, species);
	}
}
