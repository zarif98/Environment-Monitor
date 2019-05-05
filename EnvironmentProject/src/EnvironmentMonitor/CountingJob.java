package EnvironmentMonitor;

public class CountingJob extends Job {

	Organism organism;
	
	/**
	 * Constructor for countingJob class, adds organism to superclass
	 * @param name
	 * @param jobDescription
	 * @param desiredTask
	 * @param organism
	 */
	public CountingJob(String name, String jobDescription, DesiredTask desiredTask, Organism organism) {
		super(name, jobDescription, desiredTask);
		this.organism = organism;
	}
	
	/**
	 * Calls organism's recount method
	 * @param count
	 */
	public void submitCount(int count) {
		organism.recount(count);
	}

}
