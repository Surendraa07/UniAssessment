package User_Interface;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Trainer extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		//Fonts
		Font font1 = new Font("Arial", 25);
		Font font2 = new Font("Arial", 18);
		
		//Declare And Initialize
		// Title Label
        Label titleLabel = new Label("Trainer");
        titleLabel.relocate(170, 20);
        titleLabel.setFont(font1);
        
		Label userWorkoutSplitLabel = new Label("User Workout Split");
		userWorkoutSplitLabel.setFont(font2);
        ComboBox<String> userWorkoutSplitComboBox = new ComboBox<>();
        userWorkoutSplitComboBox.getItems().addAll("Full-Body", "Upper-Lower", "Push-Pull-Legs", "Muscle Group");
        userWorkoutSplitLabel.relocate(35, 50);
        userWorkoutSplitComboBox.relocate(220, 50);
        
        Label userWorkoutPlannerLabel = new Label("User workout Planner");
        userWorkoutPlannerLabel.setFont(font2);
        ComboBox<String> userWorkoutPlannerComboBox = new ComboBox<>();
        userWorkoutPlannerComboBox.getItems().addAll("Weight Loss", "Weight Gain", "Weight Maintain");
        userWorkoutPlannerLabel.relocate(35, 100);
        userWorkoutPlannerComboBox.relocate(220, 100);
        
        // Buttons
        Button btnSubmit = new Button("Submit");
        btnSubmit.relocate(150, 150);
        btnSubmit.setPrefSize(80, 30);
        
        Button btnClose = new Button("Close");  
        btnClose.relocate(250, 150);
        btnClose.setPrefSize(80, 30);
		btnClose.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				primaryStage.close();
			}
		}));
        
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 400, 250);
        primaryStage.setTitle("Trainer Form");
        primaryStage.setScene(scene);
        pane.getChildren().addAll(titleLabel, userWorkoutSplitLabel,userWorkoutSplitComboBox,userWorkoutPlannerLabel,userWorkoutPlannerComboBox, btnSubmit,btnClose);
        //Display Window
        primaryStage.show();
	}
	public static void main(String[]args) {
		launch(args);
	}
}
