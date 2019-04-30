package EnvironmentMonitor;

import java.util.HashSet;

public class JobList extends ObjectList {

	private static final String JOBS_FILE = "SavedInfo/jobs.ser";
	
	/**
	 * Constructor, calls superclass using Job arrayList & file
	 */
	public JobList() {
		super(new HashSet<Job>(), JOBS_FILE);
	}
}
