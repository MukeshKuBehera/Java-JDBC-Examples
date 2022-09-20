

import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;



public class SelectTestOracle 
{
	public static void main(String[] args) throws Exception
	{
		//register jdbc driver with DriverManager service by loading jdbc driver class
		//class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");

		//create jdbc statement object

		Statement st=con.createStatement();

		//send and execute sql select query in db s/w

		ResultSet rs=st.executeQuery("SELECT * FROM STUDENT");

		//Process the Resultset

		while(rs.next()!=false){
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
			//or//System.out.println(rs.getInt("sno")+"  "+rs.getString("sname")+"  "+rs.getString("course")+"  "+rs.getString("fee"));
			//System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
		
		}
		//close jdbc object

		rs.close();
		st.close();
		con.close();


		//System.out.println("Hello World!");
	}
}