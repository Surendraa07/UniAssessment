package myLibs;

public class TrainerModules {
	//Fields to store
    private String UserWorkoutSplit;
    private String UserWeightPlanner;

    public TrainerModules(String userWorkoutSplit, String userWeightPlanner) { //Parameterized constructor
        UserWorkoutSplit = userWorkoutSplit;
        UserWeightPlanner = userWeightPlanner;
    }

    public TrainerModules() {// default constructor
        UserWorkoutSplit = "";
        UserWeightPlanner = "";
    }
    //getters and setters
    public String getUserWorkoutSplit() {
        return UserWorkoutSplit;
    }

    public void setUserWorkoutSplit(String userWorkoutSplit) {
        UserWorkoutSplit = userWorkoutSplit;
    }

    public String getUserWeightPlanner() {
        return UserWeightPlanner;
    }

    public void setUserWeightPlanner(String userWeightPlanner) {
        UserWeightPlanner = userWeightPlanner;
    }
}