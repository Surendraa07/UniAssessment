package User_interface;

// Import required JavaFX components and user-defined modules
import Repo.UsersRepo;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import myLibs.UserModules;
public class Users extends Application {

	@Override
	public void start(Stage primaryStage) {
		// Create the root pane 
		Pane root = new Pane();

		// Set gradient background color using CSS style
		Stop[] stops = new Stop[] {
			new Stop(0, Color.web("#E6EFE9")),
			new Stop(1, Color.web("#7F8C8D"))
		};
		root.setStyle("-fx-background-color: linear-gradient(to right, #E6EFE9, #7F8C8D);");

		// Title label for the application
		Label lblTitle = new Label("Health & Fitness");
		lblTitle.setFont(new Font("Serif", 26));
		lblTitle.setStyle("-fx-background-color: #899D89; -fx-text-fill: white; -fx-padding: 10; -fx-background-radius: 20;");
		lblTitle.relocate(140, 20); 
		lblTitle.setPrefSize(220, 50);
		lblTitle.setAlignment(javafx.geometry.Pos.CENTER); 

		// Label and TextField 
		Label lblUserId = new Label("USERID");
		lblUserId.setFont(new Font("Arial", 16));
		lblUserId.setStyle("-fx-font-weight: bold;");
		lblUserId.relocate(90, 90);

		TextField txtUserId = new TextField();
		txtUserId.relocate(180, 85);
		txtUserId.setPrefSize(180, 30);
		txtUserId.setStyle("-fx-background-color: #DCE8D9; -fx-background-radius: 15;");

		Label lblPassword = new Label("PASSWORD");
		lblPassword.setFont(new Font("Arial", 16));
		lblPassword.setStyle("-fx-font-weight: bold;");
		lblPassword.relocate(80, 140);

		TextField txtPassword = new TextField();
		txtPassword.relocate(180, 135);
		txtPassword.setPrefSize(180, 30);
		txtPassword.setStyle("-fx-background-color: #DCE8D9; -fx-background-radius: 15;");

		Label lblLoginStatus = new Label("Login Status");
		lblLoginStatus.setFont(new Font("Arial", 16));
		lblLoginStatus.setStyle("-fx-font-weight: bold;");
		lblLoginStatus.relocate(90, 190);
		// CheckBox for logged in and logged out 
		CheckBox chkLoggedIn = new CheckBox("Logged IN");
		chkLoggedIn.relocate(120, 220);

		CheckBox chkLoggedOut = new CheckBox("Logged Out");
		chkLoggedOut.relocate(250, 220);
		chkLoggedOut.setSelected(true);

		// Submit button to handle user data submission
		Button btnSubmit = new Button("Submit");
		btnSubmit.relocate(140, 270);
		btnSubmit.setPrefSize(80, 30);
		btnSubmit.setStyle("-fx-background-color: black; -fx-text-fill: white;");

		// Event handler for the Submit button
		btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				UserModules users = new UserModules();
				users.setUserId(Integer.parseInt(txtUserId.getText()));
				users.setPassword(txtPassword.getText());

				boolean result = new UsersRepo().Insert(users);

				UserDetails userDetails = new UserDetails();
				Stage userDetailsStage = new Stage();
				try {
					userDetails.start(userDetailsStage);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		// Close button to exit the application
		Button btnClose = new Button("Close");
		btnClose.relocate(250, 270);
		btnClose.setPrefSize(80, 30);
		btnClose.setStyle("-fx-background-color: black; -fx-text-fill: white;");
		btnClose.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				primaryStage.close();
			}
		}));

		// Add all components to the pane
		root.getChildren().addAll(lblTitle,lblUserId, txtUserId,lblPassword, txtPassword,lblLoginStatus, chkLoggedIn, chkLoggedOut,btnSubmit, btnClose);

		// Create the scene, set the stage, and show the window
		Scene scene = new Scene(root, 500, 400);
		primaryStage.setTitle("Users Login");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}

