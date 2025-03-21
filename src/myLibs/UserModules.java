package myLibs;

public class UserModules {
	private int userId;
	private String password;

	//Constructors, Setters, Getter, and toString
	
	//Default Constructor
	public UserModules(int userId, String password) {
		this.userId = userId;
		this.password = password;
	}
	
	//Parameterized Constructor
	public UserModules() {
		this.userId = 0;
		this.password = "";
	}

	//Copy Constructor
	public UserModules(UserModules userModules) {
		this.userId = userModules.userId;
		this.password = userModules.password;
	}

	//Getters
	public int getUserId() {
		return userId;
	}

	//Setters
	public void setUserId(int userId) {
		this.userId = userId;
	}

	//Getters
	public String getPassword() {
		return password;
	}

	//Setters
	public void setPassword(String password) {
		this.password = password;
	}

	
}