package EnvironmentMonitor;

public class LandEnvironment extends Environment implements HasLand {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7146086570856071249L;
	
	public LandEnvironment(String environmentName, double latitude, double longitude) {
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
