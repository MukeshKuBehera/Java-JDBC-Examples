package com.nt.jdbc1;

import java.util.Scanner;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectOracleTest_WithCodingStandards {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=null;
		Statement st=null;
		Connection con=null;
		ResultSet rs=null;
     
		
		try {
			//read inputs
			sc=new Scanner(System.in);
			String desg1=null,desg2=null,desg3=null;
			
			if (sc!=null) {
				System.out.println("Enter Desg1:");
				desg1=sc.next().toUpperCase();//gives CLERK
				
				System.out.println("Enter Desg2:");
				desg2=sc.next().toUpperCase();//gives MANAGER
				
				System.out.println("Enter Desg3:");
				desg3=sc.next().toUpperCase();//gives SALESMAN
				
			}//if
			//convert input query as required SQL query
			//('CLERK','MANAGER','SALESMAN')
			String cond="('"+desg1+"','"+desg2+"','"+desg3+"')";
			System.out.println(cond);
			
			//Load JDBC Driver class(optional)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			
			//create Statement object
			if (con!=null) {
				st=con.createStatement();
				
				//prepare SQL query
				//SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN('CLERK','MANAGER','SALESMAN') ORDER BY JOB;
				String query="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN"+cond+"ORDER BY JOB";
				System.out.println(query);
				
				//send & execute 	SQL select query to DB S/W
				if (st!=null) {
					rs=st.executeQuery(query);
					
					//process the ResultSet 
					if (rs!=null) {
						Boolean flag=false;
						while(rs.next()) {
							flag=true;
						System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
						}//while
						if (!flag) {
							System.out.println("Records not Found");
							
						}//if
					}//if
					
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();//to handle known exception
			System.out.println(se);//gives info about the exception that is raised
		}catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
			System.out.println(cnf);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//close the jdbc objs
		/**	try {
				if (rs!=null&&st!=null&&con!=null) {
					rs.close();
					st.close();
					con.close();
					
				}
			} catch (SQLException se){
				se.printStackTrace();
				// TODO: handle exception
			}*/
			
			//close the JDBC objs (good coding)
			try {
				if (rs!=null) {
					rs.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
				// TODO: handle exception
			}
			try {
				if (st!=null) {
					st.close();
				}
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
			try {
				if (con!=null) {
					con.close();
				}
			} catch (SQLException se3) {
				se3.printStackTrace();
			}
		}//finally
	}//main

}//class
