package model;

import java.sql.Time;
import java.util.*;

public class Test {

	public static void main(String[] args) {
		//initialize guard objects and a linked list of guards
		Guard quinn = new Guard("Quinn", "O'Connor", 20, 123);
		Guard brad = new Guard("Brad", "Hennes", 20, 1234);
		List<Guard> guardList= new LinkedList<Guard>();
		
		// set status button
		quinn.setStatus(1);	//1 = on break
		brad.setStatus(3);	//3 = home
		System.out.println(quinn.firstName + " " + quinn.lastName.charAt(0) + ". status: " + quinn.status);
		System.out.println(brad.firstName + " " + brad.lastName.charAt(0) + ". status: " + brad.status);
		
		
		//Rotation one = new Rotation();
		//this now needs a name, age req, list of positions, and list of guards to initialize
		
		
		// add new employee button	
		guardList.add(quinn);	//add new employee to the guardList 
		guardList.add(brad);
		
		// set in time, first break out time, first break in time, out time, etc. 
		quinn.setInTime(800);  // *see my comment in guard class by the setInTime method for time parameter*
		quinn.setBreakIn1(1100);
		quinn.setBreakOut1(1115);
		quinn.setOutTime(1500);
		
		// get times
		System.out.println(quinn.firstName + "'s in time: " + quinn.intime);
		System.out.println(quinn.firstName + "'s break in time: " + quinn.breakin1);
		
		
		// init position
		Position winona = new Position("Winona");
		
		// set guard to a position and set position to guard
		// *do we need both?*
		winona.SetGuard(quinn);
		quinn.setPosition(winona);
		
		
	}
}
