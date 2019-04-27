package EnvironmentMonitor;

public class TestDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Volunteer volunteer = new Volunteer("Jaysson");
		volunteer.AddDesiredTasks("pickUpTrash");
		volunteer.AddDesiredTasks("workWithAnimals");
		System.out.println(volunteer);
		
	}

}
