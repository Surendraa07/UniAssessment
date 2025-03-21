package Repo;

import java.sql.PreparedStatement;
import Interfaces.InfUserCRUD;
import myLibs.Mydatabase;
import myLibs.RegularUserModules;
import myLibs.UserDetailsModules;
import myLibs.UserModules;

public class UsersRepo extends Mydatabase implements InfUserCRUD {

	@Override
	public boolean Insert(UserModules userModules) {
		boolean result = false;
		PreparedStatement pStat;
		String sql = "INSERT INTO Users (UserId, Password) VALUE (?, ?);"; //Insert

		try {
			//Connection with Database
			pStat = connect().prepareStatement(sql);

			pStat.setInt(1, userModules.getUserId());
			pStat.setString(2, userModules.getPassword());

			pStat.executeUpdate();
			pStat.close();
			result = true;

		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}

		return result;
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
