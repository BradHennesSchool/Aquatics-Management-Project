package model;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

import Aqua.*;

public class ImplementationExamples 
{
	public static void main(String[] args)
	{
		for(int i = 0; i < 5; ++ i)
			System.out.println("Position" + (i + 1));
		
		System.out.println("Does this work?!?");
		
		DatatoDB newdb = new DatatoDB();
		
		//get guards from database
		ArrayList<Guard> guards = newdb.GetGuardsFromDatabase();
		//get rotations from database
		ArrayList<Rotation> rots = newdb.GetRotationsFromDatabase();
		
		//create the guard manager
		GuardManager MainManager = new GuardManager(guards, rots);
		
		//create list of guard for initial placement
		//normally this would be done with the UI and a user would
		//select guard by name and place them into the correct spots
		Guard[] initGuardList = new Guard[5];
		initGuardList[0] = MainManager.GetGuard("Jane", "Doe");
		initGuardList[1] = MainManager.GetGuard("Jon", "Doe");
		initGuardList[2] = MainManager.GetGuard("Jean", "Leow");
		initGuardList[3] = MainManager.GetGuard("Kevin", "Eanes");
		initGuardList[4] = MainManager.GetGuard("Hannah", "Lebakken"); 
		
		//Create the initial placement for rotation one
		MainManager.GetRotation("Rotation 1").initGuards(initGuardList);
		
		
		System.out.println();
		//Show that the guards above are in position
		for(String line: MainManager.GetGuardList())
		{
			System.out.println(line);
		}
		System.out.println();
		
		//user will select guards from a list
		Guard ReturningGuard = MainManager.PushRotationGetReturningGuard("Rotation 1", "Brad", "Hennes");
		
		//example with pushing rotation with a guard that does not meet the age requirement
		if(ReturningGuard == null)
			System.out.println("Guard does not meet the age requirement for this rotation");
		else
			System.out.println(ReturningGuard.firstName + " Pushed Rotation 1");
		System.out.println();
		ReturningGuard = MainManager.PushRotationGetReturningGuard("Rotation 1", "Steve", "Stevenson");
		//example with an older guard
		if(ReturningGuard == null)
			System.out.println("Guard does not meet the age requirement for this rotation");
		else
			System.out.println(ReturningGuard.firstName + " Is comming back from rotation 1");
		System.out.println();
		
		
		
		for(String st: MainManager.getGuard2(false, new String[] {"ready"}))
		{
			System.out.println(st);
		}
		
		
		
		
	}
}
