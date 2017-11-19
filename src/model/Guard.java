package model;

import java.text.SimpleDateFormat;

// Main Author: Quinn O'Connor

	// Description:
	// Object for life guards
	// initialized with first name, last name and age
	// has methods for setting in and out times for 
	// shifts and breaks, setting current status, and 
	// also keeps track of current position and rotation
import java.util.*;


public class Guard {
	String firstName;
	String lastName;
	
	int age;
	Date intime = null;
	Date breakout1 = null;
	Date breakin1 = null;
	Date breakout2 = null;
	Date breakin2 = null;
	Date outtime = null;
	int uniqueID;
	
	String status; //on break, on rotation, home, ect..
	
	Position position; //which position?
	Rotation rotation; //which rotation?
	
	SimpleDateFormat sf = new SimpleDateFormat("h:mm a"); //formatting for time

// Initialize Guard
//
	public Guard (String firstName, String lastName, int age, int uniqueID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.uniqueID = uniqueID;
		this.status = "ready";
	}
	
	
// Time in
//
	public String setInTime () {
		intime = new Date();
		return sf.format(intime);
	}
	
	public String getInTime () 
	{
		return sf.format(intime);
	}
	
	
// Time out
//
	public String setOutTime () {
		outtime = new Date();
		return sf.format(outtime);
	}	
	
	public String getOutTime () 
	{
		return sf.format(outtime);
	}
	
	
// both breaks
//
	public String setBreakIn () {
		if(breakin1 != null) {
			breakin1 = new Date();
			return sf.format(breakin1);
		}
		else {
			breakin2 = new Date();
			return sf.format(breakin2);
		}
	}
	
	public String setBreakOut () 
	{
		if(breakout1 != null) {
			breakout1 = new Date();
			return sf.format(breakout1);
		}
		else {
			breakout2 = new Date();
			return sf.format(breakout2);
		}
	}
	
	public String getBreakIn1 ()
	{
		return sf.format(breakin1);
	}
	
	public String getBreakIn2 ()
	{
		return sf.format(breakin2);
	}
	
	public String getBreakOut1 ()
	{
		return sf.format(breakout1);
	}
	
	public String getBreakOut2 ()
	{
		return sf.format(breakout2);
	}
	
// Status
//
	public String setStatus (String status) {
		
		status = "error";
		if(status == "ready") {
			status = "ready";          //guard ready for action
			return status;
		}else if(status == "break"){ 			// on break status number = 1
			status = "on break";
			return status;
		} else if(status == "position"){		// rotation status number = 2
			status = "in position: " + position.name;
			return status;
		} else if (status == "home"){		// home status number = 3
			status = "home";
			return status;
		} else if (status == "etc"){		// placeholder
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
