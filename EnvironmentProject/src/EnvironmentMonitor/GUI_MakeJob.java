package EnvironmentMonitor;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;

public class GUI_MakeJob {

	private static DesiredTask dt;
	/**
	 * Code for dialog in which 
	 */

	private static Logger logger = Logger.getLogger(GUI_MakeJob.class.getName());

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

		ComboBox<DesiredTask> desiredTaskComboBox = new ComboBox();
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
			
			else if(dt.requiresCounting()) {
				showStage(environment, new Job(jobNameInput.getText(), descriptionInput.getText(), dt));
				stage.close();
			}
			
			else {
				environment.addJob(new Job(jobNameInput.getText(), descriptionInput.getText(), dt));
				GUI_Main.environments.serialize();
				stage.close();
			}
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
	
	public static void showStage(Environment environment, Job job){

		Stage newStage = new Stage();
		VBox comp = new VBox();
		Label registration = new Label("Which organism would you like for the worker to count?");
		TextField field = new TextField();
		field.setPromptText("Number of Animals");
		
		Predicate<Species> typeCheck = job.getDesiredTask().equals(DesiredTask.countPlant) ?
												(species -> species.isPlant()) :
												(species -> !species.isPlant());
		
		ComboBox<Object> combo = new ComboBox<Object>();
		if(job.getDesiredTask() == DesiredTask.countAnimal) {
			combo.setItems(FXCollections.observableArrayList(
					Arrays.asList(Species.values()).stream().filter(typeCheck).toArray()));
		}
		
		
		Button addJobs = new Button("Add Job");
		addJobs.setOnAction(e -> {
			Species species = (Species)combo.getValue();
			Organism organism = species.isPlant() ? new Plant(0, species): new Animal(0, species);
			environment.addJob(new CountingJob(job, organism));
			newStage.close();
		});
		
		comp.setAlignment(Pos.CENTER);
		addJobs.setAlignment(Pos.CENTER_RIGHT);
		registration.setMaxWidth(Double.MAX_VALUE);
		registration.setAlignment(Pos.BOTTOM_CENTER);

		StackPane.setAlignment(addJobs, Pos.CENTER_LEFT);



		comp.getChildren().addAll(registration, combo, addJobs);

		Scene stageScene = new Scene(comp,400, 100);
		newStage.setScene(stageScene);
		newStage.show();
	}

}
