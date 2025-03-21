package myLibs;

public class UserDetailsModules {
	private String name;
	private int age;
	private String weight;
	private String height;
	
	//Parameterized Constructor
	public UserDetailsModules(String name, int age, String weight, String height) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.height = height;
	}
	
	//Default Constructor
	public UserDetailsModules() {
		this.name = "";
		this.age = 0;
		this.weight = "";
		this.height = "";
	}
	
	//Copy Constructor
	public UserDetailsModules(UserDetailsModules userDetailsModules) {
		this.name = userDetailsModules.name;
		this.age = userDetailsModules.age;
		this.weight = userDetailsModules.weight;
		this.height = userDetailsModules.height;
	}
	
	//Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;

	}
}
