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
		
		ArrayList<Guard> guards = newdb.GetGuardsFromDatabase();
		
		ArrayList<Rotation> rots = newdb.GetRotationsFromDatabase();
		
		GuardManager MainManager = new GuardManager(guards, rots);
		
		
	}
}
