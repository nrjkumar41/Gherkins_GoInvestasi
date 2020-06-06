package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class DB_METHODS {
	// JDBC driver name and database URL
	public static ResultSet rs;
	public static int client_id = 181;
	public static final String JDBC_DRIVER = "org.postgresql.Driver";
	public static final String DB_URL = "staging-db.pluang.com/pluang_users";
	// static final String DB_URL =
	// "http://api.crash.amber.infeedo.com/phpmyadmin/?Username=pmuser&Password=pmuser123";
	static String All_People;
	public static String Total_Chats_sent;
	public static String Chat_Responded;
	public static String People_Covered;
	public static String DOA_Available;

	// Database credentials
	public static final String USER = "postgres";
	public static final String PASS = "FtEv3Xx4Epx4CE5G";
	public static Connection conn = null;
	public  Statement stmt = null;

	public  String People_Covered_Q = "SELECT * FROM users limit 1" ;

	@Test
	public  void db_connect() {

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

			rs = stmt.executeQuery(People_Covered_Q);
			while (rs.next()) {
				People_Covered = rs.getString("email");
				System.out.println("Total Employee Covered : " + People_Covered);
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
	}// end main
}
