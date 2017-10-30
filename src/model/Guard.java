package model;

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
	String status;//on break, on rotation, home, ect..
	
	Position position; //which position?
	Rotation rotation; //which rotation?
	
//
// Initialize Guard
//
	public Guard (String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	
//
// Time in
//
	public void setInTime (int time) {
		intime = time;
	}
	
	
//
// Time out
//
	public void setOutTime (int time) {
		outtime = time;
	}	
	
	
//
// First break
//
	public void setbreakin1 (int time) {
		breakin1 = time;
	}
	
	public int getbreakin1 () {
		return breakin1;
	}
	
	public void setbreakout1 (int time) {
		breakout1 = time;
	}
	
	public int getbreakout1 () {
		return breakout1;
	}
	
	
//
// Second break
//
	public void setbreakin2 (int time) {
		breakin1 = time;
	}
	
	public void setbreakout2 (int time) {
		breakout1 = time;
	}
	
	
//
// Status
//
	public String setStatus (int statusNumber) {
		status = "error";
		
		if(statusNumber == 1){ 			// on break status number = 1
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
	
	
//
// Position
//
	public void setPosition (Position pos) {
		position = pos;
	}
	
	
	
}
