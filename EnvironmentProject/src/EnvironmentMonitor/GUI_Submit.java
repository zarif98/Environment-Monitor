package EnvironmentMonitor;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;


public class GUI_Submit implements IsDialog {
	
	static TableView<Job> userjobView = new TableView<Job>();

	/**
	 * Code for dialog in which 
	 */
	public static void dialog() {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Log your work");
		stage.setMinWidth(0);
		

		TableColumn<Job, String> colDesc =
				new TableColumn<Job, String>("Log");
		colDesc.setMinWidth(200);
		colDesc.setCellValueFactory(
				new PropertyValueFactory<Job, String>("jobName"));

		TableColumn<Job, String> colRemove = 
				new TableColumn<Job, String>("Job Name");
		Callback<TableColumn<Job, String>, TableCell<Job, String>> cellFactory = new Callback<TableColumn<Job, String>, TableCell<Job, String>>() {
			public TableCell<Job, String> call(TableColumn<Job, String> param) {
				final TableCell<Job, String> cell = new TableCell<Job, String>() {
					private final Button button = new Button();

					public void updateItem(String crn, boolean empty) {
						if(empty) {
							setGraphic(null);
						} else {
							Job currentJob = getTableView().getItems().get(getIndex());
							
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
		
		userjobView.getColumns().setAll(colRemove, colDesc);
		
		
		VBox pane = new VBox(20);
		pane.getChildren().addAll(userjobView);
		pane.setAlignment(Pos.CENTER);
		pane.setStyle("-fx-background-color: AntiqueWhite;");
		pane.setPadding(new Insets(20,20,20,20));
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.showAndWait();
	}

}
