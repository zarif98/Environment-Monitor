package EnvironmentMonitor;

import java.util.HashSet;

public class Volunteer {
	private String username;
	private String password;
	private HashSet<DesiredTask> desiredTasks;
	private boolean isAdmin;
	
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
	
}
