package EnvironmentMonitor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;


public class UserList extends ObjectList{
	
	private static final String USERS_FILE = "SavedInfo/users.ser";
	
	/**
	 * Constructor for UserList, creates HashSet passes the Users file
	 */
	public UserList() {
		super(new HashSet<Volunteer>(), USERS_FILE);
	}

	/**
	 * Check if volunteer exists with given parameters
	 * @param username
	 * @param password
	 * @return volunteer if they exist, null otherwise
	 */
	public Volunteer getUser(String username, String password) {
		for(Object volunteer: set) {
			if(((Volunteer)volunteer).getUsername().equals(username) && ((Volunteer)volunteer).getPassword().equals(password)) {
				return (Volunteer)volunteer;
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
		for(Object volunteer: set) {
			if(((Volunteer)volunteer).getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}
}
