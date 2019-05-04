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

public class GUI_EnvironmentAddView implements isDialog{
	static TableView<Environment> envView = new TableView<Environment>(); 
	public static void dialog() {
		envView.getItems().clear();
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Make New Job");
		stage.setMinWidth(620);


		TableColumn<Environment, String> colName =
				new TableColumn<Environment, String>("Environment Name");
		colName.setMinWidth(100);
		colName.setCellValueFactory(
				new PropertyValueFactory<Environment, String>("environmentName"));
		
		TableColumn<Environment, String> colLong =
				new TableColumn<Environment, String>("Longitude");
		colLong.setMinWidth(80);
		colLong.setCellValueFactory(
				new PropertyValueFactory<Environment, String>("longitude"));
		
		TableColumn<Environment, String> colLat =
				new TableColumn<Environment, String>("Latitude");
		colLat.setMinWidth(80);
		colLat.setCellValueFactory(
				new PropertyValueFactory<Environment, String>("latitude"));


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
							for(Object env : GUI_Main.environments.getList()) {
								if (env.equals(currentEnvironment)) {
									button.setOnAction( e-> GUI_JobView.dialog((Environment) env));
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

		colJobs.setCellFactory(cellFactoryJobs);
		
		Label label = new Label("Can't find your registered environment you're looking for? Make one!");
		Button newenvironment = new Button("Add Environment");
		newenvironment.setOnAction(e -> {
			GUI_MakeEnvironment.dialog(GUI_Main.environments);
			envView.getItems().clear();
			for(Object env : GUI_Main.environments.getList()){
				envView.getItems().add((Environment) env);
			}
		});
		
		TableColumn<Environment, String> colRemove = 
				new TableColumn<Environment, String>("Remove Environments");
		Callback<TableColumn<Environment, String>, TableCell<Environment, String>> cellFactory = new Callback<TableColumn<Environment, String>, TableCell<Environment, String>>() {
			public TableCell<Environment, String> call(TableColumn<Environment, String> param) {
				final TableCell<Environment, String> cell = new TableCell<Environment, String>() {
					private final Button button = new Button();

					public void updateItem(String crn, boolean empty) {
						if(empty) {
							setGraphic(null);
						} else {
							Environment currentEnvironment = getTableView().getItems().get(getIndex());
							button.setOnAction( e-> {
								showStage(currentEnvironment);
								
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




		envView.getColumns().setAll(colName, colLong, colLat, colDistanceTo, colJobs, colRemove);

		for(Object e : GUI_Main.environments.getList()){
			envView.getItems().add((Environment) e);
		}

		VBox pane = new VBox(20);
		pane.getChildren().addAll(envView, label, newenvironment);
		pane.setAlignment(Pos.CENTER);
		pane.setStyle("-fx-background-color: AntiqueWhite;");
		pane.setPadding(new Insets(20,20,20,20));

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.showAndWait();
	}
	
	public static void showStage(Environment environment){

		Stage newStage = new Stage();
		VBox comp = new VBox();
		Label registration = new Label("Are you sure you would like to remove this environment?");
		Button removeJobs = new Button("Remove");
		removeJobs.setAlignment(Pos.CENTER);
		registration.setMaxWidth(Double.MAX_VALUE);
		registration.setAlignment(Pos.BOTTOM_CENTER);

		StackPane.setAlignment(removeJobs, Pos.CENTER);

		removeJobs.setOnAction(e-> {
			GUI_Main.environments.remove(environment);
			envView.getItems().clear();
			for(Object env: GUI_Main.environments.getList()) {
				envView.getItems().add((Environment) env);
			}
		});


		comp.getChildren().addAll(registration, removeJobs);

		Scene stageScene = new Scene(comp,400, 100);
		newStage.setScene(stageScene);
		newStage.show();
	}
}
