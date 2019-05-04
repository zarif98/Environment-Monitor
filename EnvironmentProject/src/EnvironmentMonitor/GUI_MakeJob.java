package EnvironmentMonitor;

import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GUI_MakeJob {

	private static DesiredTask dt;
	/**
	 * Code for dialog in which 
	 */
	public static void dialog(Environment environment) {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Make New Job");
		stage.setMinWidth(500);


		TextField jobNameInput = new TextField();
		jobNameInput.setPromptText("Job name");


		TextField descriptionInput = new TextField();
		descriptionInput.setPromptText("Job description");

		Label nameLabel = new Label("What would you like to call this job?");
		nameLabel.setMaxWidth(Double.MAX_VALUE);
		nameLabel.setAlignment(Pos.CENTER_LEFT);

		Label descriptionLabel = new Label("Please provide a description of this job.");
		descriptionLabel.setMaxWidth(Double.MAX_VALUE);
		descriptionLabel.setAlignment(Pos.CENTER_LEFT);

		ComboBox desiredTaskComboBox = new ComboBox();
		ObservableList<DesiredTask> desiredTaskObservableList = FXCollections.observableArrayList(Arrays.asList(DesiredTask.values()));
		desiredTaskComboBox.setItems(desiredTaskObservableList);


		desiredTaskComboBox.setOnAction(e -> {
			dt = (DesiredTask) desiredTaskComboBox.getValue();
		});


		Button submitButton = new Button();
		submitButton.setText("Submit");
		submitButton.setOnMouseClicked(e -> {
			if(dt == null || jobNameInput.getText().isEmpty()|| descriptionInput.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING, "Please enter information for all fields!");
				alert.setTitle("Not Enough Information");
				alert.setHeaderText("Job Creation Error");
				alert.showAndWait();
			}
			else {
				environment.addJob(new Job(jobNameInput.getText(), descriptionInput.getText(), dt));
				GUI_Main.environments.serialize();
				stage.close();
			}
		});

		Button add = new Button("Add");
		add.setOnAction(e->{
			GUI_MakeJob.dialog(environment);
		});


		VBox pane = new VBox(20);
		pane.getChildren().addAll(nameLabel, jobNameInput, descriptionLabel, descriptionInput, desiredTaskComboBox, submitButton);
		pane.setAlignment(Pos.CENTER);
		pane.setStyle("-fx-background-color: AntiqueWhite;");
		pane.setPadding(new Insets(20,20,20,20));

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.showAndWait();
	}

}
