package model;

import java.util.*;

public class Test {

	public static void main(String[] args) {
		//initialize guard objects and a linked list of guards
		Guard quinn = new Guard("Quinn", "O'Connor", 20);
		Guard brad = new Guard("Brad", "Hennes", 20);
		List<Guard> guardList= new LinkedList<Guard>();
		
		// set status button
		quinn.setStatus(1);
		brad.setStatus(3);
		System.out.println(quinn.firstName + " " + quinn.lastName.charAt(0) + ". status: " + quinn.status);
		System.out.println(brad.firstName + " " + brad.lastName.charAt(0) + ". status: " + brad.status);
		
		
		//Rotation one = new Rotation();
		//this now needs a name, age req, list of positions, and list of guards to initialize
		
		
		// add new employee button	
		guardList.add(quinn);	//add new employee to the guardList 
		guardList.add(brad);
		
		
	}

}
