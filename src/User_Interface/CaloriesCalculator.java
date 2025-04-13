package User_Interface;

// Import necessary JavaFX classes for GUI components and application structure
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CaloriesCalculator extends Application {

	@Override
	public void start(Stage primaryStage) {

		// Define CSS styles for label, text field, and combo box to maintain consistent
		// design
		String labelStyle = "-fx-background-color: #6B7755; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 5px 10px; -fx-background-radius: 10;";
		String fieldStyle = "-fx-background-color: #C0C9B5; -fx-background-radius: 10;";
		String ComboBoxStyle = "-fx-background-color: #C0C9B5; -fx-background-radius: 10;";

		// Create and style the title label
		Label titleLabel = new Label("Calories Calculator");
		titleLabel.relocate(150, 20);
		Font font1 = new Font("Arial", 25);
		titleLabel.setFont(font1);

		// Create a Pane layout to manually position elements
		Pane pane = new Pane();

		// Weight input
		Label weightLabel = new Label("Weight (kg):");
		TextField weightField = new TextField();
		weightLabel.relocate(20, 50);
		weightLabel.setStyle(labelStyle);
		weightField.relocate(150, 50);
		weightField.setStyle(fieldStyle);

		// Height input
		Label heightLabel = new Label("Height (cm):");
		TextField heightField = new TextField();
		heightLabel.relocate(20, 90);
		heightLabel.setStyle(labelStyle);
		heightField.relocate(150, 90);
		heightField.setStyle(fieldStyle);

		// Age input
		Label ageLabel = new Label("Age (years):");
		TextField ageField = new TextField();
		ageLabel.relocate(20, 130);
		ageLabel.setStyle(labelStyle);
		ageField.relocate(150, 130);
		ageField.setStyle(fieldStyle);

		// Gender selection using radio buttons grouped together
		ToggleGroup genderGroup = new ToggleGroup();
		RadioButton maleButton = new RadioButton("Male");
		maleButton.setToggleGroup(genderGroup);
		maleButton.relocate(150, 160);
		RadioButton femaleButton = new RadioButton("Female");
		femaleButton.setToggleGroup(genderGroup);
		femaleButton.relocate(220, 160);

		// Activity level selection using a combo box (drop-down menu)
		Label activityLabel = new Label("Activity Level:");
		ComboBox<String> activityComboBox = new ComboBox<>();
		activityComboBox.getItems().addAll("Little or no exercise", "Light exercise (1-3 days per week)",
				"Moderate exercise (3-5 days per week)", "Hard exercise (6-7 days per week)", "Athlete-level training");
		activityLabel.relocate(20, 180);
		activityLabel.setStyle(labelStyle);
		activityComboBox.relocate(150, 180);
		activityComboBox.setStyle(fieldStyle);

		// Button to trigger calculation and label to display result
		Button calculateButton = new Button("Calculate");
		Label resultLabel = new Label();
		calculateButton.relocate(150, 250);
		calculateButton.setPrefSize(80, 30);
		calculateButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
		resultLabel.relocate(150, 220);

		// Event handling for Calculate button
		calculateButton.setOnAction(e -> {
			try {
				// Read and parse inputs
				double weight = Double.parseDouble(weightField.getText());
				double height = Double.parseDouble(heightField.getText());
				int age = Integer.parseInt(ageField.getText());

				// Check if a gender option has been selected
				if (!maleButton.isSelected() && !femaleButton.isSelected()) {
					resultLabel.setText("Please select gender.");
					return;
				}

				// Calculate BMR using the Mifflin-St Jeor Equation
				double BMR;
				if (maleButton.isSelected()) {
					BMR = 10 * weight + 6.25 * height - 5 * age + 5;
				} else {
					BMR = 10 * weight + 6.25 * height - 5 * age - 161;
				}

				// Apply activity multiplier to calculate TDEE
				double multiplier = 1.2; // default for "Little or no exercise"
				switch (activityComboBox.getValue()) {
				case "Light exercise (1-3 days per week)":
					multiplier = 1.375;
					break;
				case "Moderate exercise (3-5 days per week)":
					multiplier = 1.55;
					break;
				case "Hard exercise (6-7 days per week)":
					multiplier = 1.725;
					break;
				case "Athlete-level training":
					multiplier = 1.9;
					break;
				}

				// Final calculation and display of results
				double TDEE = BMR * multiplier;
				resultLabel.setText(String.format("BMR: %.2f, TDEE: %.2f", BMR, TDEE));
			} catch (NumberFormatException ex) {
				resultLabel.setText("Invalid input. Please enter valid numbers.");
			}
		});

		// Close button to terminate the application
		Button closeButton = new Button("Close");
		closeButton.relocate(300, 250);
		closeButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
		closeButton.setPrefSize(80, 30);
		closeButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				primaryStage.close(); // Close the application window
			}
		}));

		// Add all UI components to the pane
		pane.getChildren().addAll(titleLabel, weightLabel, weightField, heightLabel, heightField, ageLabel, ageField,
				maleButton, femaleButton, activityLabel, activityComboBox, calculateButton, closeButton, resultLabel);

		// Set window title and scene, then show the primary stage
		primaryStage.setTitle("Calories Calculator");
		Scene scene = new Scene(pane, 450, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	// Main method to launch the application
	public static void main(String[] args) {
		launch(args);
	}
}