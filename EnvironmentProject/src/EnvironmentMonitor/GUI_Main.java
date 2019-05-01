package EnvironmentMonitor;


import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GUI_Main extends Application{

	public static final UserList users = new UserList();
	public static final JobList jobs = new JobList();
	public static final EnvironmentList environments = new EnvironmentList();

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
		setupLogin(mainPane);
		Scene scene = new Scene(mainPane);
		setStage(primaryStage, scene);
	}

	/**
	 * Set up the main view window with login details
	 * @param mainPane
	 */
	private void setupLogin(BorderPane mainPane) {
		//Create controls to interact with
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
				setupLoggedIn(mainPane, user);
			}
			else {
				System.err.println("Invalid Username/Password");
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

		findJobs.setOnAction(e -> GUI_FindJobs.dialog());

		Button submitWork = new Button();
		submitWork.setText("Submit Work");
		submitWork.setOnAction(e -> GUI_Submit.dialog());

		//place controls on pane (for all)
		mainPane.setTop(welcomeLabel);
		mainPane.setCenter(findJobs);
		mainPane.setBottom(submitWork);

		BorderPane.setAlignment(welcomeLabel, Pos.CENTER);
		BorderPane.setAlignment(findJobs, Pos.CENTER);
		BorderPane.setAlignment(submitWork, Pos.CENTER);

		BorderPane.setMargin(welcomeLabel, new Insets(20,0,10,0));
		BorderPane.setMargin(findJobs, new Insets(10));
		BorderPane.setMargin(submitWork, new Insets(10,0,20,0));


		if(volunteer.isAdmin()) {
			//create controls to interact with (admins only)
			Button makeEnvironment = new Button();
			makeEnvironment.setText("Make Environment");
			makeEnvironment.setOnAction(e -> GUI_MakeEnvironment.dialog(environments));

			Button makeJob = new Button();
			makeJob.setText("Make Job");
			makeJob.setOnAction(e -> GUI_EnvironmentView.dialog(jobs));

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

	/**
	 * Set up stage and display it
	 * @param primaryStage
	 * @param scene
	 */
	private void setStage(Stage primaryStage, Scene scene) {
		primaryStage.setScene(scene);
		scene.getStylesheets().add("EnvironmentDesign.css");
		primaryStage.setTitle("Environment Monitor");
		primaryStage.show();
	}
}
