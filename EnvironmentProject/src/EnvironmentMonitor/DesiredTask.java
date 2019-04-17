package EnvironmentMonitor;

public enum DesiredTask {
	pickUpTrash("Pick up trash"),
    workWithAnimals("Work with animals"),
    rakeLeaves("Rake leaves"),
    maintain_Paths("Maintain paths");
	
	private final String desiredTask;
	
	DesiredTask(String desiredTask){
		this.desiredTask = desiredTask;
	}
	public String getDesiredTask() {
		return this.desiredTask;
	}
	public String toString() {
		return this.desiredTask;
	}
}
