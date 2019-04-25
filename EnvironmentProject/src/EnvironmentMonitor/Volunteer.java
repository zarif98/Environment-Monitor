package EnvironmentMonitor;

import java.util.ArrayList;

public class Volunteer {
	private ArrayList<DesiredTask> desiredTask;
	private String userName;
	
	public Volunteer(String userName, ArrayList<DesiredTask> desiredTask) {
		this.userName = userName;
		desiredTask = new ArrayList<DesiredTask>();
	}
	public ArrayList<DesiredTask> getDesiredTask() {
		return this.desiredTask;
	}
	public String toString() {
		return userName;
	}
}
