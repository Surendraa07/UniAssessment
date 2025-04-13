package User_interface;

import Repo.TrainerRepo;
import javafx.application.Application;
import javafx.stage.Stage;
import myLibs.TrainerModules;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class Trainer extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Fonts
        Font font1 = new Font("Arial", 25);
        Font font2 = new Font("Arial", 18);

        // Styles
        String labelStyle = "-fx-background-color: #6B7755; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 5px 10px; -fx-background-radius: 10;";
        String comboBoxStyle = "-fx-background-color: #C0C9B5; -fx-background-radius: 10;";

        // Title Label
        Label titleLabel = new Label("Trainer");
        titleLabel.relocate(170, 20);
        titleLabel.setFont(font1);

        // Workout Split Label & ComboBox
        Label userWorkoutSplitLabel = new Label("User Workout Split");
        userWorkoutSplitLabel.setFont(font2);
        userWorkoutSplitLabel.relocate(35, 50);
        userWorkoutSplitLabel.setStyle(labelStyle);

        ComboBox<String> userWorkoutSplitComboBox = new ComboBox<>();
        userWorkoutSplitComboBox.getItems().addAll("Full-Body", "Upper-Lower", "Push-Pull-Legs", "Muscle Group");
        userWorkoutSplitComboBox.relocate(240, 50);
        userWorkoutSplitComboBox.setStyle(comboBoxStyle);

        // Workout Planner Label & ComboBox
        Label userWorkoutPlannerLabel = new Label("User Weight Planner");
        userWorkoutPlannerLabel.setFont(font2);
        userWorkoutPlannerLabel.relocate(20, 100);
        userWorkoutPlannerLabel.setStyle(labelStyle);

        ComboBox<String> userWorkoutPlannerComboBox = new ComboBox<>();
        userWorkoutPlannerComboBox.getItems().addAll("Weight Loss", "Weight Gain", "Weight Maintain");
        userWorkoutPlannerComboBox.relocate(240, 100);
        userWorkoutPlannerComboBox.setStyle(comboBoxStyle);

        // Buttons
        Button btnSubmit = new Button("Submit");
        btnSubmit.relocate(150, 150);
        btnSubmit.setPrefSize(80, 30);
        btnSubmit.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        btnSubmit.setOnAction(event -> {
            // Get selected values from ComboBoxes
            String selectedWorkoutSplit = userWorkoutSplitComboBox.getValue();
            String selectedWeightPlan = userWorkoutPlannerComboBox.getValue();

            if (selectedWorkoutSplit != null && selectedWeightPlan != null) {
                // Create a TrainerModules object with the selected values
                TrainerModules trainerModules = new TrainerModules(selectedWorkoutSplit, selectedWeightPlan);

                // Insert the data into the database
                TrainerRepo trainerRepo = new TrainerRepo();
                boolean result = trainerRepo.Insert(trainerModules);
                if (result) {
                    System.out.println("Data inserted successfully.");
                } else {
                    System.out.println("Failed to insert data.");
                }

                // Optional: open planner stage based on selection
                Stage newStage = new Stage();
                try {
                    switch (selectedWeightPlan) {
                        case "Weight Loss":
                            new WeightLoosePlanner().start(newStage);
                            break;
                        case "Weight Gain":
                            new WeightGainPlanner().start(newStage);
                            break;
                        case "Weight Maintain":
                            new WeightMaintainPlanner().start(newStage);
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Please select both workout split and weight plan.");
            }
        });

        Button btnClose = new Button("Close");
        btnClose.relocate(250, 150);
        btnClose.setPrefSize(80, 30);
        btnClose.setStyle("-fx-background-color: black; -fx-text-fill: white;");

        btnClose.setOnAction(event -> primaryStage.close());

        Pane pane = new Pane();
        Scene scene = new Scene(pane, 400, 250);
        primaryStage.setTitle("Trainer Form");
        primaryStage.setScene(scene);
        pane.getChildren().addAll(titleLabel, userWorkoutSplitLabel, userWorkoutSplitComboBox, userWorkoutPlannerLabel,
                userWorkoutPlannerComboBox, btnSubmit, btnClose);

        // Display Window
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

