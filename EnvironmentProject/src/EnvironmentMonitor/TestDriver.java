package EnvironmentMonitor;

public class TestDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Volunteer volunteer = new Volunteer("Jaysson");
//		volunteer.AddDesiredTasks("pickUpTrash");
//		volunteer.AddDesiredTasks("workWithAnimals");
//		System.out.println(volunteer);
		
		LandEnvironment environment = new LandEnvironment("sdaf", 40.34, -74.65904);
		System.out.println(environment.distanceTo());
		
	}

}
