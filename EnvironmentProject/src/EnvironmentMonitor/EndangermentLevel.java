package EnvironmentMonitor;

public enum EndangermentLevel {
	Producer(10000), Consumer(5000), SecondaryConsumer(2000), TertiaryConsumer(500);
	
	private final int population;
	
	/**
	 * Stores the set population in population
	 * @param population
	 */
	EndangermentLevel(int population){
		this.population = population;
	}
	
	/**
	 * Getter for population
	 * @return
	 */
	public int getEndangeredPopulation() {
		return population;
	}
}
