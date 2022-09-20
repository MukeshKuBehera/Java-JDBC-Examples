package DeleteTestOracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteTestOracle01 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		Scanner sc=null;
		// TODO Auto-generated method stub
        try {
			sc=new Scanner(System.in);
			//read inputs
			float startFEE=0,endFEE=0;
			if (sc!=null) {
				System.out.println("Enter Start range of Avg::");
				startFEE=sc.nextLong();
				System.out.println("Enter end range of Avg::");
				endFEE=sc.nextLong();
				
			}
			//load JDBC Driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//create Statement object
			if(con!=null)
				st=con.createStatement();
			//prepare SQL query
			//DELTE FROM STUDENT WHERE AVG<=60 AND AVG>=40;
			String query="DELETE FROM STUDENT WHERE AVG="+startFEE+"AND AVG="+endFEE;
			System.out.println(query);
			
			//send & execute SQL quires to DB s/w
			int count=0;
			if(st!=null)
				count=st.executeUpdate(query);
			//process the result
			if (count==0){
				System.out.println("Records Not Found To Be Deleted");
			     }
				else {
					System.out.println(count+"no of records are effected");
				}
						
		}//try
          catch (SQLException se) {
        	  se.printStackTrace();
		}
        catch(ClassNotFoundException cnf){
        	cnf.printStackTrace();
        }catch(Exception e) {
        	e.printStackTrace();
        }
        finally {
			//close JDBC objects
        	try {
				if(con!=null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
        	try {
				if(st!=null)
					st.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
        	try {
				if(sc!=null)
					sc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
        		
		}//finally
	}//main

}//class
