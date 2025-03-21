package User_Interface;

import Repo.UserDetailsRepo;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import myLibs.UserDetailsModules;

public class UserDetails extends Application {
	@Override
	public void start(Stage primaryStage) {

		// Fonts
		Font font1 = new Font("Arial", 25);
		Font font2 = new Font("Arial", 18);

		// Declare and Initialize
		// Title Label
		Label titleLabel = new Label("User Details");
		titleLabel.relocate(170, 20);
		titleLabel.setFont(font1);

		// Labels and TextFields
		Label nameLabel = new Label("Name");
		TextField nameField = new TextField();
		nameLabel.relocate(50, 70);
		nameField.relocate(150, 70);
		nameLabel.setFont(font2);

		Label ageLabel = new Label("Age");
		TextField ageField = new TextField();
		ageLabel.relocate(50, 110);
		ageField.relocate(150, 110);
		ageLabel.setFont(font2);

		Label weightLabel = new Label("Weight");
		TextField weightField = new TextField();
		weightLabel.relocate(50, 150);
		weightField.relocate(150, 150);
		weightLabel.setFont(font2);

		Label heightLabel = new Label("Height");
		TextField heightField = new TextField();
		heightLabel.relocate(50, 190);
		heightField.relocate(150, 190);
		heightLabel.setFont(font2);
		// Activity Level Checkboxes
		Label activityLabel = new Label("Activity Level");
		CheckBox lightCheckBox = new CheckBox("Light");
		CheckBox moderateCheckBox = new CheckBox("Moderate");
		CheckBox highCheckBox = new CheckBox("High");
		activityLabel.setFont(font2);

		activityLabel.relocate(40, 230);
		lightCheckBox.relocate(150, 230);
		moderateCheckBox.relocate(150, 260);
		highCheckBox.relocate(150, 290);

		// Gender ComboBox
		Label genderLabel = new Label("Gender");
		ComboBox<String> genderComboBox = new ComboBox<>();
		genderComboBox.getItems().addAll("Male", "Female", "Others");
		genderLabel.setFont(font2);
		genderLabel.relocate(50, 330);
		genderComboBox.relocate(150, 330);

		CheckBox chkTrainer = new CheckBox("Trainer");
		chkTrainer.relocate(120, 380);

		CheckBox chkRegularUser = new CheckBox("Regular User");
		chkRegularUser.relocate(200, 380);

		// Buttons
		Button btnSubmit = new Button("Submit");
		btnSubmit.relocate(150, 420);
		btnSubmit.setPrefSize(80, 30);
		btnSubmit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent actionEvent) {
				UserDetailsModules userDetails = new UserDetailsModules();

				// System.out.println(txtUserId);
				userDetails.setName(nameField.getText());
				userDetails.setAge(Integer.parseInt(ageField.getText()));
				userDetails.setWeight(weightField.getText());
				userDetails.setHeight(heightField.getText());
				boolean result = new UserDetailsRepo().Insert(userDetails);
			}
		});
		Button btnClose = new Button("Close");
		btnClose.relocate(250, 420);
		btnClose.setPrefSize(80, 30);
		btnClose.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				primaryStage.close();
			}
		}));
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 400, 470);
		primaryStage.setTitle("User Details Form");
		primaryStage.setScene(scene);
		// Adding elements to pane
		pane.getChildren().addAll(titleLabel, nameLabel, nameField, ageLabel, ageField, weightLabel, weightField,
				heightLabel, heightField, activityLabel, lightCheckBox, moderateCheckBox, highCheckBox, genderLabel,
				genderComboBox, chkTrainer, chkRegularUser, btnSubmit, btnClose);
		//Display Control
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
