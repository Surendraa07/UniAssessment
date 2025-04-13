package myLibs;

public class UserDetailsModules {
	private int uid;
	private String name;
	private int age;
	private String weight;
	private String height;
	public UserDetailsModules(int uid, String name, int age, String weight, String height) {//Parameterized constructor
		super();
		this.uid = uid;
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.height = height;
	}
	public UserDetailsModules() {//default constructor
		super();
		this.uid = 0;
		this.name = "";
		this.age = 0;
		this.weight = "";
		this.height = "";
	}
	public UserDetailsModules(UserDetailsModules userDetailsModules) {// copy constructor
		super();
		this.uid =userDetailsModules.uid;
		this.name =userDetailsModules.name;
		this.age = userDetailsModules.age;
		this.weight = userDetailsModules.weight;
		this.height = userDetailsModules.height;
	}
	//getters and setters
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
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

