package EnvironmentMonitor;

import java.util.ArrayList;
import java.time.LocalDate;

public abstract class Environment {
	private ArrayList<Guide> guides;
	private ArrayList<Organism> organisms;
	private LocalDate lastCleanedDate;
	private ArrayList<Jobs> jobs;
	
	public Environment() {
		
	}
	public void addJobs(Jobs job) {
		jobs.add(job);
	}
}

