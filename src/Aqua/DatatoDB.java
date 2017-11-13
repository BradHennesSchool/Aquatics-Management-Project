package Aqua;

import java.sql.*;

public class DatatoDB {
	static DatatoDB instance = new DatatoDB();
	static Connection dbconn;
	ResultSet results = null;
	PreparedStatement sql;
	
	//change URL to your database server as needed
	String dbPath="jdbc:mysql://localhost:3306";
	
	public static DatatoDB getInstance() {
		if (instance==null) {
			instance = new DatatoDB();
		}
		return instance;
	}
	
	//Establish connection to MySQL server
	public Connection newConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			try {			
				dbconn = DriverManager.getConnection(dbPath,"root","1995");		//1995 is my db password
				System.out.println("gain the connection");
				return dbconn;
			}
			catch (Exception s){
				System.out.println(s.getStackTrace().toString());}
		}
		catch (Exception err){
			System.out.println(err.getStackTrace().toString());
		}
		return null;
	}
	
	public ResultSet selectStatement( String query ) {
		try {
			
			dbconn=instance.newConnection();			
			sql=dbconn.prepareStatement(query);
			ResultSet results;
			results=sql.executeQuery();
			System.out.println("query="+query);
	
			//WARNING!
			//Need to process ResultSet before closing connection
			dbconn.close();
			return results;
		}
		catch (Exception err) {
			System.out.println(err.getMessage());
			return null;
		}
	}

	public boolean DBentry( String query ) {
		try {
			System.out.println("query="+query);
			instance.newConnection();
			sql=dbconn.prepareStatement(query);
			sql.executeUpdate(query);
			dbconn.close();
			return true;
		}
		catch ( Exception err ) {
			err.getStackTrace();
			return false;
		}
	}
	
	public boolean entryGuardInfo( String Fname, String Lname, String Age ) {
		try {
	
			instance.DBentry("INSERT INTO Algae.Guard_Info ( `Fname`, `Lname`, `Age`) " +
								"VALUES ('"+Fname+"', '"+Lname+"' ,'"+Age+"');");	
			return true;
		}
		catch ( Exception err ) {
			err.getStackTrace();
			return false;
		}
	}
	
	public boolean enterRotation( String TL_name, String G_name, String Rot_Time, String Position1, String Position2, String Position3, String Position4, String Position5, String Age ) {
		try {
	
			instance.DBentry("INSERT INTO Algae.Rotation ( `Team_Lead`, `Ro_Time`, `Position1`, `Position2`, `Position3`, `Position4`, `Position5`, `age`) " +
								"VALUES ('"+TL_name+"','"+Rot_Time+"', '"+Position1+"', '"+Position2+"', '"+Position3+"','"+Position4+"', '"+Position5+"', '"+Age+"');");	
			return true;
		}
		catch ( Exception err ) {
			err.getStackTrace();
			return false;
		}
	}
	
	public boolean enterSchWork( String Fname, String Sch_day, String Sch_in_time, String Sch_out_time, String Sch_date ) {
		try {
	
			instance.DBentry("INSERT INTO Algae.ScheduleWork ( `G_name`, `Sch_day`, `Sch_in_time`, `Sch_out_time`, `Sch_date`) " +
								"VALUES ('"+Fname+"', '"+Sch_day+"' ,'"+Sch_in_time+"', '"+Sch_out_time+"', '"+Sch_date+"' );");	
			return true;
		}
		catch ( Exception err ) {
			err.getStackTrace();
			return false;
		}
	}
	
	public boolean enterActWork( String Fname, String Act_day, String Act_in_time, String Act_out_time, String Act_date, String Break_in1, String Break_out1, String Break_in2, String Break_out2 ) {
		try {
	
			instance.DBentry("INSERT INTO Algae.ActualWork ( `G_name`, `Act_day`, `Act_in_time`, `Act_out_time`, `Act_date`, `Break_in1`, `Break_out1`, `Break_in1`, `Break_out2` ) " +
								"VALUES ('"+Fname+"', '"+Act_day+"' ,'"+Act_in_time+"', '"+Act_out_time+"', '"+Act_date+"', '"+Break_in1+"', '"+Break_out1+"', '"+Break_in2+"', '"+Break_out2+"' );");	
			return true;
		}
		catch ( Exception err ) {
			err.getStackTrace();
			return false;
		}
	}
	
}
