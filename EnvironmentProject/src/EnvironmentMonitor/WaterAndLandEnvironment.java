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
	public double getDistanceTo() {
		double STATUTE_MILES_PER_NAUTICAL_MILE = 1.15077945;
        double lat1 = Math.toRadians(39.70701);
        double lon1 = Math.toRadians(-75.1207);
        double lat2 = Math.toRadians(this.latitude);
        double lon2 = Math.toRadians(this.longitude);

        // great circle distance in radians, using law of cosines formula
        double angle = Math.acos(Math.sin(lat1) * Math.sin(lat2)
                               + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));

        // each degree on a great circle of Earth is 60 nautical miles
        double nauticalMiles = 60 * Math.toDegrees(angle);
        double statuteMiles = STATUTE_MILES_PER_NAUTICAL_MILE * nauticalMiles;
        return statuteMiles;
	}
	public String toString() {
		return super.toString();
	}
}
