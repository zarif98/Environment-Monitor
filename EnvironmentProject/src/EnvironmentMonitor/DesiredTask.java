package EnvironmentMonitor;

public enum DesiredTask {
	pickUpTrash("Pick up trash"),
    workWithAnimals("Work with animals"),
    rakeLeaves("Rake leaves"),
    maintain_Paths("Maintain paths");
	
	private final String desiredTask;
	
	/**
	 * Constructor for each item, stores string for name
	 * @param desiredTask
	 */
	DesiredTask(String desiredTask){
		this.desiredTask = desiredTask;
	}
	
<<<<<<< HEAD
	public String getDesiredTask() {
		return this.desiredTask;
	}
	
=======
	/**
	 * toString, returns desired task
	 */
>>>>>>> branch 'master' of https://github.com/zarif98/Environment-Monitor
	public String toString() {
		return this.desiredTask;
	}
}
