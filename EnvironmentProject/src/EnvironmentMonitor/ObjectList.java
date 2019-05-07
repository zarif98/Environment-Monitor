package EnvironmentMonitor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;

public abstract class ObjectList {

	private final String STORAGE_FILE;
	
	protected HashSet set;
	
	public ObjectList(HashSet set, String file) {
		this.set = set;
		STORAGE_FILE = file;
		gatherFromFile();
	}
	
	public void gatherFromFile() {
		FileInputStream fileIn = null;
		ObjectInputStream in = null;
		
		try {
			fileIn = new FileInputStream(STORAGE_FILE);
			in = new ObjectInputStream(fileIn);
			set = (HashSet)in.readObject();
			System.out.println("Retreived Data");
		}
		catch (ClassNotFoundException c) {
			System.out.println("Object class not found");
			c.printStackTrace();
			return;
		}
		catch (FileNotFoundException e) {
			try {
				throw new ObjectListFileNotFound(STORAGE_FILE);
			} catch (ObjectListFileNotFound e1) {
				System.out.println(e.getMessage());
			}
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
	
	public void serialize() {
		try {
			FileOutputStream fileOut = new FileOutputStream(STORAGE_FILE);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(set);
			out.close();
			fileOut.close();
			System.out.println("Serializing classes");
		}
		catch (IOException i) {
			i.printStackTrace();
		}
	}
	
	public boolean add(Object object) {
		if(set.add(object)) {
			serialize();
			return true;
		}
		return false;
	}
	
	public boolean remove(Object object) {
		if(set.remove(object)) {
			serialize();
			return true;
		}
		return false;
	}
	
	public HashSet<Object> getList(){
		return set;
	}

}
