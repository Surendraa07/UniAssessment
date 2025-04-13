package User_Interface;

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

public class WeightLoosePlanner extends Application {

    @Override
    public void start(Stage primaryStage) {
     // Labels and Input Fields
     		String labelStyle = "-fx-background-color: #6B7755; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 5px 10px; -fx-background-radius: 10;";
     		String fieldStyle = "-fx-background-color: #C0C9B5; -fx-background-radius: 10;";
     		String ComboBoxStyle = "-fx-background-color: #C0C9B5; -fx-background-radius: 10;";
     		
     		Label titleLabel = new Label("Weight loose planner");
    		titleLabel.relocate(150, 20);
    		Font font1 = new Font("Arial", 25);
    		titleLabel.setFont(font1);
    		Pane pane = new Pane();  

        // TDEE Input
        Label tdeeLabel = new Label("TDEE(kcal)");
        TextField tdeeField = new TextField();
        tdeeField.setPromptText("Enter TDEE (kcal)");
        tdeeField.setStyle("-fx-font-size: 14px; -fx-background-color: #A3B49E;");
        tdeeLabel.relocate(50, 80);
        tdeeLabel.setStyle(labelStyle);
        tdeeField.relocate(150, 80);
        tdeeField.setStyle(fieldStyle);
        // Result Label
        Label resultLabel = new Label();
        resultLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        resultLabel.relocate(150, 130);

        // Buttons
        Button calculateButton = new Button("Calculate");
        calculateButton.relocate(100, 180);
        calculateButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");

        // Calculate Action
        calculateButton.setOnAction(e -> {
            try {
                double tdee = Double.parseDouble(tdeeField.getText());
                double weightLooseCalories = tdee - 500;
                resultLabel.setText("Weight Loose Calories: " + weightLooseCalories + " kcal/day");
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input! Please enter a number.");
            }
        });

        // Close Action

		Button closeButton = new Button("Close");
		closeButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
		closeButton.relocate(300, 180);
		closeButton.setPrefSize(80, 20);
		closeButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				primaryStage.close();
			}
		}));
        // Adding elements to the pane
        pane.getChildren().addAll(titleLabel, tdeeLabel, tdeeField, resultLabel, calculateButton, closeButton);
        primaryStage.setTitle("Weight Loose Planner");
        Scene scene = new Scene(pane, 480, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}