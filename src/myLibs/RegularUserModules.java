package myLibs;

public class RegularUserModules {
	private String annualGoal;
	private String annualSchedule;
	private String benefits;

	//Parameterized Constructor
	public RegularUserModules(String annualGoal, String annualSchedule, String benefits) {
		this.annualGoal = annualGoal;
		this.annualSchedule = annualSchedule;
		this.benefits = benefits;
	}
	//Default Constructor
	public RegularUserModules() {		
			this.annualGoal = "";
			this.annualSchedule = "";
			this.benefits = "";
	}
	//Copy Constructor
	public RegularUserModules(RegularUserModules regularUserModules) {
		this.annualGoal = regularUserModules.annualGoal;
		this.annualSchedule = regularUserModules.annualSchedule;
		this.benefits = regularUserModules.benefits;
	}

	//Setters and Getters
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

	public String getBenefits() {
		return benefits;
	}

	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}



}
