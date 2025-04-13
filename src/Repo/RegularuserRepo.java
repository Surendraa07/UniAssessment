package Repo;

import java.sql.PreparedStatement;

import Interfaces.InfUserCRUD;
import myLibs.Mydatabase;
import myLibs.RegularUserModules;
import myLibs.TrainerModules;
import myLibs.UserDetailsModules;
import myLibs.UserModules;

public class RegularuserRepo extends Mydatabase implements InfUserCRUD{
	// Method to insert 
	@Override
	public boolean Insert(RegularUserModules regularUserModules) {
		boolean result = false;
		PreparedStatement pStat;
		String sql = "INSERT INTO Regularuser(AnnualGoal, AnnualSchedule) VALUE (?,?);";

		try {
			pStat = connect().prepareStatement(sql);
			
			pStat.setString(1,regularUserModules.getAnnualGoal());
			pStat.setString(2,regularUserModules.getAnnualSchedule());
			
			pStat.executeUpdate();
			pStat.close();
			result = true;
			
		}catch(Exception ex) {
			System.out.println("Error : " +ex.getMessage());
		}
		
		return result ;
	
	}

	@Override
	public boolean Insert(UserDetailsModules userDetailsModules) {
		return false;
	}

	@Override
	public boolean Insert(UserModules userModule) {
		return false;
	}

	@Override
	public boolean Insert(TrainerModules trainerModules) {
		return false;
	}
}
