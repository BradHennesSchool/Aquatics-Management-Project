package model;

import java.util.*;

public class Test {

	public static void main(String[] args) {
		Guard quinn = new Guard("Quinn", 20);
		Guard brad = new Guard("Brad", 20);
		
		quinn.setStatus(1);
		brad.setStatus(3);
		
		System.out.println(quinn.name + " is " + quinn.status);
		System.out.println(brad.name + " is " + brad.status);
		
		//Rotation one = new Rotation();
		//this now needs a name, age req, list of positions, and list of guards to initialize
		
		List<Guard> guardList= new LinkedList<Guard>();
		guardList.add(quinn);
		guardList.add(brad);
		
	}

}
