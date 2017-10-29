package model;

public class Guard {
	String name;
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
	public Guard (String name, int age) {
		this.name = name;
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
	public void setStatus (String stat) {
		status = stat;
	}
	
	
//
// Position
//
	public void setPosition (Position pos) {
		position = pos;
	}
	
	
	
}
