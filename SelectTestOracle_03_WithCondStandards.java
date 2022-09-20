/** Write a JDBC App to get Employee from EMP db table based on the 3 desg 
               (with coding standards)
*/
package com.nt.jdbc;
/**
App to get emp details from emp db table based on the 3 desgs

Version:1.0
Author ::Team-MKB
Date-
*/
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.Scanner;


public class SelectTestOracle_03_WithCondStandards 
{
	public static void main(String[] args) 
	{
		Scanner sc=null;
		Connection con=null;
		 Statement st=null;
		   ResultSet rs=null;


		   try{
			//read inputs
			sc=new Scanner(System.in);

			String desg1=null,desg2=null,desg3=null;

			       if(sc!=null){
					     System.out.println("Enter Desg1:");
						  desg1=sc.next().toUpperCase();//gives CLERK

						  System.out.println("Enter Desg2:");
						  desg2=sc.next().toUpperCase();;//gives MANAGER

						  System.out.println("Enter Desg3:");
						  desg3=sc.next().toUpperCase();//gives SALESMAN
				
			                }//IF

							  //Convert input values as required for the SQL Query 
							            //('CLERK','MANAGER','SALESMAN')
                               String cond="('"+desg1+"','"+desg2+"','"+desg3+"')";

							      System.out.println(cond);

              //Load JDBC Driver Class (optional)
			  Class.forName("oracle.jdbc.driver.OracleDriver");
			  //Establish the connection 
			  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");

			  //create Statement obj
			  if(con!=null)
				  st=con.createStatement();

			  //prepare SQL Query
			  //SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN ('CLERK','MANAGER','SALESMAN') ORDER BY JOB;
			  String query="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN"+cond+"ORDER BY JOB";

			      System.out.println(query);
             //send & execute SQLselect query to DB s/w
			        if(st!=null)
						  rs=st.executeQuery(query);

             //process the ResultSet
			 if(rs!=null){
				 boolean flag=false;
			       while(rs.next()){
					flag=true;
					  System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			       }//while
				   if(!flag)
					   System.out.println("Record Not Found");
			 }//if


		   }//try
		   catch(SQLException se){  //To handle known exception
			   se.printStackTrace();//gives detailed information about the exception that is raised

			   System.out.println(se);
			
		                       }//catch
							   catch(ClassNotFoundException cnf){//to handle known exception
								   cnf.printStackTrace();

								
							   }//catch
							   catch(Exception e){//to handle unknown exception
								e.printStackTrace();
							   }//catch
							   finally{

								   /**
								//close jdbc objs(bad code)
								try{
									if(rs!=null&&st!=null&&con!=null){
										rs.close();
										st.close();
										con.close();
									}
								}
								catch(SQLException se){
									se.printStackTrace();
								}
								*/

								//create jdbc objs (good coding)
								try
								{
									if(rs!=null)
										rs.close();

								}
								catch (SQLException se)
								{
									se.printStackTrace();
								}

								try
								{
									if(st!=null)
										st.close();
								}
								catch (SQLException se1)
								{
									se1.printStackTrace();
								}

								try
								{
									if(con!=null)
										con.close();
								}
								catch (SQLException se2)
								{
									se2.printStackTrace();
								}
							   }//finally
		
	}//main
}//class
