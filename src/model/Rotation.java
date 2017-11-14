package model;

public class Rotation {

	String name;
	int ageReq;
	boolean pushing;
	
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
		
	}
	
	private void SetPositions(Position[] PositionList, Guard[] InitGuardList) 
	{
		for(int i = 0; i < PositionList.length; ++i)
		{
			Positions[i] = PositionList[i];
			Positions[i].SetGuard(InitGuardList[i]);
			InitGuardList[i].setPosition(Positions[i]);
			InitGuardList[i].setStatus(2);
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
		
		return retGuard;
	}
}
