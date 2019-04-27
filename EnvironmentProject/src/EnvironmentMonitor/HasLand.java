package EnvironmentMonitor;

public interface HasLand {
	
	public boolean hasLandPlants();
	default boolean checkLand() {
		return true;
	}
}
