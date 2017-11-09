package model;

public class Rotation {

	String name;
	int ageReq;
	
	Position[] Positions;
	
	public Rotation(String name, int ageReq, Position[] PositionList, Guard[] InitGuardList)
	{
		this.name = name;
		this.ageReq = ageReq;
		this.Positions = new Position[PositionList.length];
		SetPositions(PositionList, InitGuardList);
	}
	
	private void SetPositions(Position[] PositionList, Guard[] InitGuardList) 
	{
		for(int i = 0; i < PositionList.length; ++i)
		{
			Positions[i] = PositionList[i];
			Positions[i].SetGuard(InitGuardList[i]);
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
		}
		
		Positions[0].CurrentGuard = newGuard;
		
		return retGuard;
	}
}
