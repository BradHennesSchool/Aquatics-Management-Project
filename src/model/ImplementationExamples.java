package model;
import java.util.*;
public class ImplementationExamples 
{
	public static void main(String[] args) 
	{
		ArrayList<Guard> GuardList = new ArrayList<Guard>();
		
		//foreach record in the database
		for(int i = 0; i < 5; ++i)
		{
			GuardList.add(new Guard("Brad" + i, "Hennes" + i, 19, i));
		}
		
		
		
	}
}
