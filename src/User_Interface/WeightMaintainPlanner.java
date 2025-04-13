package User_Interface;

// Import necessary JavaFX classes
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class WeightMaintainPlanner extends Application {

	@Override
	public void start(Stage primaryStage) {
		// Define CSS styles for consistent design
		String labelStyle = "-fx-background-color: #6B7755; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 5px 10px; -fx-background-radius: 10;";
		String fieldStyle = "-fx-background-color: #C0C9B5; -fx-background-radius: 10;";
		String ComboBoxStyle = "-fx-background-color: #C0C9B5; -fx-background-radius: 10;"; // Not used in this example

		// Create a title label
		Label titleLabel = new Label("Weight Maintain Planner");
		titleLabel.relocate(100, 20);
		Font font1 = new Font("Arial", 25);
		titleLabel.setFont(font1);

		// Use a Pane layout to manually position UI components
		Pane pane = new Pane();

		// Label and TextField for user
		Label tdeeLabel = new Label("TDEE (kcal)");
		TextField tdeeField = new TextField();
		tdeeField.setPromptText("Enter TDEE (kcal)"); 
		tdeeField.setStyle("-fx-font-size: 14px; -fx-background-color: #A3B49E;"); 
		tdeeLabel.setStyle(labelStyle);
		tdeeLabel.relocate(50, 80);
		tdeeField.relocate(150, 80);
		tdeeField.setStyle(fieldStyle);

		// Label to display result of calculation
		Label resultLabel = new Label();
		resultLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
		resultLabel.relocate(150, 130);

		// Button that performs the calculation when clicked
		Button calculateButton = new Button("Calculate");
		calculateButton.relocate(100, 180);
		calculateButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");

		// Event handler for the Calculate button
		calculateButton.setOnAction(e -> {
			try {
				double tdee = Double.parseDouble(tdeeField.getText());
				double weightMaintainCalories = tdee;
				resultLabel.setText("Weight Maintain Calories: " + weightMaintainCalories + " kcal/day");
			} catch (NumberFormatException ex) {
				resultLabel.setText("Invalid input! Please enter a number.");
			}
		});

		// Button to close the application
		Button closeButton = new Button("Close");
		closeButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
		closeButton.relocate(300, 180);
		closeButton.setPrefSize(80, 20);

		// Event handler to close the window
		closeButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				primaryStage.close(); 			}
		}));

		// Add all UI elements to the pane layout
		pane.getChildren().addAll(titleLabel, tdeeLabel, tdeeField, resultLabel, calculateButton, closeButton);

		// Set the window title and scene, then show the stage
		primaryStage.setTitle("Weight Maintain Planner");
		Scene scene = new Scene(pane, 480, 250); 
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	 // Main method 
	public static void main(String[] args) {
		launch(args); 
	}
}