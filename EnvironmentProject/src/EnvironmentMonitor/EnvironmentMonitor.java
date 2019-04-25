package EnvironmentMonitor;

import java.util.ArrayList;

public class EnvironmentMonitor {
	private ArrayList<Environment> environment;
	private Volunteer volunteer;
	private Environment environments;
	
	public EnvironmentMonitor() {
		environment = new ArrayList<>();
	}

	public ArrayList<Environment> getEnvironment() {
		return environment;
	}
	public void createJobs() {
	}

	public void setEnvironment(ArrayList<Environment> environment) {
		this.environment = environment;
	}
	public Volunteer getVolunteer() {
		return this.volunteer;
	}
	public String getJobs() {
		return "";
	}
	
	

}
