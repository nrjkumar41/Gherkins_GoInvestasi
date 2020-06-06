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
	public static final String JDBC_DRIVER = "org.postgresql.Driver";
	public static final String DB_URL = "staging-db.pluang.com/pluang_gold_transactions";
	

	// Database credentials
	public static final String USER = "postgres";
	public static final String PASS = "FtEv3Xx4Epx4CE5G";
	public static Connection conn = null;
	public static  Statement stmt = null;
	public static String Db_Buy_Price;
	public static String Db_Sell_Price;
	public static  String Db_Buy_Price_Q="select sell_price from master_gold_prices order by updated desc limit 1";
	public static String Db_Sell_Price_Q="select buy_back_price from master_gold_prices order by updated desc limit 1";

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

		
			
			rs = stmt.executeQuery(Db_Buy_Price_Q);
			while (rs.next()) {
				Db_Buy_Price_Q = rs.getString(1);
				Db_Buy_Price=Db_Buy_Price_Q;
				System.out.println("Buy Price from Database : " + Db_Buy_Price);
				
			}
			rs = stmt.executeQuery(Db_Sell_Price_Q);
			while (rs.next()) {
				Db_Sell_Price_Q = rs.getString(1);
				Db_Sell_Price=Db_Sell_Price_Q;
				System.out.println("Sell Price from Database : " + Db_Sell_Price);
				
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
