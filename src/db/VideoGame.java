package db;
import java.sql.*;
import java.util.ArrayList;

public class VideoGame {
	static VideoGame instance = new VideoGame();
	Connection dbconn;
	ResultSet results = null;
	PreparedStatement sql;
	String dpwd = null;
	StringBuilder sb = new StringBuilder();
	
	public String system;
	public String genre;
	public String developer;
	public String franchise;
	public String engine;
	public String publisher;
	public String launch;
	
	public ArrayList<String> platList = new ArrayList<String>();
	public ArrayList<String> devList = new ArrayList<String>();
	public ArrayList<String> genList = new ArrayList<String>();
	public ArrayList<String> franList = new ArrayList<String>();
	public ArrayList<String> engList = new ArrayList<String>();
	public ArrayList<String> pubList = new ArrayList<String>();
	public ArrayList<String> lauList = new ArrayList<String>();
	
	String dbPath="jdbc:mysql://localhost:3306/project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	public static VideoGame getInstance() {
		if (instance==null) {
			instance = new VideoGame();
		}
		return instance;
	}
	
	//Establish connection to MySQL server
	public Connection newConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			try {			
				dbconn = DriverManager.getConnection(dbPath,"root","11111111");
				System.out.println("gain the connection");
				
				return dbconn;
			}
			catch (Exception s){
				System.out.println(s.getStackTrace().toString());
				System.out.println(s.getMessage().toString());
				System.out.println("catch 1");}
		}
		catch (Exception err){
			System.out.println(err.getStackTrace().toString());
			System.out.println(err.getMessage().toString());
			System.out.println("catch 2");
		}
		return null;
	}
	
	public ResultSet System() {
		int i=0;
		try {
			dbconn=instance.newConnection();
			sql=dbconn.prepareStatement("Select distinct platformName from project.Platform");
			ResultSet results;
			results=sql.executeQuery("Select distinct platformName from project.Platform");
			System.out.println("query="+"Select distinct platformName from project.Platform");
			while (results.next()) {
				system = results.getString("platformName");
				platList.add(system);
				i++;
			}
			dbconn.close();
		}
		catch (Exception err) {
			System.out.println(err.getMessage());
			System.out.println("catch 3");
		}
		return results;
	}
	
	public ResultSet Genre() {
		int i=0;
		try {
			dbconn=instance.newConnection();
			sql=dbconn.prepareStatement("Select distinct genreName from project.Genre");
			ResultSet results;
			results=sql.executeQuery("Select distinct genreName from project.Genre");
			System.out.println("query="+"Select distict genreName from project.Genre");
			while (results.next()) {
				genre = results.getString("genreName");
				genList.add(genre);
				i++;
			}
			dbconn.close();
		}
		catch (Exception err) {
			System.out.println(err.getMessage());
			System.out.println("catch 3");
		}
		return results;
	}
	
	public ResultSet Developer() {
		int i=0;
		try {
			dbconn=instance.newConnection();
			sql=dbconn.prepareStatement("Select distinct devName from project.Developer");
			ResultSet results;
			results=sql.executeQuery("Select distinct devName from project.Developer");
			System.out.println("query="+"Select distinct devName from project.Developer");
			while (results.next()) {
				developer = results.getString("devName");
				devList.add(developer);
				i++;
			}
			dbconn.close();
		}
		catch (Exception err) {
			System.out.println(err.getMessage());
			System.out.println("catch 3");
		}
		return results;
	}
	
	public ResultSet Franchise() {
		int i=0;
		try {
			dbconn=instance.newConnection();
			sql=dbconn.prepareStatement("Select distinct franchiseName from project.Franchise");
			ResultSet results;
			results=sql.executeQuery("Select distinct franchiseName from project.Franchise");
			System.out.println("query="+"Select distinct franchiseName from project.Franchise");
			while (results.next()) {
				franchise = results.getString("franchiseName");
				franList.add(franchise);
				i++;
			}
			dbconn.close();
		}
		catch (Exception err) {
			System.out.println(err.getMessage());
			System.out.println("catch 3");
		}
		return results;
	}
	
	public ResultSet Engine() {
		int i=0;
		try {
			dbconn=instance.newConnection();
			sql=dbconn.prepareStatement("Select distinct engineName from project.Engine");
			ResultSet results;
			results=sql.executeQuery("Select distinct engineName from project.Engine");
			System.out.println("query="+"Select distinct engineName from project.Engine");
			while (results.next()) {
				engine = results.getString("engineName");
				engList.add(engine);
				i++;
			}
			dbconn.close();
		}
		catch (Exception err) {
			System.out.println(err.getMessage());
			System.out.println("catch 3");
		}
		return results;
	}
	
	public ResultSet Publisher() {
		int i=0;
		try {
			dbconn=instance.newConnection();
			sql=dbconn.prepareStatement("Select distinct pubName from project.Publisher");
			ResultSet results;
			results=sql.executeQuery("Select distinct pubName from project.Publisher");
			System.out.println("query="+"Select distinct pubName from project.Publisher");
			while (results.next()) {
				publisher = results.getString("pubName");
				pubList.add(publisher);
				i++;
			}
			dbconn.close();
		}
		catch (Exception err) {
			System.out.println(err.getMessage());
			System.out.println("catch 3");
		}
		return results;
	}
	
	public ResultSet Launch() {
		int i=0;
		try {
			dbconn=instance.newConnection();
			sql=dbconn.prepareStatement("Select distinct launchDate from project.launchDate");
			ResultSet results;
			results=sql.executeQuery("Select distinct launchDate from project.launchDate");
			System.out.println("query="+"Select distinct launchDate from project.launchDate");
			while (results.next()) {
				launch = results.getString("launchDate");
				lauList.add(launch);
				i++;
			}
			dbconn.close();
		}
		catch (Exception err) {
			System.out.println(err.getMessage());
			System.out.println("catch 3");
		}
		return results;
	}
		
	public ResultSet selectStatement( String query ) {
		try {
			
			dbconn=instance.newConnection();
			sql=dbconn.prepareStatement(query);
			ResultSet results;
			results=sql.executeQuery();
			
			dbconn.close();
			return results;
		}
		catch (Exception err) {
			System.out.println(err.getMessage());
			System.out.println("catch 3");
			return null;
		}
	}

//public boolean userlookup(String user, String pass) throws SQLException {
//		
//		try {
//			dbconn=instance.newConnection();
//			sql=dbconn.prepareStatement("Select * from cs485_lab.User_Account");
//			ResultSet results;
//			results=sql.executeQuery("Select * from cs485_lab.User_Account");
//			System.out.println("query="+"Select * from cs485_lab.User_Account");
//			while (results.next()) {
//				Username = results.getString("User");
//				Password = results.getString("Password");
//				System.out.println("DB Uname = " +Username);
//				System.out.println("DB Pword = " +Password);
//				System.out.println("Uname = " +user);
//				System.out.println("Pword = " +pass);
//				if ((user.equals(Username)) && (pass.equals(Password)))
//				{
//					status = true;
//				}
//				else {
//					status = false;
//				}
//				if (status == true) {
//					break;
//				}
//			}
//			dbconn.close();
//		}
//		catch (Exception err) {
//			System.out.println(err.getMessage());
//			System.out.println("catch 3");
//			
//		}
//		
//		System.out.println(user + " " + pass);
//		
//		return status;
//	}
	
	public static void main(String[] args) {	
		//instance.entry("1234", "asdf", "asdf", "asdf", "asdf", "asdf", "asdf");
		instance.selectStatement("Select * from Developer");
	}
}
