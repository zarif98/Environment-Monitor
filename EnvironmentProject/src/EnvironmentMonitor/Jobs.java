package EnvironmentMonitor;

import java.util.ArrayList;

public class Jobs {
	private String jobs;
	private String description;
	private DesiredTask desiredTask;
	
	public Jobs(String jobs, String description, DesiredTask desiredTask) {
		this.jobs = jobs;
		this.description = description;
	}
	public String getJobName() {
		return this.jobs;
	}
	public String getDescription() {
		return this.getDescription();
	}
	public String toString() {
		return this.jobs +" and " +  this.description;
	}
}
