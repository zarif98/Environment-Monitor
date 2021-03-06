package EnvironmentMonitor;

import java.io.Serializable;
import java.util.ArrayList;

public class Job implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3701713934753996265L;
	private String name;
	private String jobDescription;
	private DesiredTask desiredTask;
	private Organism organism;
	
	/**
	 * Constructor for Job
	 * @param jobs
	 * @param description
	 * @param desiredTask
	 */
	public Job(String name, String jobDescription, DesiredTask desiredTask) {
		this.name = name;
		this.jobDescription = jobDescription;
		this.desiredTask = desiredTask;
	}
	
	public Job(String name, String jobDescription, DesiredTask desiredTask, Organism organism) {
		this.name = name;
		this.jobDescription = jobDescription;
		this.desiredTask = desiredTask;
	}
	
	/**
	 * Getter for job
	 * @return job
	 */
	public String getJobName() {
		return this.name;
	}
	
	/**
	 * Getter for description
	 * @return jobDescription
	 */
	public String getJobDescription() {
		return jobDescription;
	}
	
	/**
	 * Getter for desired task
	 * @return desiredTask
	 */
	public DesiredTask getDesiredTask() {
		return desiredTask;
	}

	
	/**
	 * Getter for description
	 * @return description
	 */
	public String getDescription() {
		return jobDescription;
	}
	
	/**
	 * Generates string for the object
	 * @return name: description
	 */
	public String toString() {
		return this.name +": " +  this.jobDescription;
	}
}
