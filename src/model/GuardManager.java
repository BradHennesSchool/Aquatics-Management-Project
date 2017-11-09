package model;
import java.util.*;
import java.sql.Time;
import java.time.*;


public class GuardManager {

	ArrayList<Guard> guardList;
	ArrayList<Rotation> rotationList;
	
	public GuardManager(ArrayList<Guard> InitGuardList, ArrayList<Rotation> RotList)
	{
		this.guardList = InitGuardList;
		this.rotationList = RotList;
	}
	
	public Rotation GetRotation(String RotName)
	{
		for(Rotation r: rotationList)
		{
			if(r.name == RotName)
				return r;
		}
		
		return null;
	}
	
	public Guard GetGuard(String fName, String lName)
	{
		for(Guard lg: guardList)
		{
			if(lg.firstName == fName && lg.lastName == lName)
				return lg;
		}
		
		return null;
	}
	
	public void AddGuard(Guard GuardToAdd)
	{
		guardList.add(GuardToAdd);
	}
	
	public String RemoveGuard(int uniqueID)
	{
		for(Guard lg: guardList)
		{
			if(uniqueID == lg.uniqueID)
			{
				if(lg.status == "ready")
				{
					guardList.remove(lg);
					return lg.firstName + " Was sent home!";
				}
				else
				{
					return lg.firstName + " Could not be sent home";
				}
			}
		}
		
		return "Lifeguard could not be found";
	}
	
	public Guard PushRotation(String RotationName, String fName, String lName)
	{
		return GetRotation(RotationName).Push(GetGuard(fName, lName));
	}	
	
	public String SendGuardToBreak(Guard lg)
	{
		lg.setBreakIn1(Calendar.getInstance().getTime());
		
		return "";
	}
	
}
