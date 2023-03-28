package Project;
import java.sql.*;


public class ProductTable {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mca","mca");
		Statement stmt = con.createStatement();
		stmt.executeUpdate("create table Product(Pid varchar2(10) primary key, pname varchar2(25),ptype varchar2(20),bname varchar2(20) , rate int, qty int)");
		System.out.println("table created");
		/*stmt.executeUpdate("insert into Citizen values(?,?,?,?,?)");
		do {
			System.out.println("enter id, name, age, address and date of birth: \t");
			int id = Integer.parseInt(dis.readLine());
			String name = dis.readLine();
			int age = Integer.parseInt(dis.readLine());
			String adr = dis.readLine();
			String dob =  dis.readLine();
			stmt.setInt(1,id);
			stmt.setString(2,name);
			stmt.setInt(3,age);
			stmt.setString(4,adr);
			stmt.setString(5,dob);
			
			int i=stmt.executeUpdate();  
			System.out.println(i+" records affected");
			
			System.out.println("Do you want to continue: y/n");  
			String s=dis.readLine();  
				if(s.startsWith("n")){  
					break;  
				}  
			}while(true);  */
		con.close();
	}

}
