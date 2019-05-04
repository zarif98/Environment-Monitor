package EnvironmentMonitor;

import javafx.stage.Stage;

public interface IsDialog {
	
	default void close(Stage stage) {
		stage.close();
	}
}
