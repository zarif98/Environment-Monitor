package EnvironmentMonitor;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;


public class GUI_Submit implements IsDialog {
	/**
	 * Code for dialog in which 
	 */
	public static void dialog(Volunteer user) {
		TableView<Job> userjobView = new TableView<Job>();
		
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Log your work");
		stage.setMinWidth(0);
		

		TableColumn<Job, String> colDesc =
				new TableColumn<Job, String>("Log");
		colDesc.setMinWidth(200);
		colDesc.setCellValueFactory(
				new PropertyValueFactory<Job, String>("jobName"));

		TableColumn<Job, Button> colRemove = 
				new TableColumn<Job, Button>("Job Name");
		colRemove.setCellValueFactory(  //clickable button which runs command in this class
				new Callback<CellDataFeatures<Job, Button>, ObservableValue<Button>>() {
					public ObservableValue<Button> call(CellDataFeatures<Job, Button> param) {
						Job job = param.getValue();
						Button btn = new Button();
						btn.setText("Submit");
						btn.setOnMouseClicked(e -> {
							System.out.println("testing");
							if(job instanceof CountingJob) {
								GUI_SubmitCount.dialog((CountingJob)job);
							}
							user.removeJob(job);
						});
						return new ReadOnlyObjectWrapper<Button>(btn);
					}
				});;
		
		userjobView.getColumns().setAll(colDesc, colRemove);
		
		userjobView.getItems().addAll(user.getJobs());
		
		
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
