package User_Interface;

import Repo.RegularuserRepo;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import myLibs.RegularUserModules;

public class RegularUser extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        //Declare And Initialize
        Font font1 = new Font("Arial", 25);
		Font font2 = new Font("Arial", 18);
		
        Label titleLabel = new Label("Regular Users");
        titleLabel.relocate(150, 20);
        titleLabel.setFont(font1);
        
        Label goalLabel = new Label("Annual Goal");
        goalLabel.relocate(50, 70);
        TextField goalField = new TextField();
        goalField.relocate(180, 70);
        goalLabel.setFont(font2);
        
        Label scheduleLabel = new Label("Annual Schedule");
        scheduleLabel.relocate(40, 110);
        TextField scheduleField = new TextField();
        scheduleField.relocate(180, 110);
        scheduleLabel.setFont(font2);
        
        Label benefitsLabel = new Label("Benefits");
        benefitsLabel.relocate(50, 150);
        TextField benefitsField = new TextField();
        benefitsField.relocate(180, 150);
        benefitsLabel.setFont(font2);
        
        Label calculateLabel = new Label("Calculate");
        calculateLabel.relocate(50, 190);
        calculateLabel.setFont(font2);
        
        //Combobox
        ComboBox<String> calculateBox = new ComboBox<>();
        calculateBox.getItems().addAll("Calories", "Protein", "Fat");
        calculateBox.relocate(180, 190);
        
        //Buttons
        Button submitButton = new Button("Submit");
        submitButton.relocate(100, 240);
        submitButton.setPrefSize(80, 30);
        submitButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent actionEvent) {
				RegularUserModules regularUserModules = new RegularUserModules();
				
				
				regularUserModules.setAnnualGoal(goalField.getText());
				regularUserModules.setAnnualSchedule(scheduleField.getText());
				regularUserModules.setBenefits(benefitsField.getText());
				boolean result = new RegularuserRepo().Insert(regularUserModules);
			}
		});
        
        Button closeButton = new Button("Close");
        closeButton.relocate(200, 240);
        closeButton.setPrefSize(80, 30);
        closeButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				primaryStage.close();
			}
		}));
        
        //Add controls
        pane.getChildren().addAll(titleLabel, goalLabel, goalField, scheduleLabel, scheduleField, 
                                  benefitsLabel, benefitsField, calculateLabel, calculateBox, 
                                  submitButton, closeButton);

        Scene scene = new Scene(pane, 400, 300);
        primaryStage.setTitle("Regular Users Form");
        primaryStage.setScene(scene);
        //Display Window
        primaryStage.show();
        
        //asdas
    }

    public static void main(String[] args) {
        launch(args);
    }


}
