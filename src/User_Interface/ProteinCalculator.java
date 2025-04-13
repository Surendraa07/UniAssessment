package User_Interface;

// Import necessary JavaFX classes for building the UI
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ProteinCalculator extends Application {

	@Override
	public void start(Stage primaryStage) {
		// Define CSS styles for consistent UI appearance
		String labelStyle = "-fx-background-color: #6B7755; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 5px 10px; -fx-background-radius: 10;";
		String fieldStyle = "-fx-background-color: #C0C9B5; -fx-background-radius: 10;";
		String ComboBoxStyle = "-fx-background-color: #C0C9B5; -fx-background-radius: 10;";  // Unused in this version

		// Create and style the title label
		Label titleLabel = new Label("Protein Calculator");
		titleLabel.relocate(150, 20);
		titleLabel.setFont(new Font("Arial", 25));

		// Root pane for layout
		Pane pane = new Pane();

		// Create and position weight input label and field
		Label weightLabel = new Label("Weight (kg):");
		TextField weightField = new TextField();
		weightLabel.relocate(20, 70);
		weightLabel.setStyle(labelStyle);
		weightField.relocate(150, 70);
		weightField.setStyle(fieldStyle);

		// Create and configure the activity level selection combo box
		Label activityLabel = new Label("Activity Level:");
		ComboBox<String> activityComboBox = new ComboBox<>();
		activityComboBox.getItems().addAll(
			"Sedentary (little or no exercise)",
			"Light Activity (1-3 days per week)",
			"Moderate Activity (3-5 days per week)",
			"High Activity (6-7 days per week)",
			"Athlete/Bodybuilding"
		);
		activityLabel.relocate(20, 140);
		activityLabel.setStyle(labelStyle);
		activityComboBox.relocate(150, 140);
		activityComboBox.setStyle(fieldStyle);

		// Create calculate button and result label
		Button calculateButton = new Button("Calculate");
		Label resultLabel = new Label();
		calculateButton.relocate(20, 190);
		calculateButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
		resultLabel.relocate(150, 190);  

		// Handle button click to calculate protein intake
		calculateButton.setOnAction(e -> {
			try {
				double weight = Double.parseDouble(weightField.getText());

				if (activityComboBox.getValue() == null) {
					resultLabel.setText("Please select an activity level.");
					return;
				}

				double proteinFactor = 0.8;  // Default for sedentary
				switch (activityComboBox.getValue()) {
					case "Light Activity (1-3 days per week)":
						proteinFactor = 1.2;
						break;
					case "Moderate Activity (3-5 days per week)":
						proteinFactor = 1.5;
						break;
					case "High Activity (6-7 days per week)":
						proteinFactor = 1.8;
						break;
					case "Athlete/Bodybuilding":
						proteinFactor = 2.2;
						break;
				}

				// Calculate protein intake and display result
				double proteinIntake = weight * proteinFactor;
				resultLabel.setText(String.format("Protein Intake: %.2f g/day", proteinIntake));
			} catch (NumberFormatException ex) {
				resultLabel.setText("Invalid input. Please enter a valid weight.");
			}
		});

		// Create a close button to exit the window
		Button closeButton = new Button("Close");
		closeButton.relocate(300, 190);
		closeButton.setPrefSize(80, 20);
		closeButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
		closeButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				primaryStage.close();  
			}
		});

		// Add all components to the pane
		pane.getChildren().addAll(titleLabel,weightLabel, weightField,activityLabel, activityComboBox,calculateButton, resultLabel,closeButton);

		// Set up the scene and stage
		primaryStage.setTitle("Protein Intake Calculator");
		Scene scene = new Scene(pane, 500, 300);
		primaryStage.setScene(scene);
		primaryStage.show();  
	}

	public static void main(String[] args) {
		launch(args);
	}
}