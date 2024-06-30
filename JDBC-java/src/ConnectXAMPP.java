//package Contentjdbc;

//package Contentjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectXAMPP {
	public static void main(String[] args) {
	    // TODO Auto-generated method stub
	    try
	    {  
	    	Class.forName("com.mysql.jdbc.Driver") ; 
	        Connection con =DriverManager.getConnection(  
	        "jdbc:mysql://localhost:3306","root","root");  
	        System.out.println("kết nối thành công"); 


	    }

	    catch(Exception e)
	    {
//	        System.out.println(e);
	        System.out.println("kết nối không thành công");
	    }
	   
	}

	  
}
