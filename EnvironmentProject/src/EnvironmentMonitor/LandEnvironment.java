package EnvironmentMonitor;

public class LandEnvironment extends Environment implements HasLand {
	private String EnvironmentType;
	
	public LandEnvironment(String environmentName) {
		super(environmentName);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean hasLandPlants() {
		// TODO Auto-generated method stub
		return false;
	}

}
