package EnvironmentMonitor;

import java.io.FileNotFoundException;

public class ObjectListFileNotFound extends FileNotFoundException {
	
	String inputFile;
	
	public ObjectListFileNotFound(String type) {
		inputFile = type;
	}
	
	public String getMessage() {
		return inputFile;
	}
}
