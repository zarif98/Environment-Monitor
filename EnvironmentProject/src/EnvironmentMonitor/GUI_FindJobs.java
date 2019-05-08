package EnvironmentMonitor;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

public class GUI_FindJobs implements IsDialog {

	/**
	 * Code for dialog in which jobs are listed in a tableview
	 */
	
	static Label jobsLabel = new Label();
	public static void dialog(Volunteer volunteer) {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("");
		stage.setMinWidth(0);
		stage.setWidth(500);
		
		
		
		jobsLabel.setText(volunteer.getCurrentJobsString());
		TableView<Environment> jobView = new TableView<Environment>(); 


		TableColumn<Environment, String> colName =
				new TableColumn<Environment, String>("Environment Name");
		colName.setMinWidth(180);
		colName.setCellValueFactory(
				new PropertyValueFactory<Environment, String>("environmentName"));
		
		TableColumn<Environment, String> numJobs =
				new TableColumn<Environment, String>("Jobs Available");
		numJobs.setMinWidth(80);
		numJobs.setCellValueFactory(
				new PropertyValueFactory<Environment, String>("JobNum"));


		TableColumn<Environment, Double> colDistanceTo = 
				new TableColumn<Environment, Double>("Distance To");
		colDistanceTo.setMinWidth(80);
		colDistanceTo.setCellValueFactory(
				new PropertyValueFactory<Environment, Double>("distanceTo"));
		
		TableColumn<Environment, String> colJobs = 
				new TableColumn<Environment, String>("View Jobs!");
		Callback<TableColumn<Environment, String>, TableCell<Environment, String>> cellFactoryJobs = new Callback<TableColumn<Environment, String>, TableCell<Environment, String>>() {
			public TableCell<Environment, String> call(TableColumn<Environment, String> param) {
				final TableCell<Environment, String> cell = new TableCell<Environment, String>() {
					private final Button button = new Button();

					public void updateItem(String crn, boolean empty) {
						if(empty) {
							setGraphic(null);
						} else {
							Environment currentEnvironment = getTableView().getItems().get(getIndex());
							GUI_Main.environments.getList().forEach(env -> {
								if(env.equals(currentEnvironment)) {
									button.setOnAction(e -> GUI_JobView.dialog((Environment) env, volunteer));
									jobsLabel.setText(volunteer.getCurrentJobsString());
								}
							});
						
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

		colJobs.setCellFactory(cellFactoryJobs);
		
		
		jobView.getColumns().setAll(colName, colDistanceTo, numJobs, colJobs);
		GUI_Main.environments.getList().forEach(e ->{
			jobView.getItems().add((Environment) e);
		});
		

		
		VBox pane = new VBox(20);
		pane.getChildren().addAll(jobView, jobsLabel);
		pane.setAlignment(Pos.CENTER);
		pane.setStyle("-fx-background-color: AntiqueWhite;");
		pane.setPadding(new Insets(20,20,20,20));
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.showAndWait();
	}

}
