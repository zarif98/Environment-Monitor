package EnvironmentMonitor;

import java.util.ArrayList;
import java.time.LocalDate;

public abstract class Environment {
	private ArrayList<Guide> guides;
	private ArrayList<Organism> organisms;
	private LocalDate lastCleanedDate;
	private ArrayList<Jobs> jobs;
	private ArrayList<Volunteer> volunteers;
	private String environmentName;
	
	public Environment(String environmentName) {
		this.environmentName = environmentName;
	}
	public void addJobs(Jobs job) {
		jobs.add(job);
	}
	public void addVolunteers(Volunteer volunteer) {
		volunteers.add(volunteer);
	}
}

