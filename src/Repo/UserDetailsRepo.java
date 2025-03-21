package Repo;

import java.sql.PreparedStatement;

import Interfaces.InfUserCRUD;
import myLibs.Mydatabase;
import myLibs.RegularUserModules;
import myLibs.UserDetailsModules;
import myLibs.UserModules;

public class UserDetailsRepo extends Mydatabase implements InfUserCRUD{
	@Override
	public boolean Insert(UserDetailsModules userDetailsModules) {
		boolean result = false;
		PreparedStatement pStat;
		String sql = "INSERT INTO UserDetails (Name, Age, Weight, Height) VALUES (?,?,?,?);";

		try {
			//Connection with Database
			pStat = connect().prepareStatement(sql);
			pStat.setString(1,userDetailsModules.getName());
			pStat.setInt(2,userDetailsModules.getAge());
			pStat.setString(3,userDetailsModules.getWeight());
			pStat.setString(4,userDetailsModules.getHeight());
			
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

}
