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
	public void createAutomaticJobs() {
		environments.addJobs(new Jobs("Pick Up Trash", "Clean the area near the river basin", DesiredTask.pickUpTrash));
		environments.addJobs(new Jobs("Rake Leaves", "Clean the area near the trees ", DesiredTask.rakeLeaves));
		environments.addJobs(new Jobs("Maintain Paths", "Clean the paths near the forest", DesiredTask.maintain_Paths));
	}
	public void createJobs(String jobName, String description, String skills) {
		environments.addJobs(new Jobs(jobName, description, DesiredTask.valueOf(skills)));
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
