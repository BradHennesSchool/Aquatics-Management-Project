package Aqua;

import java.sql.*;

public class SearchData {
	
	public boolean getRotation( String TL_name, String Ro_Time, String P1, String P2, String P3, String P4, String P5 ) {
		try {
	
			PreparedStatement pst = DatatoDB.dbconn.prepareStatement("SELECT * FROM Algae.Rotation");
		       
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
	
	//actual work schedule 
	public boolean getWorkSch( String Fname, String Act_day, String Act_in_time, String Act_out_time, String Act_date, String Break_in1, String Break_out1, String Break_in2, String Break_out2 ) {
		try {
	
			PreparedStatement pst = DatatoDB.dbconn.prepareStatement("SELECT * FROM Algae.ActualWork order by Act_date");
		       
            		ResultSet rs = pst.executeQuery();
            		while(rs.next()){
            	
				Fname = rs.getString("Fname");
				Act_day = rs.getString("Act_day");
				Act_in_time = rs.getString("Act_in_time");
				Act_out_time = rs.getString("Act_out_time");
				Act_date = rs.getString("Act_date");
				Break_in1 = rs.getString("Break_in1");
				Break_out1 = rs.getString("Break_out1");
				Break_in2 = rs.getString("Break_in2");
				Break_out2 = rs.getString("Break_out2");


				//Display values
				System.out.println("Guard Name: " + Fname + "\tDay: " + Act_day + "\tDate: " + Act_date + "\tClock in time: " + Act_in_time + "\tClock out time: " + Act_out_time + "\tFirst break start: " + Break_in1 + "\tFirst break end: " + Break_out1 + "\tSecond break start: " + Break_in2 + "\tSecond break end: " + Break_out2);
		    	}
            return true;
		}
		catch ( Exception err ) {
			err.getStackTrace();
			return false;
		}
	}
	
}
