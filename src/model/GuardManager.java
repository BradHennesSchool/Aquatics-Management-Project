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
			if(r.name.equals(RotName))
				return r;
		}
		
		return null;
	}
	
	// Is this what you want?
	//
	public List<Guard> getGuard2(Boolean over18, String status)
	{
		List<Guard> guardList= new LinkedList<Guard>();
		
		for(Guard lg: guardList)
		{
			if(Arrays.asList(status).contains(lg.status) && over18)
				guardList.add(lg);
		}
		
		return guardList;
	}
	
	public Guard GetGuard(String fName, String lName)
	{
		for(Guard lg: guardList)
		{
			if(lg.firstName.equals(fName) && lg.lastName.equals(lName))
				return lg;
		}
		
		return null;
	}
	
	public String[] GetGuardList()
	{
		String[] GuardList = new String[guardList.size()];
		
		int i = 0;
		for(Guard lg: guardList)
		{
			GuardList[i] = lg.firstName + " " + lg.lastName + " Age: " +lg.age + " Status: " + lg.status;
			++i;
		}
		
		return GuardList;
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
				if(lg.status.equals("ready"))
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
	
	public Guard PushRotationGetReturningGuard(String RotationName, String fName, String lName)
	{
		if(GetGuard(fName, lName).age >= GetRotation(RotationName).ageReq &&
				GetGuard(fName, lName).status.equals("ready"))
			return GetRotation(RotationName).Push(GetGuard(fName, lName));
		else
			return null;
	}	
	
	public void SendGuardToBreak(Guard lg)
	{
		lg.setBreakIn(Calendar.getInstance().getTime());
		lg.setStatus(0);
	}
	
	public void ConfirmGuardBackFromBreak(Guard lg)
	{
		lg.setBreakOut(Calendar.getInstance().getTime());
		lg.setStatus(0);
	}
	
	public void ConfirmRotationPushed(Guard lg, Rotation rot)
	{
		lg.setStatus(0);
		rot.pushing = false;
	}
	
}
