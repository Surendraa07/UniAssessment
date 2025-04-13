package User_interface;

// Importing required packages and user-defined modules
import Repo.RegularuserRepo;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import myLibs.RegularUserModules;

public class RegularUser extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Create a root pane to contain all UI components
		Pane root = new Pane();

		// Title label of the application
		Label titleLabel = new Label("Regular Users");
		titleLabel.relocate(150, 20);
		titleLabel.setFont(new Font("Arial", 25));

		// Define styles for labels and input fields for a consistent UI look
		String labelStyle = "-fx-background-color: #6B7755; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 5px 10px; -fx-background-radius: 10;";
		String fieldStyle = "-fx-background-color: #C0C9B5; -fx-background-radius: 10;";
		String ComboBoxStyle = "-fx-background-color: #C0C9B5; -fx-background-radius: 10;";

		// Label and input 
		Label goalLabel = new Label("Annual Goal");
		goalLabel.relocate(50, 70);
		goalLabel.setStyle(labelStyle);
		TextField goalField = new TextField();
		goalField.relocate(180, 70);
		goalField.setStyle(fieldStyle);

		Label scheduleLabel = new Label("Annual Schedule");
		scheduleLabel.relocate(50, 110);
		scheduleLabel.setStyle(labelStyle);
		TextField scheduleField = new TextField();
		scheduleField.relocate(180, 110);
		scheduleField.setStyle(fieldStyle);

		// Dropdown for selecting fitness benefits
		Label benefitsLabel = new Label("Benefits");
		benefitsLabel.relocate(50, 150);
		benefitsLabel.setStyle(labelStyle);
		ComboBox<String> benefitsBox = new ComboBox<>();
		benefitsBox.getItems().addAll(
			"Build muscle (strength training)",
			"Lose weight (cardio + strength)",
			"Improve endurance (running, cycling, etc.)",
			"Increase flexibility (yoga, stretching)"
		);
		benefitsBox.relocate(180, 150);
		benefitsBox.setStyle(fieldStyle);

		// Dropdown for selecting which calculation UI to open
		Label calculateLabel = new Label("Calculate");
		calculateLabel.relocate(50, 190);
		calculateLabel.setStyle(labelStyle);
		ComboBox<String> calculateBox = new ComboBox<>();
		calculateBox.getItems().addAll("Calories", "Protein", "Fat");
		calculateBox.relocate(180, 190);
		calculateBox.setStyle(fieldStyle);

		// Submit button to save data and navigate to the chosen calculator
		Button submitButton = new Button("Submit");
		submitButton.relocate(100, 240);
		submitButton.setPrefSize(80, 30);
		submitButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
		submitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				RegularUserModules regularUserModules = new RegularUserModules();
				regularUserModules.setAnnualGoal(goalField.getText());
				regularUserModules.setAnnualSchedule(scheduleField.getText());

				boolean result = new RegularuserRepo().Insert(regularUserModules);

				String selectedCalculation = calculateBox.getValue();
				if (selectedCalculation != null) {
					try {
						Stage newStage = new Stage();
						switch (selectedCalculation) {
							case "Calories":
								new CaloriesCalculator().start(newStage);
								break;
							case "Protein":
								new ProteinCalculator().start(newStage);
								break;
							case "Fat":
								new FatCalculator().start(newStage);
								break;
							default:
								System.out.println("Invalid Selection");
						}
					} catch (Exception e) {
						e.printStackTrace(); 
					}
				}
			}
		});

		// Close button to exit the application
		Button closeButton = new Button("Close");
		closeButton.relocate(200, 240);
		closeButton.setPrefSize(80, 30);
		closeButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
		closeButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				primaryStage.close(); 
			}
		});

		// Add all UI components to the pane
		root.getChildren().addAll(titleLabel,goalLabel, goalField,scheduleLabel, scheduleField,benefitsLabel, benefitsBox,calculateLabel, calculateBox,submitButton, closeButton);

		// Final setup for the stage
		Scene scene = new Scene(root, 480, 300);
		primaryStage.setTitle("Regular Users");
		primaryStage.setScene(scene);
		primaryStage.show(); 
	}

	public static void main(String[] args) {
		launch(args);
	}
}
