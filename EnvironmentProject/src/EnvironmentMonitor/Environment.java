package EnvironmentMonitor;

import java.util.ArrayList;
import java.io.Serializable;
import java.time.LocalDate;

public abstract class Environment implements Serializable{
	private static final long serialVersionUID = -1507661411248543998L;
	private ArrayList<Guide> guides;
	private ArrayList<Organism> organisms;
	private LocalDate lastCleanedDate;
	private ArrayList<Job> jobs;
	private ArrayList<Volunteer> volunteers;
	protected String environmentName;
	protected double longitude;
	protected double latitude;
	
	public Environment(String environmentName, double latitude
			, double longitude) {
		this.environmentName = environmentName;
		this.longitude = longitude;
		this.latitude = latitude;
		jobs = new ArrayList<Job>();
	}
	public void addJob(Job job) {
		jobs.add(job);
	}
	
	public void removeJob(Job job) {
		jobs.remove(job);
	}
	public void addVolunteers(Volunteer volunteer) {
		volunteers.add(volunteer);
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
		return environmentName + " (" + latitude + ", " + longitude + ")" +
				" is " + getDistanceTo() + "km away.";
	}
	
	public String getEnvironmentName() {
		return environmentName;
	}	
	public ArrayList<Job> getJobs(){
		return jobs;
	}
}

