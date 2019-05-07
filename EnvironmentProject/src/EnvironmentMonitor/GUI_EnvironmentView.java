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

public class GUI_EnvironmentView implements IsDialog{
	/**
	 * Code for dialog in which shows environments
	 */
	private static Logger logger = Logger.getLogger(GUI_EnvironmentView.class.getName());
	public static void dialog() {
		logger.setLevel(GUI_Main.loggingLevel);
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Make New Job");
		stage.setMinWidth(700);

		TableView<Environment> EnvironmentView = new TableView<Environment>(); 


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
									button.setOnAction( e-> GUI_JobAddView.dialog((Environment) env));
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
			EnvironmentView.getItems().clear();
			for(Object env : GUI_Main.environments.getList()){
				EnvironmentView.getItems().add((Environment) env);
			}
		});


		EnvironmentView.getColumns().setAll(colName, colLong, colLat, colDistanceTo, colJobs);


		for(Object e : GUI_Main.environments.getList()){
			EnvironmentView.getItems().add((Environment) e);
		}

		VBox pane = new VBox(20);
		pane.getChildren().addAll(EnvironmentView, label, newenvironment);
		pane.setAlignment(Pos.CENTER);
		pane.setStyle("-fx-background-color: #A1B56C;");
		pane.setPadding(new Insets(20,20,20,20));

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.showAndWait();
	}
}
