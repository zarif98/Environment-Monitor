package EnvironmentMonitor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;

public class UserList  implements Serializable{
	
	private static final long serialVersionUID = 12122112221L;
	
	private static final String USERS_FILE = "SavedInfo/users.ser";
	
	private HashSet<Volunteer> volunteers;
	
	/**
	 * Constructor for UserList, creates HashSet and calls deserializeCurrentFile
	 */
	public UserList() {
		volunteers = new HashSet<Volunteer>();
		deserializeVolunteers();
	}

	/**
	 * Tries to deserialize USERS_FILE and put information into volunteers
	 */
	private void deserializeVolunteers() {
		FileInputStream fileIn = null;
		ObjectInputStream in = null;
		
		try {
			fileIn = new FileInputStream(USERS_FILE);
			in = new ObjectInputStream(fileIn);
			volunteers = ((UserList)in.readObject()).getVolunteers();
		}
		catch (ClassNotFoundException c) {
			System.out.println("Object class not found");
			c.printStackTrace();
			return;
		}
		catch (Exception e) {
			System.out.println(e.getClass().getSimpleName() + 
					": " + e.getMessage() + "\n");
		}
		finally {
			try {
				in.close();
				fileIn.close();
			}
			catch (Exception e) {
				System.out.println(e.getMessage() + "\n");
			}
		}
	}
	
	private void serializeVolunteers() {
		try {
			FileOutputStream fileOut = new FileOutputStream(USERS_FILE);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(this);
			out.close();
			fileOut.close();
		}
		catch (IOException i) {
			i.printStackTrace();
		}
	}
	
	/**
	 * Check if volunteer exists with given parameters
	 * @param username
	 * @param password
	 * @return volunteer if they exist, null otherwise
	 */
	public Volunteer getUser(String username, String password) {
		for(Volunteer volunteer: volunteers) {
			if(volunteer.getUsername().equals(username) && volunteer.getPassword().equals(password)) {
				return volunteer;
			}
		}
		return null;
	}
	
	/**
	 * Check if username is taken
	 * @param username
	 * @return true if it already exists
	 */
	public boolean usernameTaken(String username) {
		for(Volunteer volunteer: volunteers) {
			if(volunteer.getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Add volunteer to list
	 * @param volunteer
	 * @return true if successful
	 */
	public boolean addVolunteer(Volunteer volunteer) {
		if(volunteers.add(volunteer)) {
			serializeVolunteers();
			return true;
		}
		return false;
	}

	/**
	 * Remove volunteer from list
	 * @param volunteer
	 * @return true if successful
	 */
	public boolean removeVolunteer(Volunteer volunteer) {
		if(volunteers.remove(volunteer)) {
			serializeVolunteers();
			return true;
		}
		return false;
	}
	
	public HashSet<Volunteer> getVolunteers(){
		return volunteers;
	}
}
