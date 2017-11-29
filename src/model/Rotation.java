package model;

import java.util.*;

public class Rotation 
{
	String name;
	int ageReq;
	public boolean pushing;
	Guard ReturningGuard;
	Date LastPush;
	Position[] Positions;
	
	public Rotation(String name, int ageReq, Position[] PositionList)
	{
		this.name = name;
		this.ageReq = ageReq;
		this.Positions = PositionList;
		this.pushing = false;
	}
	
	public void initGuards(Guard[] InitGuardList)
	{
		SetPositions(Positions, InitGuardList);
		for(Guard lg: InitGuardList)
		{
			lg.setStatus("on rotation");
		}
		
		
	}
	
	private void SetPositions(Position[] PositionList, Guard[] InitGuardList) 
	{
		for(int i = 0; i < PositionList.length; ++i)
		{
			Positions[i] = PositionList[i];
			Positions[i].SetGuard(InitGuardList[i]);
			InitGuardList[i].setPosition(Positions[i]);
			InitGuardList[i].setStatus("on rotation");
		}
	}
	
	public Position[] Positions()
	{
		return Positions;
	}
	
	public Guard Push(Guard newGuard)
	{
		Guard retGuard = Positions[Positions.length -1].CurrentGuard;
		
		for(int i = Positions.length - 1; i > 0; --i)
		{
			Positions[i].CurrentGuard = Positions[i - 1].CurrentGuard;
			Positions[i].CurrentGuard.setPosition(Positions[i]);
		}
		
		Positions[0].CurrentGuard = newGuard;
		newGuard.setPosition(Positions[0]);
		
		pushing = true;
		LastPush = new Date();
		ReturningGuard = retGuard;
		
		//retGuard.setStatus("ready");
		newGuard.setStatus("on rotation");
		
		return retGuard;
	}
	
	public Date GetLastPush()
	{
		return LastPush;
	}
}
