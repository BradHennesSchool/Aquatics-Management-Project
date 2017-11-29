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
			{
				System.out.println(RotName + " found");
				return r;
			}
		}
		
		System.out.println(RotName + " not found");
		return null;
	}
	
	public ArrayList<Rotation> GetAllRotations()
	{
		return rotationList;
	}
	
	public ArrayList<String> getGuard2(Boolean over18, String[] status)
	{
		ArrayList<String> ret= new ArrayList<String>();
		
		for(Guard lg: guardList)
		{
			if(Arrays.asList(status).contains(lg.status) && (lg.age >= 18 || !over18))
				ret.add(lg.firstName + " " + lg.lastName);
		}
		
		return ret;
	}
	
	public Guard GetGuard(String fName, String lName)
	{
		for(Guard lg: guardList)
		{
			if(lg.firstName.equals(fName) && lg.lastName.equals(lName))
			{
				System.out.println("get request: " + lg.firstName + " " + lg.lastName);
				return lg;
			}
		}
		System.out.println(fName + " " + lName + " " + "not found");
		
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
	
	public void SendGuardToBreak(String lgName)
	{
		String fname = lgName.split(" ")[0];
		String lname = lgName.split(" ")[1];
		Guard lg = GetGuard(fname, lname);
		lg.setBreakIn();
		lg.setStatus("on break");
	}
	
	public void ConfirmGuardBackFromBreak(String lgName)
	{
		String fname = lgName.split(" ")[0];
		String lname = lgName.split(" ")[1];
		Guard lg = GetGuard(fname, lname);
		lg.setStatus("ready");
	}
	
	public void ConfirmRotationPushed(Guard lg, Rotation rot)
	{
		lg.setStatus("ready");
		rot.pushing = false;
	}
	
	public ArrayList<String> GetNotifications()
	{
		ArrayList<String> ret = new ArrayList<String>();
		
		for(Rotation r: rotationList)
		{
			long diffMinutes = (r.GetLastPush().getTime() - new Date().getTime()) / (60 * 1000) % 60;
			
			if(diffMinutes > 45)
			{
				ret.add("Please push " + r.name);
			}
		}
		
		return ret;
	}	
}
