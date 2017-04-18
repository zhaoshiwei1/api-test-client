package com.api.client.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Types;

public class Hello 
{
	public static void main(String[] args)
	{
		System.out.print("Hello world!");
		
		Connection c = null;
		Statement s = null;
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:"+"F:/backend-api-database/testCase.db3");
		      c.setAutoCommit(false);
		      System.out.println("Opened database successfully");

		      s = c.createStatement();
		      ResultSet rs = s.executeQuery( "SELECT * FROM TESTCASE;" );
		      while ( rs.next() ) {
		    	  ResultSetMetaData metaData = rs.getMetaData();  
		          for (int i = 0; i < metaData.getColumnCount(); i++) {  
		              // resultSet数据下标从1开始  
		              String columnName = metaData.getColumnName(i + 1);  
//		              int type = metaData.getColumnType(i + 1);  
//		              if (Types.INTEGER == type) {  
//		                  // int  
//		              } else if (Types.VARCHAR == type) {  
//		                  // String  
//		              }  
		              System.out.print(columnName + "\t");  
		          }  
		      }
		      rs.close();
		      s.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
}
