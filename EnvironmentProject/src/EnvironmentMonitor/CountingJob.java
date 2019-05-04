package EnvironmentMonitor;

public class CountingJob extends Job {

	Organism organism;
	
	public CountingJob(String name, String jobDescription, DesiredTask desiredTask, Organism organism) {
		super(name, jobDescription, desiredTask);
		this.organism = organism;
	}
	
	public void submitCount(int count) {
		organism.recount(count);
	}

}
