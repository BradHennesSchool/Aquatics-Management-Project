package main;
import gui.*;

import java.util.ArrayList;

import Aqua.*;
import model.*;

public class Program {

	public static void main(String[] args) 
	{
		DatatoDB newdb = new DatatoDB();
		
		//get guards from database
		ArrayList<Guard> guards = newdb.GetGuardsFromDatabase();
		//get rotations from database
		ArrayList<Rotation> rots = newdb.GetRotationsFromDatabase();
		
		//create the guard manager
		GuardManager MainManager = new GuardManager(guards, rots);
		
		AMS UI = new AMS();
	}

}
