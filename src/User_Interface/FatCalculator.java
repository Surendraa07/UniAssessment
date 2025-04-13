package User_Interface;

// Import necessary JavaFX classes for building the GUI
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FatCalculator extends Application {

	@Override
	public void start(Stage primaryStage) {
		// Define consistent CSS styles for label, text field, and combo box
		String labelStyle = "-fx-background-color: #6B7755; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 5px 10px; -fx-background-radius: 10;";
		String fieldStyle = "-fx-background-color: #C0C9B5; -fx-background-radius: 10;";
		String ComboBoxStyle = "-fx-background-color: #C0C9B5; -fx-background-radius: 10;"; // Declared but unused

		// Create and format the window title label
		Label titleLabel = new Label("Fat Calculator");
		titleLabel.relocate(150, 20);
		titleLabel.setFont(new Font("Arial", 25));

		// Create a layout pane to hold all components
		Pane pane = new Pane();

		// Input: Total calories (TDEE)
		Label caloriesLabel = new Label("Total Calories (TDEE):");
		TextField caloriesField = new TextField();
		caloriesLabel.relocate(10, 70);
		caloriesLabel.setStyle(labelStyle);
		caloriesField.relocate(170, 70);
		caloriesField.setStyle(fieldStyle);

		// Dropdown: User's fat intake goal based on dietary objective
		Label fatLabel = new Label("Fat Percentage:");
		ComboBox<String> fatComboBox = new ComboBox<>();
		fatComboBox.getItems().addAll(
			"General health (20-35%)",
			"Weight loss (15-25%)",
			"Athlete performance (25-35%)"
		);
		fatLabel.relocate(37, 140);
		fatLabel.setStyle(labelStyle);
		fatComboBox.relocate(170, 140);
		fatComboBox.setStyle(fieldStyle);

		// Create a button to trigger calculation and a label to display results
		Button calculateButton = new Button("Calculate");
		Label resultLabel = new Label();
		calculateButton.relocate(20, 190);
		calculateButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
		resultLabel.relocate(150, 190);

		calculateButton.setOnAction(e -> {
			try {
				double calories = Double.parseDouble(caloriesField.getText());

				double fatPercentage = 0.2; // Default to weight-loss value
				String selectedOption = fatComboBox.getValue();
				if (selectedOption != null) {
					switch (selectedOption) {
						case "General health (20-35%)":
							fatPercentage = 0.275;
							break;
						case "Weight loss (15-25%)":
							fatPercentage = 0.2;
							break;
						case "Athlete performance (25-35%)":
							fatPercentage = 0.3;
							break;
					}
				}

				// Perform fat intake calculation: 1 gram of fat = 9 kcal
				double fatIntake = (calories * fatPercentage) / 9;

				// Display the result formatted to two decimal places
				resultLabel.setText(String.format("Fat Intake: %.2f grams/day", fatIntake));
			} catch (NumberFormatException ex) {
				// Handle non-numeric or invalid input
				resultLabel.setText("Invalid input. Enter a valid number.");
			}
		});

		// Create a "Close" button to exit the application window
		Button closeButton = new Button("Close");
		closeButton.relocate(300, 190);
		closeButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
		closeButton.setPrefSize(80, 20);
		closeButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				primaryStage.close();
			}
		}));

		// Add all UI elements to the pane
		pane.getChildren().addAll(titleLabel,caloriesLabel, caloriesField,fatLabel, fatComboBox,calculateButton, closeButton,resultLabel);

		// Finalize and show the application window
		primaryStage.setTitle("Fat Intake Calculator");
		Scene scene = new Scene(pane, 500, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}