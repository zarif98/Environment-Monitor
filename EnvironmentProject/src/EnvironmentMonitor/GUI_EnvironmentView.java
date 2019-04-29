package EnvironmentMonitor;

import java.util.Arrays;

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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

public class GUI_EnvironmentView implements isDialog{
	/**
	 * Code for dialog in which 
	 */
	public static void dialog(JobList jobs) {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Make New Environment");
		stage.setMinWidth(500);
				
		TableView<Environment> EnvironmentView = new TableView<Environment>(); 

		TableColumn<Environment, String> colName =
				new TableColumn<Environment, String>("Environment Name");
		colName.setMinWidth(180);
		colName.setCellValueFactory(
				new PropertyValueFactory<Environment, String>("environmentName"));
		
		
		TableColumn<Environment, Double> colDistanceTo = 
				new TableColumn<Environment, Double>("Distance To");
		colDistanceTo.setMinWidth(80);
		colDistanceTo.setCellValueFactory(
				new PropertyValueFactory<Environment, Double>("distanceTo"));
		/*
		Callback<TableColumn<Environment, Integer>, TableCell<Environment, Integer>> cellFactory = new Callback<TableColumn<Environment, Integer>, TableCell<Environment, Integer>>() {
			public TableCell<Environment, Integer> call(TableColumn<Environment, Integer> param) {
				final TableCell<Environment, Integer> cell = new TableCell<Environment, Integer>() {
					private final Button button = new Button();

					public void updateItem(Integer crn, boolean empty) {
						if(empty) {
							setGraphic(null);
						} else {
							Environment currentEnvironment = getTableView().getItems().get(getIndex());
							button.setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent event) {
										if(student.getCurrentEnvironments().containsKey(currentEnvironment.getCRN())) {
											student.drop(currentEnvironment);
										}
										
										else if((currentEnvironment instanceof OnlineConnectible) && ((OnlineConnectible)currentEnvironment).validateChoice()) {
											student.add(currentEnvironment);
										}
										else {
											student.add(currentEnvironment);
										}
									label.setText(student.getCurrentEnvironmentsString());
								}
							});
							button.setText(currentEnvironment.getCRN().toString());
							setGraphic(button);
						}
					}
				};
				return cell;
			}
		};
		
		colCRN.setCellFactory(cellFactory);
		*/
		



		EnvironmentView.getColumns().setAll(colName, colDistanceTo);
		
		for(Object e : GUI_Main.environments.getList()){
			EnvironmentView.getItems().add((Environment) e);
		}
		
		VBox pane = new VBox(20);
		pane.getChildren().addAll(EnvironmentView);
		pane.setAlignment(Pos.CENTER);
		pane.setStyle("-fx-background-color: AntiqueWhite;");
		pane.setPadding(new Insets(20,20,20,20));
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.showAndWait();
	}
}
