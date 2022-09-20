package com.nt.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTestOracle_01 {

	public static void main(String[] args) {
		
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		try {
		     //read inputs
			sc=new Scanner(System.in);
			
			int no=0;
			if(sc!=null) {
				System.out.println("Enter Employee Number::");
			    no=sc.nextInt();//gives employee no
			     }//if
			//Load JDBC class(optional)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			
			//create JDBC Statement Obj
			if(con!=null)
				st=con.createStatement();
			//prepare SQL Query
			//select empno,ename,job,sal from emp where empno="7789";
			String query="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO="+no;
			
			//send & execute SQL Query in DB s/w
			if(st!=null)
				rs=st.executeQuery(query);
			
			//process the ResultSet
			if(rs!=null) {
				if(rs.next())
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			}
			else {
				System.out.println("Records Not Found");
			}
			
			
			
		} //try
		catch (SQLException se) {
			se.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//close the JDBC Objs
			try {
				if(rs!=null)
					rs.close();
			} catch (SQLException se) {
				se.printStackTrace();
				// TODO: handle exception
			}
			try {
				if(st!=null)
					st.close();
			} catch (SQLException se) {
				se.printStackTrace();
				// TODO: handle exception
			}
			try {
				if(con!=null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
				// TODO: handle exception
			}
			try {
				if(sc!=null)
					sc.close();
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}//finally
		}//main

	}//class

}
