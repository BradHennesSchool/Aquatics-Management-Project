package model;
import java.util.*;

public class GuardManager {

	ArrayList<Guard> guardList;
	
	public GuardManager(ArrayList<Guard> InitList)
	{
		this.guardList = InitList;
	}
	
	public void AddGuard(Guard GuardToAdd)
	{
		this.guardList.add(GuardToAdd);
	}
	
	public String RemoveGuard(int uniqueID)
	{
		for(Guard lg: this.guardList)
		{
			if(uniqueID == lg.uniqueID)
			{
				if(lg.status == "ready")
				{
					this.guardList.remove(lg);
					return lg.firstName + "Was sent home!";
				}
				else
				{
					return lg.firstName + "Could not be sent home";
				}
			}
		}
		
		return "Lifeguard could not be found";
	}
	
	
}
