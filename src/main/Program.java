package main;
import gui.*;

import java.util.ArrayList;

import Aqua.*;
import model.*;

public class Program 
{
	public static void main(String[] args) 
	{
		DatatoDB newdb = new DatatoDB();
		
		//get guards from database
		ArrayList<Guard> guards = newdb.GetGuardsFromDatabase();
		
		//get rotations from database
		ArrayList<Rotation> rots = newdb.GetRotationsFromDatabase();
		
		//create the guard manager
		GuardManager MainManager = new GuardManager(guards, rots);
		
		Guard[] initGuardList = new Guard[5];
		initGuardList[0] = MainManager.GetGuard("Jane", "Doe");
		initGuardList[1] = MainManager.GetGuard("Jon", "Doe");
		initGuardList[2] = MainManager.GetGuard("Jean", "Leow");
		initGuardList[3] = MainManager.GetGuard("Kevin", "Eanes");
		initGuardList[4] = MainManager.GetGuard("Hannah", "Lebakken"); 
		
		//Create the initial placement for rotation one
		MainManager.GetRotation("Rotation 1").initGuards(initGuardList);
		
		Guard[] initGuardList2 = new Guard[5];
		initGuardList[0] = MainManager.GetGuard("Jane2", "Doe2");
		initGuardList[1] = MainManager.GetGuard("Jon", "Doe2");
		initGuardList[2] = MainManager.GetGuard("Jean2", "Leow2");
		initGuardList[3] = MainManager.GetGuard("Kevin2", "Eanes2");
		initGuardList[4] = MainManager.GetGuard("Hannah2", "Lebakken2"); 
		
		//Create the initial placement for rotation one
		MainManager.GetRotation("Rotation 2").initGuards(initGuardList2);
		
		Guard[] initGuardList3 = new Guard[5];
		initGuardList[0] = MainManager.GetGuard("Jane3", "Doe3");
		initGuardList[1] = MainManager.GetGuard("Jon3", "Doe3");
		initGuardList[2] = MainManager.GetGuard("Jean3", "Leow3");
		initGuardList[3] = MainManager.GetGuard("Kevin3", "Eanes3");
		initGuardList[4] = MainManager.GetGuard("Hannah3", "Lebakken3"); 
		
		//Create the initial placement for rotation one
		MainManager.GetRotation("Rotation 3").initGuards(initGuardList3);
		
		Guard[] initGuardList4 = new Guard[5];
		initGuardList[0] = MainManager.GetGuard("Brad", "Hennes");
		initGuardList[1] = MainManager.GetGuard("Brad2", "Hennes2");
		initGuardList[2] = MainManager.GetGuard("Quinn", "OConnor");
		initGuardList[3] = MainManager.GetGuard("Quinn2", "OConnor2");
		initGuardList[4] = MainManager.GetGuard("Quinn3", "OConnor3"); 
		
		
		//Create the initial placement for rotation one
		MainManager.GetRotation("Rotation 4").initGuards(initGuardList4);		
		
		AMS UI = new AMS(MainManager);
		
		for(String line: MainManager.GetGuardList())
		{
			System.out.println(line);
		}
		System.out.println();
		//UI.updateRotations(MainManager.getRotations);	
	}
}
