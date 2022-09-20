import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ClassNotFoundException;
class Connect 
{
	public static void main(String args[])// throws ClassNotFoundException
	{
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;

        try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@loclalhost:1521:xe","system","manager");
			

			String sql="SELECT * FROM STUDENT";

			pst=conn.prepareStatement(sql);

			rs=pst.executeQuery();

			while(rs.next())
				System.out.println(rs.getInt(1)+""+rs.getString(2));
			conn.close();

        }catch(Exception e){System.out.println(e);}

	
	}
}
