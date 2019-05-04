package EnvironmentMonitor;

public enum DesiredTask {
	pickUpTrash("Pick up trash", false),
    workWithAnimals("Work with animals", false),
    rakeLeaves("Rake leaves", false),
    maintain_Paths("Maintain paths", false),
	countAnimal("Count animal", true),
	countPlant("Count plant", true);
	
	private final String desiredTask;
	private boolean requiresCounting;
	
	/**
	 * Constructor for each item, stores string for name
	 * @param desiredTask
	 */
	DesiredTask(String desiredTask, boolean hasCounting){
		this.desiredTask = desiredTask;
		requiresCounting = hasCounting;
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
