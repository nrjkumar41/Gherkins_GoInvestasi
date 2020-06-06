package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class DB_METHODS_Users {
	// JDBC driver name and database URL
	public static ResultSet rs;
	public static final String JDBC_DRIVER = "org.postgresql.Driver";
	public static final String DB_URL = "staging-db.pluang.com/pluang_users";
	

	// Database credentials
	public static final String USER = "postgres";
	public static final String PASS = "FtEv3Xx4Epx4CE5G";
	public static Connection conn = null;
	public static  Statement stmt = null;
	public static  String Db_User_Phone="select id from users where phone='+628123450000'";
	public static String Db_User_OAuth="select access_token from oauth_tokens where user_id IN (select id from users where phone='+628123450000') order by created desc limit 1";
	public static String Db_User_AccountId="select id from accounts where user_id IN (select id from users where phone='+628123450000')";
	@Test
	public static void db_connect() {

		try {

			// STEP 2: Register JDBC driver
			Class.forName("org.postgresql.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection("jdbc:postgresql://" + DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

		
			
			rs = stmt.executeQuery(Db_User_OAuth);
			while (rs.next()) {
				Db_User_OAuth = rs.getString(1);
				System.out.println("User AuthToken from Database : " + Db_User_OAuth);
				
			}
			rs = stmt.executeQuery(Db_User_AccountId);
			while (rs.next()) {
				Db_User_AccountId = rs.getString(1);
				System.out.println("User AccountId from Database : " + Db_User_AccountId);
				
			}


			rs.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

		System.out.println("Goodbye!");
	
	return;
	}// end main

}
