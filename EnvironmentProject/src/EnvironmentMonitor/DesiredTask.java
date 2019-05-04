package EnvironmentMonitor;

public enum DesiredTask {
	pickUpTrash("Pick up trash"),
    workWithAnimals("Work with animals"),
    rakeLeaves("Rake leaves"),
    maintain_Paths("Maintain paths"),
	countAnimal("Count animal"),
	countPlant("Count plant");
	
	private final String desiredTask;
	
	/**
	 * Constructor for each item, stores string for name
	 * @param desiredTask
	 */
	DesiredTask(String desiredTask){
		this.desiredTask = desiredTask;
	}
	

	public String getDesiredTask() {
		return this.desiredTask;
	}
	
	/**
	 * toString, returns desired task
	 */
	public String toString() {
		return this.desiredTask;
	}
}
