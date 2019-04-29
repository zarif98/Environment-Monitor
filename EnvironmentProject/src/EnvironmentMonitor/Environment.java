package EnvironmentMonitor;

import java.util.ArrayList;
import java.time.LocalDate;

public abstract class Environment {
	private ArrayList<Guide> guides;
	private ArrayList<Organism> organisms;
	private LocalDate lastCleanedDate;
	private ArrayList<Job> jobs;
	private ArrayList<Volunteer> volunteers;
	protected String environmentName;
	protected double longitude;
	protected static double latitude;
	
	public Environment(String environmentName, double latitude
			, double longitude) {
		this.environmentName = environmentName;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	public void addJob(Job job) {
		jobs.add(job);
	}
	public void addVolunteers(Volunteer volunteer) {
		volunteers.add(volunteer);
	}
	public abstract double getDistanceTo();
	
	public String toString() {
		return environmentName + " (" + latitude + ", " + longitude + ")" +
				" is " + getDistanceTo() + "km away.";
	}
	
	public String getEnvironmentName() {
		return environmentName;
	}
	
	
}

