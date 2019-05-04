package EnvironmentMonitor;

import java.util.Arrays;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

public class GUI_JobView implements IsDialog{
	/**
	 * Code for dialog in which 
	 */
	static TableView<Job> jobView = new TableView<Job>();
	
	
	public static void dialog(Environment environment) {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Showing all jobs for selected Job");
		stage.setMinWidth(700);


		jobView.getItems().clear();
		
		TableColumn<Job, String> colName =
				new TableColumn<Job, String>("Job Name");
		colName.setMinWidth(180);
		colName.setCellValueFactory(
				new PropertyValueFactory<Job, String>("jobName"));
		
		TableColumn<Job, String> colDesc =
				new TableColumn<Job, String>("Job Description");
		colDesc.setMinWidth(200);
		colDesc.setCellValueFactory(
				new PropertyValueFactory<Job, String>("jobDescription"));

		TableColumn<Job, String> colTask =
				new TableColumn<Job, String>("Desired Task");
		colTask.setMinWidth(80);
		colTask.setCellValueFactory(
				new PropertyValueFactory<Job, String>("desiredTask"));
		
		TableColumn<Job, String> colRemove = 
				new TableColumn<Job, String>("Remove jobs?");
		Callback<TableColumn<Job, String>, TableCell<Job, String>> cellFactory = new Callback<TableColumn<Job, String>, TableCell<Job, String>>() {
			public TableCell<Job, String> call(TableColumn<Job, String> param) {
				final TableCell<Job, String> cell = new TableCell<Job, String>() {
					private final Button button = new Button();

					public void updateItem(String crn, boolean empty) {
						if(empty) {
							setGraphic(null);
						} else {
							Job currentJob = getTableView().getItems().get(getIndex());
							button.setOnAction( e-> {
								showStage(currentJob, environment);	
							}
									);
							button.setText("Remove");
							button.setAlignment(Pos.BASELINE_CENTER);
							button.setMaxWidth(Double.MAX_VALUE);
							setGraphic(button);
						}
					}
				};
				return cell;
			}
		};
		
		

		colRemove.setCellFactory(cellFactory);
		
		
		
		TableColumn<Environment, String> colGetThisJob = 
				new TableColumn<Environment, String>("Get this job");
		Callback<TableColumn<Environment, String>, TableCell<Environment, String>> cellFactoryGetJobs = new Callback<TableColumn<Environment, String>, TableCell<Environment, String>>() {
			public TableCell<Environment, String> call(TableColumn<Environment, String> param) {
				final TableCell<Environment, String> cell = new TableCell<Environment, String>() {
					private final Button button = new Button();

					public void updateItem(String crn, boolean empty) {
						if(empty) {
							setGraphic(null);
						} else {
							Environment currentEnvironment = getTableView().getItems().get(getIndex());
							for(Object env : GUI_Main.environments.getList()) {
								if (env.equals(currentEnvironment)) {
									
								}
							}
						
							button.setText("View");
							button.setAlignment(Pos.BASELINE_CENTER);
							button.setMaxWidth(Double.MAX_VALUE);
							setGraphic(button);
						}
					}
				};
				return cell;
			}
		};
		
		colGetThisJob.setCellFactory(cellFactoryGetJobs);



		jobView.getColumns().setAll(colName, colDesc, colTask, colRemove);

		for(Job j: environment.getJobs()) {
			jobView.getItems().add(j);
		}
		Label job = new Label("Want to add a job? Add it!");
		
		Button add = new Button("Add");
		add.setOnAction(e->{
			GUI_MakeJob.dialog(environment);
		});
		
		Button addJobs = new Button("Remove");

		VBox pane = new VBox(20);
		pane.getChildren().addAll(jobView,job, add);
		pane.setAlignment(Pos.CENTER);
		pane.setStyle("-fx-background-color: AntiqueWhite;");
		pane.setPadding(new Insets(20,20,20,20));

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.showAndWait();
	}
	public static void showStage(Job job, Environment environment){

		Stage newStage = new Stage();
		VBox comp = new VBox();
		Label registration = new Label("Are you sure you would like to remove this job?");
		Button addJobs = new Button("Remove");
		addJobs.setAlignment(Pos.CENTER_RIGHT);
		registration.setMaxWidth(Double.MAX_VALUE);
		registration.setAlignment(Pos.BOTTOM_CENTER);

		StackPane.setAlignment(addJobs, Pos.CENTER_LEFT);

		addJobs.setOnAction(e-> {
			environment.removeJob(job);
			jobView.getItems().clear();
			for(Job j: environment.getJobs()) {
				jobView.getItems().add(j);
			}
		});


		comp.getChildren().addAll(registration, addJobs);

		Scene stageScene = new Scene(comp,400, 100);
		newStage.setScene(stageScene);
		newStage.show();
	}
}
