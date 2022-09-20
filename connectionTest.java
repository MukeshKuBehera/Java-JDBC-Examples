import java.sql.*;

public class connectionTest 
{
	public static void main(String[] args) throws Exception
	{
		//resister JDBC driver s/w 
		    //a.create JDBC Driver class object 
			oracle.jdbc.driver.OracleDriver driver=new oracle.jdbc.driver.OracleDriver();

			//b.resister driver s/w
			DriverManager.registerDriver(driver);



           //classforname() method directly using replace to resister JDBC and driver 
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//establish the connection
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe;",
			                                            "system","manager");

			if(conn==null)
				System.out.println("connection is not established");
			else
				System.out.println("conncetion is established");
		
	}
}
  