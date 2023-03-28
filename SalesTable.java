package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SalesTable {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mca","mca");
		Statement stmt = con.createStatement();
		stmt.executeUpdate("create table sales(sid varchar2(10)primary key,sdate date, cname varchar2(20), cplace varchar2(50),phone varchar2(20),Tqty int,Tamt int)");
		stmt.executeUpdate("create table salesItem(sid varchar2(10)references sales, pid varchar2(10) references product,qty int, amt int)");
		System.out.println("table created");
	}

}
