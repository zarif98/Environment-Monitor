package EnvironmentMonitor;

public class WaterAndLandEnvironment extends Environment implements HasWater, HasLand {

	public WaterAndLandEnvironment(String environmentName, double latitude, double longitude) {
		super(environmentName, latitude, longitude);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean hasLandPlants() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String toString() {
		return super.toString();
	}
}
