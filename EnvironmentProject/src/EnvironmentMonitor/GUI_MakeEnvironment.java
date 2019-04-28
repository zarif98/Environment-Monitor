package EnvironmentMonitor;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GUI_MakeEnvironment {

	/**
	 * Code for dialog in which 
	 */
	public static void dialog(UserList users) {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Make New Environment");
		stage.setMinWidth(500);
		
		TextField environmentName = new TextField();
		environmentName.setPromptText("Environment Name");
		environmentName.setPromptText("Environment Name");
		
		VBox pane = new VBox(20);
		pane.getChildren().addAll();
		pane.setAlignment(Pos.CENTER);
		pane.setStyle("-fx-background-color: AntiqueWhite;");
		pane.setPadding(new Insets(20,20,20,20));
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.showAndWait();
	}

}
