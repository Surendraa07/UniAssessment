package myLibs;

import java.sql.Connection;
import java.sql.DriverManager;

public class Mydatabase {
	final private String HOST = "localhost";
	final private String USER = "root";
	final private String PASS = "Surendra19";
	final private int PORT = 3306;
	final private String DBNAME = "Health_Fitness";
	final private String DRIVER = "com.mysql.cj.jdbc.Driver";
	final private String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DBNAME;

	private Connection conn = null;

	// Connect with database
	public Connection connect() {
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
		return conn;
	}

	// Close the connection
	public void close() {
		try {
			if (!this.conn.isClosed()) {
				this.conn.close();
			}
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
	}
}
