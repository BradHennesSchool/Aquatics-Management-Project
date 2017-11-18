package model;

import java.text.SimpleDateFormat;
import java.util.*;

public class Test {

	public static void main(String[] args) {
		//initialize guard objects and a linked list of guards
		Guard quinn = new Guard("Quinn", "O'Connor", 20, 123);
		Guard brad = new Guard("Brad", "Hennes", 20, 1234);
		List<Guard> guardList= new LinkedList<Guard>();
		
		// set status button
		quinn.setStatus("ready");	//1 = on break
		brad.setStatus("home");	//3 = home
		System.out.println(quinn.firstName + " " + quinn.lastName.charAt(0) + ". status: " + quinn.status);
		System.out.println(brad.firstName + " " + brad.lastName.charAt(0) + ". status: " + brad.status);
		
		
		//Rotation one = new Rotation();
		//this now needs a name, age req, list of positions, and list of guards to initialize
		
		
		// add new employee button	
		guardList.add(quinn);	//add new employee to the guardList 
		guardList.add(brad);
		
		// get times
		System.out.println(quinn.firstName + "'s in time: " + quinn.intime);
		System.out.println(quinn.firstName + "'s break in time: " + quinn.breakin1);
		
		
		// init position
		Position winona = new Position("Winona");
		
		// set guard to a position and set position to guard
		winona.SetGuard(quinn);
		quinn.setPosition(winona);
		
		
		//set in time test
		//SimpleDateFormat sf = new SimpleDateFormat("h:mm a"); 	// formatting for the time output		
		
		System.out.println(quinn.setOutTime());	// formatting is coded inside the method
	}
}
