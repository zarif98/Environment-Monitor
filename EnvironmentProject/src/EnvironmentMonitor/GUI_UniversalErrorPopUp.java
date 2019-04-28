package EnvironmentMonitor;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GUI_UniversalErrorPopUp {

	public static void showStage(Object obj){
		if(obj == GUI_MakeEnvironment.class ) {
			Stage newStage = new Stage();
			VBox comp = new VBox();
			Label warning = new Label("Please pick one or both of the checkboxes");

			comp.getChildren().add(warning);

			Scene stageScene = new Scene(comp,250,100);
			newStage.setScene(stageScene);
			warning.setMaxWidth(Double.MAX_VALUE);
			warning.setAlignment(Pos.CENTER);
			newStage.show();
		}
	}
}
