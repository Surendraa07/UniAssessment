package User_interface;

import Repo.UserDetailsRepo;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
		// Title Label
		Label titleLabel = new Label("User Details");
		titleLabel.relocate(170, 20);
		Font font1 = new Font("Arial", 25);
		titleLabel.setFont(font1);

		// Labels and Input Fields
		String labelStyle = "-fx-background-color: #6B7755; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 5px 10px; -fx-background-radius: 10;";
		String fieldStyle = "-fx-background-color: #C0C9B5; -fx-background-radius: 10;";

		Label uidLabel = new Label("Uid");
		TextField uidField = new TextField();
		uidLabel.relocate(50, 70);
		uidLabel.setStyle(labelStyle);
		uidField.relocate(150, 70);
		uidField.setStyle(fieldStyle);

		// Labels and TextFields
		Label nameLabel = new Label("Name");
		TextField nameField = new TextField();
		nameLabel.relocate(50, 110);
		nameLabel.setStyle(labelStyle);
		nameField.relocate(150, 110);
		nameField.setStyle(fieldStyle);

		Label ageLabel = new Label("Age");
		TextField ageField = new TextField();
		ageLabel.relocate(50, 150);
		ageLabel.setStyle(labelStyle);
		ageField.relocate(150, 150);
		ageField.setStyle(fieldStyle);

		Label weightLabel = new Label("Weight(kg)");
		TextField weightField = new TextField();
		weightLabel.relocate(50, 190);
		weightLabel.setStyle(labelStyle);
		weightField.relocate(150, 190);
		weightField.setStyle(fieldStyle);

		Label heightLabel = new Label("Height(cm)");
		TextField heightField = new TextField();
		heightLabel.relocate(50, 230);
		heightLabel.setStyle(labelStyle);
		heightField.relocate(150, 230);
		heightField.setStyle(fieldStyle);

		// Gender ComboBox
		Label genderLabel = new Label("Gender");
		ComboBox<String> genderComboBox = new ComboBox<>();
		genderComboBox.getItems().addAll("Male", "Female", "Others");
		genderLabel.relocate(50, 280);
		genderLabel.setStyle(labelStyle);
		genderComboBox.relocate(150, 280);
		genderLabel.setStyle(labelStyle);
		genderComboBox.setStyle(fieldStyle);

		// Checkboxes (Only one can be selected)
		CheckBox chkTrainer = new CheckBox("Trainer");
		chkTrainer.relocate(120, 320);

		CheckBox chkRegularUser = new CheckBox("Regular User");
		chkRegularUser.relocate(200, 320);

		chkTrainer.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
		chkRegularUser.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

		// Ensure only one checkbox can be selected
		chkTrainer.setOnAction(event -> {
			if (chkTrainer.isSelected()) {
				chkRegularUser.setSelected(false);
			}
		});

		chkRegularUser.setOnAction(event -> {
			if (chkRegularUser.isSelected()) {
				chkTrainer.setSelected(false);
			}
		});

		// Buttons
		Button btnSubmit = new Button("Submit");
		btnSubmit.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-font-weight: bold;");
		btnSubmit.relocate(50, 350);
		btnSubmit.setPrefSize(80, 30);
		btnSubmit.setOnAction((ActionEvent actionEvent) -> {
			UserDetailsModules userDetails = new UserDetailsModules();
			userDetails.setUid(Integer.parseInt(uidField.getText()));
			userDetails.setName(nameField.getText());
			userDetails.setAge(Integer.parseInt(ageField.getText()));
			userDetails.setWeight(weightField.getText());
			userDetails.setHeight(heightField.getText());

			boolean result = new UserDetailsRepo().Insert(userDetails);

			boolean isTrainer = chkTrainer.isSelected();
			boolean isRegularUser = chkRegularUser.isSelected();

			if (!isTrainer && !isRegularUser) {
				showError("Please select Trainer or Regular User before submitting.");
				return;
			}

			if (isTrainer) {
				openTrainerUI(); 
				return; 
			}

			// Validate required fields for Regular User
			if (isRegularUser) {
				if (nameField.getText().isEmpty() || ageField.getText().isEmpty() || weightField.getText().isEmpty()
						|| heightField.getText().isEmpty() || genderComboBox.getSelectionModel().isEmpty()) {

					showError("Something went wrong, please try again!");
					return;
				}

				openRegularUserDashboardUI();
			}
		});
		// submit button
		Button btnEdit = new Button("Edit");
		btnEdit.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-font-weight: bold;");
		btnEdit.relocate(150, 350);
		btnEdit.setPrefSize(80, 30);
		btnEdit.setOnAction(e -> {
			try {
				int uid = Integer.parseInt(uidField.getText()); // Assuming uidField is a TextField for UID input
				UserDetailsModules userDetails = new UserDetailsModules(uid, nameField.getText(),
						Integer.parseInt(ageField.getText()), weightField.getText(), heightField.getText());
				boolean result = new UserDetailsRepo().update(userDetails); // Update the user based on UID
				Alert alert = new Alert(result ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR);
				alert.setContentText(result ? "Record updated successfully!" : "Failed to update record.");
				alert.showAndWait();
			} catch (NumberFormatException ex) {
				showError("Invalid UID. Please enter a valid UID.");
			}
		});
		//delete button
		Button btnDelete = new Button("Delete");
		btnDelete.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-font-weight: bold;");
		btnDelete.relocate(250, 350);
		btnDelete.setPrefSize(80, 30);
		btnDelete.setOnAction(e -> {
			try {
				int uid = Integer.parseInt(uidField.getText());
				boolean result = new UserDetailsRepo().deleteByUid(uid); 
				Alert alert = new Alert(result ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR);
				alert.setContentText(result ? "Record deleted successfully!" : "Failed to delete record.");
				alert.showAndWait();
			} catch (NumberFormatException ex) {
				showError("Invalid UID. Please enter a valid UID.");
			}
		});
		//search button
		Button btnSearch = new Button("Search");
		btnSearch.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-font-weight: bold;");
		btnSearch.relocate(320, 70);
		btnSearch.setPrefSize(80, 20);
		btnSearch.setOnAction(e -> {
			try {
				int uid = Integer.parseInt(uidField.getText()); 
				UserDetailsModules user = new UserDetailsRepo().searchByUID(uid);
				if (user != null) {
					uidField.setText(String.valueOf(user.getUid()));
					nameField.setText(user.getName());
					ageField.setText(String.valueOf(user.getAge()));
					weightField.setText(user.getWeight());
					heightField.setText(user.getHeight());
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setContentText("Record found and loaded.");
					alert.showAndWait();
				} else {
					Alert alert = new Alert(Alert.AlertType.WARNING);
					alert.setContentText("Record not found.");
					alert.showAndWait();
				}
			} catch (NumberFormatException ex) {
				showError("Invalid UID. Please enter a valid UID.");
			}
		});
		//close button
		Button btnClose = new Button("Close");
		btnClose.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-font-weight: bold;");
		btnClose.relocate(350, 350);
		btnClose.setPrefSize(80, 30);
		btnClose.setOnMouseClicked((MouseEvent event) -> primaryStage.close());

		Pane pane = new Pane();
		Scene scene = new Scene(pane, 470, 450);
		primaryStage.setTitle("User Details Form");
		primaryStage.setScene(scene);

		pane.getChildren().addAll(uidLabel, titleLabel, nameLabel, uidField, nameField, ageLabel, ageField, weightLabel,
				weightField, heightLabel, heightField, genderLabel, genderComboBox, chkTrainer, chkRegularUser,
				btnSearch, btnSubmit, btnEdit, btnDelete,btnClose);
		primaryStage.show();
	}

	private void showError(String message) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}

	private void openTrainerUI() {
		Trainer trainerUI = new Trainer();
		Stage trainerDashboardStage = new Stage();
		try {
			trainerUI.start(trainerDashboardStage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void openRegularUserDashboardUI() {
		RegularUser regularUserUI = new RegularUser();
		Stage regularUserDashboardStage = new Stage();
		try {
			regularUserUI.start(regularUserDashboardStage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
