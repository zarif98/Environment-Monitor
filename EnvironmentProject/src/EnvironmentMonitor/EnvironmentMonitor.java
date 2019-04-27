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
		environments.addJobs(new Job("Pick Up Trash", "Clean the area near the river basin", DesiredTask.pickUpTrash));
		environments.addJobs(new Job("Rake Leaves", "Clean the area near the trees ", DesiredTask.rakeLeaves));
		environments.addJobs(new Job("Maintain Paths", "Clean the paths near the forest", DesiredTask.maintain_Paths));
	}
	public void createJobs(String jobName, String description, String skills) {
		environments.addJobs(new Job(jobName, description, DesiredTask.valueOf(skills)));
	}
	public void createAutomaticVolunteers() {
		Volunteer volunteer1 = new Volunteer("adsf");
		Volunteer volunteer2 = new Volunteer("adsf");
		environments.addVolunteers(volunteer1);
		environments.addVolunteers(volunteer2);
		volunteer1.AddDesiredTasks("Pick up Trash");
		volunteer2.AddDesiredTasks("");
		
		
	}
	public void createVolunteers(String volunteerName) {
		environments.addVolunteers(new Volunteer(volunteerName));
	}

	public void setEnvironment(ArrayList<Environment> environment) {
		this.environment = environment;
	}
	public Volunteer getVolunteer() {
		return this.volunteer;
	}
}
