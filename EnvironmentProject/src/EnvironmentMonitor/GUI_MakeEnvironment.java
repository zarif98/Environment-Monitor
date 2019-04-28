package EnvironmentMonitor;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class GUI_MakeEnvironment implements isDialog {

	/**
	 * Code for dialog in which 
	 */
	public static void dialog(EnvironmentList environments) {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Make New Environment");
		stage.setMinWidth(500);
		
		TextField environmentName = new TextField();
		environmentName.setPromptText("Environment Name");
		
		CheckBox landEnvironmentBox = new CheckBox("Land Environment");
		CheckBox waterEnvironmentBox = new CheckBox("Water Environment");
		Popup popup = new Popup();
		popup.setX(300);
		popup.setY(200);
		
		Button submit = new Button("Submit");
		submit.setOnAction(e ->{
			if(landEnvironmentBox.isSelected()) {
				LandEnvironment landEnvironment = new LandEnvironment(environmentName.getText());
			}
			else if(waterEnvironmentBox.isSelected()) {
				WaterEnvironment waterEnvironment = new WaterEnvironment(environmentName.getText());
			}
			else if(landEnvironmentBox.isSelected() && waterEnvironmentBox.isSelected()) {
				WaterAndLandEnvironment waterAndLandEnvironment = new WaterAndLandEnvironment(environmentName.getText());
			}
			else{
				GUI_UniversalErrorPopUp.showStage(GUI_MakeEnvironment.class);
			}
		});
		VBox pane = new VBox(20);
		pane.getChildren().addAll(environmentName, landEnvironmentBox, waterEnvironmentBox, submit);
		pane.setAlignment(Pos.CENTER);
		pane.setStyle("-fx-background-color: AntiqueWhite;");
		pane.setPadding(new Insets(20,20,20,20));
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.showAndWait();
	}
}
