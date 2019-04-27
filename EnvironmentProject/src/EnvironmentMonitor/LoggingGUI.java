package EnvironmentMonitor;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoggingGUI extends Application {

	/**
	 * Start up stage and display it, is called from the StartingGUI
	 */
	public static void generate() {
		Stage stage = setStage();
		setupControls();
	}
	
	
	/**
	 * Generate elements, organize them, and show the stage
	 */
	private static void setupControls() {
		//elements
		TextField text = new TextField();
		text.setPromptText("Volunteer Name");
		
		Button yesButton = new Button("Submit");
		
		
		//VBox and stage setting
		VBox layout = new VBox(10);
		layout.getChildren().addAll(yesButton, text);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout);
		stage.setScene(scene);
		stage.showAndWait();
	}
	
	/**
	 * Create stage and set up general properties
	 * @return stage
	 */
	private static Stage setStage() {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Logging");
		stage.setWidth(1000);
		return stage;
	}
}
