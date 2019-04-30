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
	
	/**
	 * Constructor for environment, sets instance variables
	 * @param environmentName
	 * @param latitude
	 * @param longitude
	 */
	public Environment(String environmentName, double latitude
			, double longitude) {
		this.environmentName = environmentName;
		this.longitude = longitude;
		this.latitude = latitude;
		jobs = new ArrayList<Job>();
	}
	
	/**
	 * Adds a job to an environment
	 * @param job
	 * @return true if job was successfully added
	 */
	public boolean addJob(Job job) {
		return jobs.add(job);
	}
	
	public void removeJob(Job job) {
		jobs.remove(job);
	}

	/**
	 * Add volunteer to list
	 * @param volunteer
	 * @return true if successful
	 */
	public boolean addVolunteers(Volunteer volunteer) {
		return volunteers.add(volunteer);
	}
	
	/**
	 * Find distance from Rowan
	 * @return distance in miles
	 */
	public double getDistanceTo() {
		double STATUTE_MILES_PER_NAUTICAL_MILE = 1.15077945;
        double lat1 = Math.toRadians(39.70701); //latitude of Rowan
        double lon1 = Math.toRadians(-75.1207); //longitude of Rowan
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
	
	/**
	 * toString for environment
	 * @return String with the name and distance from Rowan
	 */
	public String toString() {
		return environmentName + " (" + latitude + ", " + longitude + ")" +
				" is " + getDistanceTo() + "km away.";
	}
	
	/**
	 * Getter for environment name
	 * @return environmentName
	 */
	public String getEnvironmentName() {
		return environmentName;
	}
	
	/**
	 * Getter for list of jobs
	 * @return
	 */
	public ArrayList<Job> getJobs(){
		return jobs;
	}
}

