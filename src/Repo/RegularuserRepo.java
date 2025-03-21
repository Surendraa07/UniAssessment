package Repo;

import java.sql.PreparedStatement;

import Interfaces.InfUserCRUD;
import myLibs.Mydatabase;
import myLibs.RegularUserModules;
import myLibs.UserDetailsModules;
import myLibs.UserModules;

public class RegularuserRepo  extends Mydatabase implements InfUserCRUD{

	@Override
	public boolean Insert(RegularUserModules regularUserModules) {
		boolean result = false;
		PreparedStatement pStat;
		String sql = "INSERT INTO Regularuser(AnnualGoal, AnnualSchedule, Benefits) VALUE (?, ?,?);";

		try {
			//Connection with Database
			pStat = connect().prepareStatement(sql);		
			pStat.setString(1,regularUserModules.getAnnualGoal());
			pStat.setString(2,regularUserModules.getAnnualSchedule());
			pStat.setString(3,regularUserModules.getBenefits());
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

}
