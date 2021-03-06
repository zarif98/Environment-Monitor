package EnvironmentMonitor;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class GUI_MakeEnvironment implements IsDialog {

	/**
	 * Code for dialog in which 
	 */
	
	public static void dialog(EnvironmentList environments) {
		Logger logger =
				Logger.getLogger(GUI_MakeEnvironment.class.getName());
		logger.setLevel(GUI_Main.loggingLevel);
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Make New Environment");
		stage.setMinWidth(400);
		
		
		//Textfield stuff
		TextField environmentName = new TextField();
		environmentName.setPromptText("Environment Name");
		TextField longitude = new TextField();
		longitude.setPromptText("Longitude");
		TextField latitude = new TextField();
		latitude.setPromptText("Latitude");
		
		Label name = new Label("What do you want to name your Environment?");
		name.setMaxWidth(Double.MAX_VALUE);
		name.setAlignment(Pos.CENTER_LEFT);
		Label location = new Label("Your location in longitudinal and latitudinal values:");
		location.setMaxWidth(Double.MAX_VALUE);
		location.setAlignment(Pos.CENTER_LEFT);
		
		CheckBox landEnvironmentBox = new CheckBox("Land Environment");
		CheckBox waterEnvironmentBox = new CheckBox("Water Environment");
		
		//Universal popup message
		Popup popup = new Popup();
		popup.setX(300);
		popup.setY(200);
		
		Button submit = new Button("Submit");
		//
		submit.setOnAction(e -> {
			if(landEnvironmentBox.isSelected() && waterEnvironmentBox.isSelected()) {
				WaterAndLandEnvironment waterAndLandEnvironment = new WaterAndLandEnvironment
						(environmentName.getText(), Double.parseDouble(latitude.getText())
								, Double.parseDouble(longitude.getText()));
				environments.add(waterAndLandEnvironment);
				logger.log(Level.WARNING, "New Land and Water Environment Created");
				showStage(waterAndLandEnvironment);
				stage.close();
			}
			
			else if(waterEnvironmentBox.isSelected()) {
				WaterEnvironment waterEnvironment = new WaterEnvironment
						(environmentName.getText(), Double.parseDouble(latitude.getText())
								, Double.parseDouble(longitude.getText()));
				environments.add(waterEnvironment);
				logger.log(Level.WARNING, "New Water Environment Created");
				showStage(waterEnvironment);
				stage.close();
			}
			//
			
			else if(landEnvironmentBox.isSelected()) {
				LandEnvironment landEnvironment = new LandEnvironment
						(environmentName.getText(), Double.parseDouble(latitude.getText())
								, Double.parseDouble(longitude.getText()));
				environments.add(landEnvironment);
				logger.log(Level.WARNING, "New Land Environment Created");
				showStage(landEnvironment);
				stage.close();
			}
			
			
			else{
				Alert alert = new Alert(AlertType.WARNING);
				logger.log(Level.SEVERE, "Environment Creation Error");
				alert.setTitle("Environment Creation Error");
				alert.setHeaderText("Please check off one of the check boxes");
				alert.showAndWait();
			}
		});
		
		
		VBox pane = new VBox(20);
		pane.getChildren().addAll(name, environmentName,location, longitude, latitude, landEnvironmentBox, waterEnvironmentBox, submit);
		pane.setAlignment(Pos.CENTER);
		pane.setStyle("-fx-background-color: transparent;");
		pane.setPadding(new Insets(20,20,20,20));
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.showAndWait();
	}
	public static void showStage(Environment env){

		Stage newStage = new Stage();
		VBox comp = new VBox();
		Label registration = new Label("Would you like to add Jobs to your registered environment?");
		Button addJobs = new Button("Add Jobs");
		Button close = new Button("No");
		close.setOnAction(e -> {
			newStage.close();
		});
		comp.setAlignment(Pos.CENTER);
		addJobs.setAlignment(Pos.CENTER_RIGHT);
		registration.setMaxWidth(Double.MAX_VALUE);
		registration.setAlignment(Pos.BOTTOM_CENTER);

		StackPane.setAlignment(addJobs, Pos.CENTER_LEFT);

		addJobs.setOnAction(e-> {
			GUI_MakeJob.dialog(env);
			newStage.close();
		});


		comp.getChildren().addAll(registration, addJobs, close);

		Scene stageScene = new Scene(comp,400, 100);
		newStage.setScene(stageScene);
		newStage.show();
	}
}
