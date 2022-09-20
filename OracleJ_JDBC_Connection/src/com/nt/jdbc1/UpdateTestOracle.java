//UpdateTestOracle.java
package com.nt.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTestOracle {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		Scanner sc=null;
		
		try {
			//read inputs
			sc=new Scanner(System.in);
			String Sname=null,Course=null;
			int fee=0,sno=0;
			
			if (sc!=null) {
				System.out.println("Enter Student No::");
				sno=sc.nextInt();
				System.out.println("Enter Student Name::");
				Sname=sc.next();
				System.out.println("Enter Student course::");
				Course=sc.next();
				System.out.println("Enter Student Fee::");
				fee=sc.nextInt();
				
				}
			//convert into values as required for the SQL query
			Course="'"+Course+"'";
			Sname="'"+Sname+"'";
			//Load JDBC Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Establish the Connection
			if(con!=null)
                   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			          //create statement obj
			          if(con!=null)
			        	  st=con.createStatement();
			          //prepare SQL query
                        //UPDATE STUDENT SET SNAME='__',COURSE='__',FEE=__ WHERE SNO=__;
			          String query="UPDATE STUDENT SET SNAME="+Sname+",Course="+Course+",FEE="+fee+" WHERE SNO="+sno;
			          System.out.println(query);
			          
			          //send & execute SQL query into DB s/w
			          int count =0;
			          if(st!=null)
			        	  count=st.executeUpdate(query);
			          //process the ResultSet
			          if(count==0){
			        	         System.out.println("Records not found to update");
			                    }
			                    else 
			        	            System.out.println(count+"no of records are updated");
			        	              }
			                           catch (SQLException se) {
			                              se.printStackTrace();
			                              System.err.println(se.getMessage());
		                                    }
		                                    catch(ClassNotFoundException cnf){
		                                        	cnf.printStackTrace();
		                                        	System.err.println(cnf.getMessage());
		                                              }
		                                              catch (Exception e) {
			                                                 e.printStackTrace();
			                                                 System.err.println(e.getMessage());
		                                                         }//try
		                        finally {
		                        	//close the objects
		                        	try {
										if(st!=null)
											st.close();
									} catch (SQLException se) {
										se.printStackTrace();
									
									}
		                        	try {
										if(con!=null)
											con.close();
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
		}  //main      

	}//class

