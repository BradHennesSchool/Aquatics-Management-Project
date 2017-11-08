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
					dbconn = DriverManager.getConnection(dbPath,"root","1995");
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
		
	public boolean entryGuardInfo( String fname, String lname, String age ) {
		try {
	
			instance.DBentry("INSERT INTO Aquatic_Mgmt.Guard_Info ( `fname`, `lname`, `age`) " +
								"VALUES ('"+fname+"', '"+lname+"' ,'"+age+"');");	
			return true;
		}
		catch ( Exception err ) {
			err.getStackTrace();
			return false;
		}
	}
	
	public boolean enterRotation( String TL_name, String G_name, String Rot_Time, String L1, String L2, String L3, String L4, String L5 ) {
		try {
	
			instance.DBentry("INSERT INTO Aquatic_Mgmt.Rotation ( `Team_Lead`, `Gname`, `Ro_Time`, `Position1`, `Position2`, `Position3`, `Position4`, `Position5`) " +
								"VALUES ('"+TL_name+"', '"+G_name+"' ,'"+Rot_Time+"', '"+L1+"', '"+L2+"', '"+L3+"','"+L4+"', '"+L5+"');");	
			return true;
		}
		catch ( Exception err ) {
			err.getStackTrace();
			return false;
		}
	}
	
	public boolean enterSchWork( String fname, String sch_day, String sch_in_time, String sch_out_time, String sch_date ) {
		try {
	
			instance.DBentry("INSERT INTO Aquatic_Mgmt.ScheduleWork ( `G_name`, `Sch_day`, `Sch_in_time`, `Sch_out_time`, `Sch_date`) " +
								"VALUES ('"+fname+"', '"+sch_day+"' ,'"+sch_in_time+"', '"+sch_out_time+"', '"+sch_date+"' );");	
			return true;
		}
		catch ( Exception err ) {
			err.getStackTrace();
			return false;
		}
	}
	
	public boolean enterActWork( String fname, String Act_day, String Act_in_time, String Act_out_time, String Act_date ) {
		try {
	
			instance.DBentry("INSERT INTO Aquatic_Mgmt.ActualWork ( `G_name`, `Act_day`, `Act_in_time`, `Act_out_time`, `Act_date`) " +
								"VALUES ('"+fname+"', '"+Act_day+"' ,'"+Act_in_time+"', '"+Act_out_time+"', '"+Act_date+"' );");	
			return true;
		}
		catch ( Exception err ) {
			err.getStackTrace();
			return false;
		}
	}
	
	
}
