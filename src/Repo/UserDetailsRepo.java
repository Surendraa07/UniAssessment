package Repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Interfaces.InfUserCRUD;
import myLibs.Mydatabase;
import myLibs.RegularUserModules;
import myLibs.TrainerModules;
import myLibs.UserDetailsModules;
import myLibs.UserModules;


public class UserDetailsRepo extends Mydatabase implements InfUserCRUD{
	// Method to insert userdetails
	@Override
	public boolean Insert(UserDetailsModules userDetailsModules) {
		boolean result = false;
		PreparedStatement pStat;
		String sql = "INSERT INTO UserDetails (UID ,Name, Age, Weight ,Height) VALUE (?,?,?,?,?);";
		try {
			pStat = connect().prepareStatement(sql);
			pStat.setInt(1,userDetailsModules.getUid());
			pStat.setString(2,userDetailsModules.getName());
			pStat.setInt(3,userDetailsModules.getAge());
			pStat.setString(4,userDetailsModules.getWeight());
			pStat.setString(5,userDetailsModules.getHeight());
			
			pStat.executeUpdate();
			pStat.close();
			result = true;
			
		}catch(Exception ex) {
			System.out.println("Error : " +ex.getMessage());
		}
		
		return result ;
		
	}
	
	@Override
	public boolean Insert(UserModules userModule) {
		return false;
	}
	@Override
	public boolean Insert(RegularUserModules regularUserModules) {
		return false;
	}
	@Override
	public boolean Insert(TrainerModules trainerModules) {
		return false;
	}
	 // Method to search user by UID
    public UserDetailsModules searchByUID(int uid) {
        UserDetailsModules userDetails = null;
        PreparedStatement pStat;
        ResultSet resultSet;
        String sql = "SELECT * FROM UserDetails WHERE UID = ?";
        
        try {
            pStat = connect().prepareStatement(sql);
            pStat.setInt(1, uid);
            resultSet = pStat.executeQuery();
            
            if (resultSet.next()) {
                userDetails = new UserDetailsModules();
                userDetails.setUid(resultSet.getInt("UID"));
                userDetails.setName(resultSet.getString("Name"));
                userDetails.setAge(resultSet.getInt("Age"));
                userDetails.setWeight(resultSet.getString("Weight"));
                userDetails.setHeight(resultSet.getString("Height"));
            }
            
            pStat.close();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        
        return userDetails;
    }

    // Update (Edit) method
    public boolean update(UserDetailsModules userDetailsModules) {
        boolean result = false;
        PreparedStatement pStat;
        String sql = "UPDATE UserDetails SET Name = ?, Age = ?, Weight = ?, Height = ? WHERE UID = ?";

        try {
            pStat = connect().prepareStatement(sql);
            pStat.setString(1, userDetailsModules.getName());
            pStat.setInt(2, userDetailsModules.getAge());
            pStat.setString(3, userDetailsModules.getWeight());
            pStat.setString(4, userDetailsModules.getHeight());
            pStat.setInt(5, userDetailsModules.getUid());

            int rowsUpdated = pStat.executeUpdate();
            pStat.close();
            
            if (rowsUpdated > 0) {
                result = true;  // Successfully updated
            }
        } catch (Exception ex) {
            System.out.println("Error during update: " + ex.getMessage());
        }

        return result;
    }

    // Delete method by UID
    public boolean deleteByUid(int uid) {
        boolean result = false;
        PreparedStatement pStat;
        String sql = "DELETE FROM UserDetails WHERE UID = ?";

        try {
            pStat = connect().prepareStatement(sql);
            pStat.setInt(1, uid);

            int rowsDeleted = pStat.executeUpdate();
            pStat.close();

            if (rowsDeleted > 0) {
                result = true;  // Successfully deleted
            }
        } catch (Exception ex) {
            System.out.println("Error during deletion: " + ex.getMessage());
        }

        return result;
    }

}
