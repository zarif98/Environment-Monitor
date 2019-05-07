package EnvironmentMonitor;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class GUI_SubmitCount implements IsDialog {

	public static void dialog(CountingJob job) {
		
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Log your work");
		stage.setMinWidth(0);
		
		Label registration = new Label("Plase Enter number of organisms counted:");
		TextField input = new TextField();
		input.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
		Button submit = new Button("Submit");
		
		submit.setOnAction(e-> {
			job.submitCount(Integer.parseInt(input.getText()));
			stage.close();
		});

		VBox pane = new VBox(20);
		pane.getChildren().addAll(registration, input, submit);
		pane.setAlignment(Pos.CENTER);
		pane.setStyle("-fx-background-color: AntiqueWhite;");
		pane.setPadding(new Insets(20,20,20,20));
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.showAndWait();
	}
}
