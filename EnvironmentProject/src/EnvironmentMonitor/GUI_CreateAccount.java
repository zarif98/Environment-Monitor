package EnvironmentMonitor;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GUI_CreateAccount implements IsDialog {
	
	/**
	 * Code for dialog in which a new account is created
	 */
	public static void dialog(UserList users) {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Create Account");
		stage.setMinWidth(250);
		
		TextField usernameInput = new TextField();
		usernameInput.setPromptText("username");
		
		TextField passwordInput = new TextField();
		passwordInput.setPromptText("password");
		
		CheckBox isAdmin = new CheckBox();
		isAdmin.setText("Admin?");
		
		Button submitButton = new Button();
		submitButton.setText("Submit");
		submitButton.setOnMouseClicked(e -> {
			if(users.usernameTaken(usernameInput.getText())){
				System.err.println("Username taken");
			}
			else {
				users.add(new Volunteer(usernameInput.getText(), passwordInput.getText(), isAdmin.isSelected()));
				stage.close();
			}
		});
		
		VBox pane = new VBox(20);
		pane.getChildren().addAll(usernameInput, passwordInput, isAdmin, submitButton);
		pane.setAlignment(Pos.CENTER);
		pane.setStyle("-fx-background-color: AntiqueWhite;");
		pane.setPadding(new Insets(20,20,20,20));
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.showAndWait();
	}
}
