package User_Interface;

import Repo.UsersRepo;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import myLibs.UserModules;

public class Users extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//Declare
		Label lblTitle, lblUserId, lblPassword;
		TextField txtUserId, txtPassword;
		CheckBox chkLoggedIn, chkLoggedOut;
		Button btnSubmit, btnClose;

		//Initialize
		lblTitle = new Label("Health & Fitness");
		lblTitle.relocate(170, 30);
		Font font1 = new Font("Arial", 20);
		lblTitle.setFont(font1);

		lblUserId = new Label("USERID");
		lblUserId.relocate(100, 90);
		Font font2 = new Font("Arial", 14);
		lblUserId.setFont(font2);

		txtUserId = new TextField();
		txtUserId.relocate(170, 85);

		lblPassword = new Label("PASSWORD");
		lblPassword.relocate(75, 140);
		lblPassword.setFont(font2);

		txtPassword = new TextField();
		txtPassword.relocate(170, 135);

		// Login Status
		Label lblLoginStatus = new Label("Login Status");
		lblLoginStatus.relocate(100, 190);
		lblLoginStatus.setFont(font2);

		chkLoggedIn = new CheckBox("Logged IN");
		chkLoggedIn.relocate(120, 220);

		chkLoggedOut = new CheckBox("Logged Out");
		chkLoggedOut.relocate(250, 220);

		chkLoggedOut.setSelected(true); // Default selection

		// Buttons
		btnSubmit = new Button("Submit");
		btnSubmit.relocate(140, 250);
		btnSubmit.setPrefSize(80, 30);
		btnSubmit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent actionEvent) {
				UserModules users = new UserModules();
				users.setUserId(Integer.parseInt(txtUserId.getText()));
				users.setPassword(txtPassword.getText());
				boolean result = new UsersRepo().Insert(users);
			}
		});

		btnClose = new Button("Close");
		btnClose.relocate(250, 250);
		btnClose.setPrefSize(80, 30);
		btnClose.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				primaryStage.close();
			}
		}));
		//Add Controls
		Pane pane = new Pane();
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setWidth(500);
		primaryStage.setHeight(400);
		primaryStage.setTitle("Users Form");
		
		pane.getChildren().addAll(lblTitle, lblUserId, lblPassword, lblLoginStatus);
		pane.getChildren().addAll(txtUserId, txtPassword);
		pane.getChildren().addAll(chkLoggedIn, chkLoggedOut);
		pane.getChildren().addAll(btnSubmit, btnClose);
		// display window
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
