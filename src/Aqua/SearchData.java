package Aqua;

import java.sql.*;

public class SearchData {
	
	public boolean getRotation( String TL_name, String Ro_Time, String P1, String P2, String P3, String P4, String P5 ) {
		try {
	
			PreparedStatement pst = DatatoDB.dbconn.prepareStatement("SELECT Team_Lead, Ro_Time,Position1,Position2,Position3,Position4,Position5, FROM Algae.Rotation");
		       
            		ResultSet rs = pst.executeQuery();
            		
			while(rs.next()){
            	
				TL_name = rs.getString("Team_Lead");
				Ro_Time = rs.getString("Ro_Time");
				P1 = rs.getString("Position1");
				P2 = rs.getString("Position2");
				P3 = rs.getString("Position3");
				P4 = rs.getString("Position4");
				P5 = rs.getString("Position5");

				//Display values
				System.out.println("Team Lead: " + TL_name + "\tRotation Time: " + Ro_Time + "\tPosition1: " + P1 + "\tPosition2: " + P2 + "\tPosition3: " + P3 + "\tPosition4: " + P4 + "\tPosition5: " + P5);
            		}
            	return true;
		
		} catch ( Exception err ) {
			err.getStackTrace();
			return false;
		}
	}
}
