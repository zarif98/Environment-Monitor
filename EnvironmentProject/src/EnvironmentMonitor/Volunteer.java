package EnvironmentMonitor;

import java.util.ArrayList;

public class Volunteer {
	private String userName;
	private ArrayList<DesiredTask> desiredTasks;
	
	public Volunteer(String userName) {
		this.userName = userName;
		this.desiredTasks = new ArrayList<>();
	}
	public ArrayList<DesiredTask> getDesiredTask() {
		return desiredTasks;
	}
	public String toString() {
		return userName +" " + desiredTasks.toString();
	}
	public void AddDesiredTasks(String desiredTask) {
		desiredTasks.add(DesiredTask.valueOf(desiredTask));
	}
	
}
