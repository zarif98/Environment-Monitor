package EnvironmentMonitor;

public class WaterAndLandEnvironment extends Environment implements HasWater, HasLand {

	public WaterAndLandEnvironment(String environmentName) {
		super(environmentName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean hasLandPlants() {
		// TODO Auto-generated method stub
		return false;
	}
}
