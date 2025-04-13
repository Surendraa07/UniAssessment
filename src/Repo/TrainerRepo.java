package Repo;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Interfaces.InfUserCRUD;
import myLibs.Mydatabase;
import myLibs.RegularUserModules;
import myLibs.TrainerModules;
import myLibs.UserDetailsModules;
import myLibs.UserModules;

public class TrainerRepo extends Mydatabase implements InfUserCRUD{
	   @Override
	    public boolean Insert(TrainerModules trainerModules) {
	        boolean result = false;
	        String sql = "INSERT INTO Trainer(UserWorkoutSplit, UserWeightPlanner) VALUES (?, ?);"; // Table name updated

	        try (Connection conn = connect(); PreparedStatement pStat = conn.prepareStatement(sql)) {
	            // Get values from TrainerModules
	            String workoutSplit = trainerModules.getUserWorkoutSplit();
	            String weightPlanner = trainerModules.getUserWeightPlanner();

	            if (workoutSplit != null && weightPlanner != null) {
	                pStat.setString(1, workoutSplit);
	                pStat.setString(2, weightPlanner);
	                pStat.executeUpdate();
	                result = true;
	            } else {
	                System.out.println("Error: ComboBox values are null.");
	            }
	        } catch (Exception ex) {
	            System.out.println("Error inserting trainer data: " + ex.getMessage());
	        }

	        return result;
	    }

    @Override
    public boolean Insert(UserModules userModule) {
        return false;
    }

    @Override
    public boolean Insert(UserDetailsModules userDetailsModules) {
        return false;
    }

    @Override
    public boolean Insert(RegularUserModules regularUserModules) {
        return false;
    }



}