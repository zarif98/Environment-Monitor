package EnvironmentMonitor;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

public class GUI_FindJobs implements isDialog {

	/**
	 * Code for dialog in which 
	 */
	public static void dialog() {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("");
		stage.setMinWidth(0);
		
		TableView<Environment> jobView = new TableView<Environment>(); 


		TableColumn<Environment, String> colName =
				new TableColumn<Environment, String>("Environment Name");
		colName.setMinWidth(180);
		colName.setCellValueFactory(
				new PropertyValueFactory<Environment, String>("environmentName"));
		
		TableColumn<Environment, String> findJob =
				new TableColumn<Environment, String>("Jobs");
		findJob.setMinWidth(80);
		findJob.setCellValueFactory(
				new PropertyValueFactory<Environment, String>("Jobs"));


		TableColumn<Environment, Double> colDistanceTo = 
				new TableColumn<Environment, Double>("Distance To");
		colDistanceTo.setMinWidth(80);
		colDistanceTo.setCellValueFactory(
				new PropertyValueFactory<Environment, Double>("distanceTo"));
		
		jobView.getColumns().setAll(colName, colDistanceTo, findJob);
		
		for(Object e : GUI_Main.environments.getList()){
			jobView.getItems().add((Environment) e);
		}
		//
		
		TableColumn<Job, String> colAdd = 
				new TableColumn<Job, String>("Add Jobs?");
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
								
							}
									);
							button.setText("Add");
							button.setAlignment(Pos.BASELINE_CENTER);
							button.setMaxWidth(Double.MAX_VALUE);
							setGraphic(button);
						}
					}
				};
				return cell;
			}
		};
		
		

		colAdd.setCellFactory(cellFactory);

		
		VBox pane = new VBox(20);
		pane.getChildren().addAll(jobView);
		pane.setAlignment(Pos.CENTER);
		pane.setStyle("-fx-background-color: AntiqueWhite;");
		pane.setPadding(new Insets(20,20,20,20));
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.showAndWait();
	}

}
