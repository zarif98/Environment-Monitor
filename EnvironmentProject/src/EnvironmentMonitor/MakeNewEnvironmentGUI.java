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

public class MakeNewEnvironmentGUI extends Application {

	/**
	 * Start up stage and display it, is called from the StartingGUI
	 */
	public static void generate() {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Make a new Environment");
		stage.setWidth(1000);
		
		TextField text = new TextField();
		text.setPromptText("Environment Name");
		
		Button yesButton = new Button("Submit");
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(yesButton, text);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout);
		stage.setScene(scene);
		stage.showAndWait();
		
	}
}
