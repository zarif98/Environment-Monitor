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
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

public class GUI_JobView implements isDialog{
	/**
	 * Code for dialog in which 
	 */
	public static void dialog(Environment environment) {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Showing all jobs for selected Job");
		stage.setMinWidth(700);

		TableView<Job> jobView = new TableView<Job>(); 


		TableColumn<Job, String> colName =
				new TableColumn<Job, String>("Job Name");
		colName.setMinWidth(180);
		colName.setCellValueFactory(
				new PropertyValueFactory<Job, String>("jobName"));
		
		TableColumn<Job, String> colDesc =
				new TableColumn<Job, String>("Job Description");
		colDesc.setMinWidth(400);
		colDesc.setCellValueFactory(
				new PropertyValueFactory<Job, String>("jobDescription"));

		TableColumn<Job, String> colTask =
				new TableColumn<Job, String>("Desired Task");
		colTask.setMinWidth(80);
		colTask.setCellValueFactory(
				new PropertyValueFactory<Job, String>("desiredTask"));



		jobView.getColumns().setAll(colName, colDesc, colTask);

		for(Job j: environment.getJobs()) {
			jobView.getItems().add(j);
		}

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
