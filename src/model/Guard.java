package model;

	// Main Author: Quinn O'Connor

	// Description:
	// Object for life guards
	// initialized with first name, last name and age
	// has methods for setting in and out times for 
	//shifts and breaks, setting current status, and 
	// also keeps track of current position and rotation

public class Guard {
	String firstName;
	String lastName;
	
	int age;
	int intime;
	int breakout1;
	int breakin1;
	int breakout2;
	int breakin2;
	int outtime;
	int uniqueID;
	
	String status; //on break, on rotation, home, ect..
	
	Position position; //which position?
	Rotation rotation; //which rotation?
	

// Initialize Guard
//
	public Guard (String firstName, String lastName, int age, int uniqueID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.uniqueID = uniqueID;
	}
	
	
// Time in
// military time?
// or have separate parameters for hr and min
// then use hr+min/100 to form a decimal value
// ex. hr 2 min 50 -> 2+50/100 = 2.50
	public void setInTime (int time) {
		intime = time;
	}
	
	
// Time out
//
	public void setOutTime (int time) {
		outtime = time;
	}	
	
	
// First break
//
	public void setBreakIn1 (int time) {
		breakin1 = time;
	}
	
	public void setBreakOut1 (int time) {
		breakout1 = time;
	}
	
	
// Second break
//
	public void setBreakIn2 (int time) {
		breakin1 = time;
	}
	
	public void setBreakOut2 (int time) {
		breakout1 = time;
	}
	
	
// Status
//
	public String setStatus (int statusNumber) {
		status = "error";
		if(statusNumber == 0) {
			status = "ready";          //guard ready for action
			return status;
		}else if(statusNumber == 1){ 			// on break status number = 1
			status = "on break";
			return status;
		} else if(statusNumber == 2){		// rotation status number = 2
			status = "on rotation" + rotation.name;
			return status;
		} else if (statusNumber == 3){		// home status number = 3
			status = "home";
			return status;
		} else if (statusNumber == 4){		// placeholder
			status = "etc.";
			return status;
		}
		else {
		return status;	// returns error
		}
	}
	
	
// Position
//
	public void setPosition (Position pos) {
		position = pos;
	}
	
	
	
}
