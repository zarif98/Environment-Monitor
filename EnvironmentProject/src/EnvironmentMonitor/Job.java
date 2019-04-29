package EnvironmentMonitor;

import java.io.Serializable;
import java.util.ArrayList;

public class Job implements Serializable {
	private String name;
	private String description;
	private DesiredTask desiredTask;
	
	/**
	 * Constructor for Job
	 * @param jobs
	 * @param description
	 * @param desiredTask
	 */
	public Job(String name, String description, DesiredTask desiredTask) {
		this.name = name;
		this.description = description;
		this.desiredTask = desiredTask;
	}
	
	/**
	 * Getter for job
	 * @return
	 */
	public String getJobName() {
		return this.name;
	}
	public String getDescription() {
		return this.getDescription();
	}
	public String toString() {
		return this.name +": " +  this.description;
	}
}
