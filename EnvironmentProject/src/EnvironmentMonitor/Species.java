package EnvironmentMonitor;

public enum Species {
	TREE_OAK("Oak Tree", "Oak Trees", EndangermentLevel.Producer),
	TREE_WILLOW("Willow Tree","Willow Trees", EndangermentLevel.Producer),
	BUSH_BLUEBERRY("Blueberry Bush", "Blueberry Bushes", EndangermentLevel.Producer),
	SQUIRREL("Squirrel", "Squirrels", EndangermentLevel.Consumer),
	DEER("Deer", "Deer", EndangermentLevel.Consumer),
	RABBIT("Rabbit", "Rabbits", EndangermentLevel.Consumer),
	FOX("Fox","Foxes", EndangermentLevel.SecondaryConsumer),
	FINCH("Finch", "Finches", EndangermentLevel.SecondaryConsumer),
	HAWK("Hawk", "Hawks", EndangermentLevel.TertiaryConsumer),
	WOLF("Wolf", "Wolves", EndangermentLevel.TertiaryConsumer);
	
	private String singular;
	private String plural;
	private EndangermentLevel endangerment;
	
	/**
	 * Constructor for each organism
	 */
	Species(String singular, String plural, EndangermentLevel endangerment){
		this.singular = singular;
		this.plural = plural;
		this.endangerment = endangerment;
	}

	/**
	 * Getter for singular name
	 * @return singular
	 */
	public String getSingular() {
		return singular;
	}

	/**
	 * Getter for plural name
	 * @return plural
	 */
	public String getPlural() {
		return plural;
	}

	/**
	 * Getter for endangerment level
	 * @return endangerment
	 */
	public EndangermentLevel getEndangerment() {
		return endangerment;
	}
	
	/**
	 * Determines if this organism is a plant
	 * @return true if it's a producer, false if otherwise
	 */
	public boolean isPlant() {
		return endangerment.equals(EndangermentLevel.Producer);
	}
}
