package EnvironmentMonitor;


import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GUI_Main extends Application{

	public static final UserList users = new UserList();
	public static final JobList jobs = new JobList();
	public static final EnvironmentList environments = new EnvironmentList();
	public static Level loggingLevel = Level.INFO;
	private static Logger logger = Logger.getLogger(GUI_Main.class.getName());
	/**
	 * Main method launches the application and calls the start method
	 * @param args no command line for this program
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Generate GUI and set it up
	 * @param primaryStage stage that will be worked with
	 * @throws Exception if stage generation does not work
	 */
	public void start(Stage primaryStage) throws Exception {
		BorderPane mainPane = new BorderPane();
		setUpLogin(mainPane);
		Scene scene = new Scene(mainPane);
		setStage(primaryStage, scene);
	}

	/**
	 * Set up the main view window with login details
	 * @param mainPane
	 */
	private void setUpLogin(BorderPane mainPane) {
		//Create controls to interact with
		logger.setLevel(loggingLevel);
		Label loginLabel = new Label();
		loginLabel.setText("Sign in to your account");

		TextField usernameInput = new TextField();
		usernameInput.setPromptText("username");

		PasswordField passwordInput = new PasswordField();
		passwordInput.setPromptText("password");

		Button createAccountButton = new Button();
		createAccountButton.setText("Create Account");
		createAccountButton.setOnMouseClicked(e -> GUI_CreateAccount.dialog(users));

		Button loginButton = new Button();
		loginButton.setText("Sign In");
		loginButton.setOnMouseClicked(e -> {
			Volunteer user = users.getUser(usernameInput.getText(), passwordInput.getText());
			if(user != null) {
				logger.log(Level.INFO, usernameInput.getText() + " has successfully logged in." );
				setupLoggedIn(mainPane, users.getUser(usernameInput.getText(), passwordInput.getText()));
			}
			else {
				System.err.println("Invalid Username/Password");
				logger.log(Level.SEVERE, "Attempted log in with invalid username or password");
			}
		});
		loginButton.setOnKeyPressed(e ->{
			KeyCode keyCode = e.getCode();
			if(keyCode.equals(KeyCode.ENTER)) {
				Volunteer user = users.getUser(usernameInput.getText(), passwordInput.getText());
				if(user != null) {
					logger.log(Level.INFO, usernameInput.getText() + " has successfully logged in." );
					setupLoggedIn(mainPane, users.getUser(usernameInput.getText(), passwordInput.getText()));
				}
				else {
					System.err.println("Invalid Username/Password");
					logger.log(Level.SEVERE, "Attempted log in with invalid username or password");
				}
			}
		});
		

		//place controls on pane
		mainPane.setTop(loginLabel);
		mainPane.setLeft(usernameInput);
		mainPane.setCenter(passwordInput);
		mainPane.setRight(loginButton);
		mainPane.setBottom(createAccountButton);

		BorderPane.setAlignment(loginLabel, Pos.CENTER);
		BorderPane.setAlignment(usernameInput, Pos.CENTER);
		BorderPane.setAlignment(passwordInput, Pos.CENTER);
		BorderPane.setAlignment(loginButton, Pos.CENTER);
		BorderPane.setAlignment(createAccountButton, Pos.CENTER);

		BorderPane.setMargin(loginLabel, new Insets(20,0,10,0));
		BorderPane.setMargin(usernameInput, new Insets(10));
		BorderPane.setMargin(passwordInput, new Insets(10));
		BorderPane.setMargin(loginButton, new Insets(10));
		BorderPane.setMargin(createAccountButton, new Insets(10,0,20,0));
	}

	private void setupLoggedIn(BorderPane mainPane, Volunteer volunteer) {
		//create controls to interact with (for all)
		Label welcomeLabel = new Label();
		welcomeLabel.setText("Welcome, " + volunteer.toString());

		Button findJobs = new Button();
		findJobs.setText("Find Volunteering");

		findJobs.setOnAction(e -> GUI_FindJobs.dialog(volunteer));

		Button submitWork = new Button();
		submitWork.setText("Submit Work");
		submitWork.setOnAction(e -> GUI_Submit.dialog(volunteer));

		Button loggingLevel = new Button();
		loggingLevel.setText("Log Level");
		loggingLevel.setOnAction(e -> adjustLoggingLevel());
		
		HBox pane = new HBox(20);
		pane.getChildren().addAll(loggingLevel, submitWork);
		pane.setAlignment(Pos.BASELINE_CENTER);
		pane.setStyle("-fx-background-color: White;");
		pane.setPadding(new Insets(20,20,20,20));
		
		//place controls on pane (for all)
		mainPane.setTop(welcomeLabel);
		
		mainPane.setCenter(findJobs);
		mainPane.setBottom(pane);

		BorderPane.setAlignment(welcomeLabel, Pos.CENTER);
		BorderPane.setAlignment(findJobs, Pos.CENTER);
		BorderPane.setAlignment(submitWork, Pos.CENTER);

		BorderPane.setMargin(welcomeLabel, new Insets(20,0,10,0));
		BorderPane.setMargin(findJobs, new Insets(10));
		BorderPane.setMargin(submitWork, new Insets(10,0,20,0));


		if(volunteer.isAdmin()) {
			//create controls to interact with (admins only)
			Button makeEnvironment = new Button();
			makeEnvironment.setText("View/Make Environment");
			makeEnvironment.setOnAction(e -> GUI_EnvironmentAddView.dialog());

			Button makeJob = new Button();
			makeJob.setText("Make Job");
			makeJob.setOnAction(e -> GUI_EnvironmentView.dialog());

			//place controls on pane (admins only)
			mainPane.setLeft(makeEnvironment);
			mainPane.setRight(makeJob);

			BorderPane.setAlignment(makeEnvironment, Pos.CENTER);
			BorderPane.setAlignment(makeJob, Pos.CENTER);

			BorderPane.setMargin(makeEnvironment, new Insets(10));
			BorderPane.setMargin(makeJob, new Insets(10));
		}
		else {
			mainPane.setRight(null);
			mainPane.setLeft(null);
		}
	}

	private void adjustLoggingLevel() {
		Stage newStage = new Stage();
		VBox comp = new VBox();
		Label adjustLabel = new Label("Adjust your logging level (Highest Number = Least Info Logged)");
		Slider slider = new Slider(1, 5, 1);
		comp.setAlignment(Pos.CENTER);
		
		
		slider.setValue(2);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setMajorTickUnit(1);
		slider.setMinorTickCount(0);
		slider.setBlockIncrement(1);
		slider.setSnapToTicks(true);

		Label currentLevel = new Label("Your selected level is: " + loggingLevel.toString() 
		+ " (" + 2 + ")");
		
		slider.valueProperty().addListener(new ChangeListener() {

			public void changed(ObservableValue arg0, Object arg1, Object arg2) {
				if(slider.getValue() == 1) {
					currentLevel.setText("Your selected level is: ALL (1)");
					loggingLevel = Level.ALL;
				}
				else if(slider.getValue() == 2) {
					currentLevel.setText("Your selected level is: INFO (2)");
					loggingLevel = Level.INFO;
				}
				else if(slider.getValue() == 3) {
					currentLevel.setText("Your selected level is: WARNING (3)");
					loggingLevel = Level.WARNING;
				}
				else if(slider.getValue() == 4) {
					currentLevel.setText("Your selected level is: SEVERE (4)");
					loggingLevel = Level.SEVERE;
				}
				else if(slider.getValue() == 5){
					currentLevel.setText("Your selected level is: OFF (5)");
					loggingLevel = Level.OFF;
				}
				logger.setLevel(loggingLevel);
				logger.log(Level.INFO, "Logging Level changed to: " + loggingLevel);
				
				
			}
			
		});
		comp.getChildren().addAll(adjustLabel, slider, currentLevel);
		
		

		Scene stageScene = new Scene(comp,400, 100);
		newStage.setScene(stageScene);
		newStage.show();
	}

	/**
	 * Set up stage and display it
	 * @param primaryStage
	 * @param scene
	 */
	private void setStage(Stage primaryStage, Scene scene) {
		
		
		primaryStage.setScene(scene);
		scene.getStylesheets().add(getClass().getResource("EnvironmentDesign.css").toExternalForm());
		primaryStage.setTitle("Environment Monitor");
		Font.loadFont("Montserrat", 10);
		primaryStage.show();
	}
}
