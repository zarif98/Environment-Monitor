package EnvironmentMonitor;

import java.io.Serializable;
import java.util.ArrayList;

public class Job implements Serializable {
	private String name;
	private String jobDescription;
	private DesiredTask desiredTask;
	
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
	
	/**
	 * Getter for job
	 * @return
	 */
	public String getJobName() {
		return this.name;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public String getDesiredTask() {
		return desiredTask.toString();
	}
	public String toString() {
		return this.name +": " +  this.jobDescription;
	}
}
