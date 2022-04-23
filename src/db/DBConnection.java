package db;

import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {

	public static Connection getConn() throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		System.out.println("connection created...");
		return c;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			getConn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

