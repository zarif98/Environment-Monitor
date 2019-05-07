package EnvironmentMonitor;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

public class GUI_EnvironmentAddView implements IsDialog{

	static TableView<Environment> envView = new TableView<Environment>(); 

	/**
	 * Generates dialog containing tableview for environments add/drop
	 */
	private static Logger logger = Logger.getLogger(GUI_EnvironmentAddView.class.getName());
	public static void dialog() {
		logger.setLevel(GUI_Main.loggingLevel);
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
							GUI_Main.environments.getList().forEach(env ->{
								if(env.equals(currentEnvironment)) {
									button.setOnAction(e -> GUI_JobAddView.dialog((Environment) env));
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

		Label label = new Label("Would you like to add an additional environment? Click here!");
		Button newenvironment = new Button("Add Environment");
		newenvironment.setOnAction(e -> {
			GUI_MakeEnvironment.dialog(GUI_Main.environments);
			logger.log(Level.INFO, "New Environment added to list");
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
		comp.setAlignment(Pos.CENTER);
		comp.setPadding(new Insets(20,20,20,20));

		removeJobs.setOnAction(e-> {
			GUI_Main.environments.remove(environment);
			envView.getItems().clear();
			logger.log(Level.INFO, "Environment removed from list");
			for(Object env: GUI_Main.environments.getList()) {
				envView.getItems().add((Environment) env);
			}
		});


		comp.getChildren().addAll(registration, removeJobs);

		Scene stageScene = new Scene(comp,400, 100);
		newStage.setScene(stageScene);
		newStage.setTitle("Removal Confirmation");
		newStage.show();
	}
}
