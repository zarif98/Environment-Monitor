package EnvironmentMonitor;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GUI_UniversalPopUps {

	public static void showStage(Object obj, int num){
		if(obj == GUI_MakeEnvironment.class && num == 1 ) {
			Stage newStage = new Stage();
			VBox comp = new VBox();
			Label warning = new Label("Please pick one or both of the checkboxes");
			warning.setMaxWidth(Double.MAX_VALUE);
			warning.setAlignment(Pos.BOTTOM_CENTER);

			comp.getChildren().add(warning);

			Scene stageScene = new Scene(comp,250,50);
			newStage.setScene(stageScene);
			newStage.show();
			//
		}
		else if(obj == GUI_MakeEnvironment.class && num == 2) {
			Stage newStage = new Stage();
			VBox comp = new VBox();
			Label registration = new Label("Would you like to add Jobs for your registered environment?");
			Button addJobs = new Button("Add Jobs");
			addJobs.setAlignment(Pos.CENTER_RIGHT);
			registration.setMaxWidth(Double.MAX_VALUE);
			registration.setAlignment(Pos.BOTTOM_CENTER);
			
			StackPane.setAlignment(addJobs, Pos.CENTER_LEFT);
			

			comp.getChildren().addAll(registration, addJobs);

			Scene stageScene = new Scene(comp,400, 100);
			newStage.setScene(stageScene);
			newStage.show();
		}
	}
}
