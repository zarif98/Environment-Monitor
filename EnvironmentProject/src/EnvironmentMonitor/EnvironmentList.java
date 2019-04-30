package EnvironmentMonitor;

import java.util.HashSet;

public class EnvironmentList extends ObjectList {

	private static final String ENVIRONMENTS_FILE = "SavedInfo/environments.ser";
	
	/**
	 * Constructor, calls superclass using an Environment hashset and its file.
	 */
	public EnvironmentList() {
		super(new HashSet<Environment>(), ENVIRONMENTS_FILE);
	}

}
