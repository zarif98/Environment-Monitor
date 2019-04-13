package EnvironmentMonitor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StartingGUI extends Application {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setWidth(600);
		BorderPane mainPane = new BorderPane();
		setupControls(mainPane);
		Scene scene = new Scene(mainPane);
		setStage(primaryStage, scene);
	}
	public void setupControls(BorderPane mainPane) {
		Button logging = new Button("Logging");
		Button volunteer = new Button("Volunteer");
		Button developNew = new Button("Make a new Environement");
		developNew.setOnAction(e -> {MakeNewEnvironmentGUI.generate();});
		volunteer.setOnAction(e -> VolunteerGUI.generate());
		logging.setOnAction(e -> LoggingGUI.generate());
		mainPane.setRight(developNew);
		mainPane.setCenter(volunteer);
		mainPane.setLeft(logging);
		
		
	}
	public void setStage(Stage primaryStage, Scene scene) {
		primaryStage.setTitle("Environment Monitor");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
