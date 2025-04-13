package myLibs;

public class UserModules {
	// fields to store
	private int userId;
	private String password;

	public UserModules(int userId, String password) {//Parameterized constructor
		this.userId = userId;
		this.password = password;
	}

	public UserModules() {//Default constructor

		this.userId = 0;
		this.password = "";
	}

	public UserModules(UserModules userModules) {//Copy constructor

		this.userId = userModules.userId;
		this.password = userModules.password;
	}
	//getters and setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
