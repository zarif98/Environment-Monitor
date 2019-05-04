package EnvironmentMonitor;

import java.io.Serializable;
import java.util.HashSet;


public class Volunteer implements Serializable {
	private String username;
	private String password;
	private HashSet<DesiredTask> desiredTasks;
	private boolean isAdmin;
	private HashSet<Job> jobs;
	
	/**
	 * Constructor for Volunteer given only username
	 * Defaults to empty password and desiredTasks, with no admin
	 * @param username
	 */
	public Volunteer(String username) {
		this(username, "", false);
	}
	
	/**
	 * Constructor for Volunteer with all information
	 * @param username
	 * @param password
	 * @param desiredTasks
	 * @param isAdmin
	 */
	public Volunteer(String username, String password, boolean isAdmin) {
		this.username = username;
		this.password = password;
		this.desiredTasks = new HashSet<DesiredTask>();
		this.jobs = new HashSet<Job>();
		this.isAdmin = isAdmin;
	}
	
	/**
	 * Returns whether they are admin and the username
	 */
	public String toString() {
		return (isAdmin?"admin ":"user ") + username;
	}
	
	/**
	 * Add desired task to list
	 * @param desiredTask task to add
	 * @return true if it was added, false if not
	 */
	public boolean addDesiredTask(DesiredTask desiredTask) {
		return desiredTasks.add(desiredTask);
	}
	
	/**
	 * Remove desired task from list
	 * @param desiredTask task to remove
	 * @return true if it was removed, false if not
	 */
	public boolean removeDesiredTask(DesiredTask desiredTask) {
		return desiredTasks.remove(desiredTask);
	}
	
	/**
	 * Getter for username
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Setter for username
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Getter for password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter for password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter for isAdmin
	 * @return isAdmin
	 */
	public boolean isAdmin() {
		return isAdmin;
	}

	/**
	 * Setter for isAdmin
	 * @param isAdmin
	 */
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	/**
	 * Add a job to the job list
	 * @param job
	 * @return true if successful
	 */
	public boolean addJob(Job job) {
		return jobs.add(job);
	}
	
	/**
	 * Remove a job from the job list
	 * @param job
	 * @return true if successful
	 */
	public boolean removeJob(Job job) {
		return jobs.remove(job);
	}
	
	/**
	 * Getter for jobs
	 * @return jobs
	 */
	public HashSet<Job> getJobs(){
		return jobs;
	}

	public String getCurrentJobsString() {
		String jobString = "Jobs: ";
			for (Job j: jobs) {
				jobString += j.getJobName() + "(" + j.getDesiredTask() +"), ";
			}
			
			if (jobString != "Jobs: ") {
				jobString = jobString.substring(0, jobString.length()-2);
			}
			
		return jobString;
		
	}
	
}
