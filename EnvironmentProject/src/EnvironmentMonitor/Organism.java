package EnvironmentMonitor;

import java.time.LocalDate;

public abstract class Organism {
	
	protected LocalDate lastCounted;
	protected int amount;
	protected Species species;
	
	/**
	 * Constructor for organism
	 * @param lastCounted
	 * @param amount
	 * @param speciesName
	 */
	public Organism(LocalDate lastCounted, int amount, Species species) {
		lastCounted = LocalDate.now();
		this.species = species;
		this.amount = amount;
	}
	
	/**
	 * Getter for amount
	 * @return amount
	 */
	public int getAmount() {
		return amount;
	}
	
	/**
	 * Getter for lastCounted
	 * @return lastCounted
	 */
	public LocalDate getLastCounted() {
		return lastCounted;
	}
	
	/**
	 * Getter for species
	 * @return speciesName
	 */
	public Species getSpecies() {
		return species;
	}
	
	/**
	 * Generates string for 
	 */
	public String toString() {
		return amount + " " + (amount==1?(species.getSingular() + " was"):(species.getPlural() + " were")) + 
				" spotted at " + lastCounted.toString();
	}
	
	/**
	 * Setter for amount, also sets the last counted date to now
	 * @param count
	 */
	public void recount(int count) {
		amount = count;
		lastCounted = LocalDate.now();
	}

}
