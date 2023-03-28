package Project;
import java.sql.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BrandTable {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//BufferedReader dis = new BufferedReader(new InputStreamReader(System.in));
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mca","mca");
		Statement stmt = con.createStatement();
		stmt.executeUpdate("create table brand(bid varchar2(10) primary key, Bname varchar2(20))");
		System.out.println("table created");
	}

}
