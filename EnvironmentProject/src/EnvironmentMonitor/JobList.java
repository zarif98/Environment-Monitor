package EnvironmentMonitor;

import java.util.HashSet;

public class JobList extends ObjectList {

	private static final String JOBS_FILE = "SavedInfo/jobs.ser";
	
	public JobList() {
		super(new HashSet<Job>(), JOBS_FILE);
	}
}
