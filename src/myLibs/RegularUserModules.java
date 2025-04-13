package myLibs;

public class RegularUserModules {
	//fields to store
	private String annualGoal;
	private String annualSchedule;

	public RegularUserModules(String annualGoal, String annualSchedule) {//Parameterized constructor

		this.annualGoal = annualGoal;
		this.annualSchedule = annualSchedule;
	}

	public RegularUserModules() {//Default constructor

		this.annualGoal = "";
		this.annualSchedule = "";
	}

	public RegularUserModules(RegularUserModules regularUserModules) {//Copy Constructor

		this.annualGoal = regularUserModules.annualGoal;
		this.annualSchedule = regularUserModules.annualSchedule;
	}
	//getters and setters
	public String getAnnualGoal() {
		return annualGoal;
	}

	public void setAnnualGoal(String annualGoal) {
		this.annualGoal = annualGoal;
	}

	public String getAnnualSchedule() {
		return annualSchedule;
	}

	public void setAnnualSchedule(String annualSchedule) {
		this.annualSchedule = annualSchedule;
	}

}
