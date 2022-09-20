//Write JDBC to get dept details based on given dept location

import java.sql.*;   //sql api
import java.util.*;  //utility api

class SelectTestOracle_01 
{
	public static void main(String[] args) throws Exception 
	{
		//read input from enduser
		Scanner scn=new Scanner(System.in);


		System.out.println("enter student address");

		//convert variables to sql query 
		String loc=scn.next();
		loc="'"+loc+"'";

		//System.out.println(loc);


		//loading jdbc class (optional)

		//Class.forName("oracle.jdbc.driver.OracleDriver");

     //establish connection between jdbc driver manager

	 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");


	 String query=" SELECT * FROM STUDENT1 WHERE SADD="+loc;

	 System.out.println(query);

	 //create statement object 

	 Statement st=con.createStatement();

	 //send&execute sql query

	 ResultSet rs=st.executeQuery(query);

	 //create ResultSet object
   
     Boolean flag=false;

	while(rs.next()!=false){
		 flag=true;
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
	 }
	 if(flag==false);
	 System.out.println("No Data Found");
  

  /** int count=0;

	 while(rs.next()!=false){
		 count=1;
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
	 }
	 if(count==0);
	 System.out.println("No Data Found");
	 */













	 //close objects
	 rs.close();
	 st.close();
	 con.close();

	}//main end
}//class end
