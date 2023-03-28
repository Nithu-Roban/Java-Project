package Project;
import java.sql.*;
import java.io.*;
public class loginTable {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	//	DataInputStream dis = new DataInputStream(System.in);
		BufferedReader dis = new BufferedReader(new InputStreamReader(System.in));
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mca","mca");
		Statement stmt = con.createStatement();
		stmt.executeUpdate("create table Login(login_id varchar2(10) primary key, pass varchar2(15))");
		System.out.println("table created");
		PreparedStatement PS = con.prepareStatement("insert into Login values(?,?)");
		do {
			System.out.println("enter Login id, pass \t");
			String login_id = dis.readLine();
			String pass = dis.readLine();
			
			PS.setString(1,login_id);
			PS.setString(2,pass);
		
			int i=PS.executeUpdate();  
			System.out.println(i+" records affected");
			
			System.out.println("Do you want to continue: y/n");  
			String s=dis.readLine();  
				if(s.startsWith("n")){  
					break;  
				}  
			}while(true);
		ResultSet rs = stmt.executeQuery("select * from Login");
		ResultSetMetaData rm = rs.getMetaData();
		while(rs.next()) {
			for(int i=1;i<= rm.getColumnCount();i++) {
				System.out.println(rs.getString(i)+" ");	
			}
		}
		con.close();
	}

	
}

