package program;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.print.attribute.standard.PrinterInfo;

import com.mysql.cj.jdbc.DatabaseMetaData;
import com.mysql.cj.xdevapi.Result;

//import com.mysql.cj.protocol.Resultset;
//import com.mysql.cj.xdevapi.Statement;

import java.sql.Connection;
public class ConnectionMysql {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn =  DriverManager.getConnection(  
			        "jdbc:mysql://localhost:3306/sinh_vien","root","");
		 
		Statement stmt = conn.createStatement();
		 conn.setAutoCommit(false);
		 
		 String sql2 = "select *from sinh_vien_k62";
		
		 Savepoint sp1 = conn.setSavepoint("sp1");
		 String sql1 = "insert into sinh_vien_k62 values(500,'tien')";
		  stmt.executeUpdate(sql1);
	
		 ResultSet rs =  stmt.executeQuery(sql2);
		 int row =0;
		 while(rs.next()) {
			  row++;
		 }
		 System.out.println(" so hang truoc khi rollback() "+row);
		 conn.rollback(sp1);
//		 conn.commit();
		 
		 row = 0;
		 rs = stmt.executeQuery(sql2);
		 
		 while(rs.next()) {
			  row++;
		 }
		 System.out.println(" so hang sau khi rollback() "+row);
		 
		 sql1 = "insert into sinh_vien_k62 values(500,'tien')";
		  stmt.executeUpdate(sql1);
		  
		  row = 0;
			 rs = stmt.executeQuery(sql2);
			 
			 while(rs.next()) {
				  row++;
			 }
			 System.out.println(" so hang sau khi rollback() "+row); 
		 
//			 conn.commit();
		 
//		System.out.println("ký thác thành công");
		} catch (ClassNotFoundException e) {
			System.out.println("class thất bại");
			e.printStackTrace();
		} catch (SQLException e) {
//			try {
//				if(conn != null)
//					System.out.println("ký thác thật bại nên phải rollback");
//					conn.rollback();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			System.out.println("connection thất bại");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static char[] printRs(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}
}
