import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.Result;


public class ConnectDb {

	public static void main(String[] args) {
		final String url = "jdbc:mysql://localhost:3306/thong_tin_ts";
		final String user = "root";
		final String passwork = "";
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
				conn = DriverManager.getConnection(url,user,passwork);
				
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM thi_sinh");
				
				while(rs.next()) {
					String name = rs.getString("name");
					System.out.println("name: " + name);
				}
				
				
				
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
		      // Khoi finally duoc su dung de dong cac resour
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }// Ket thuc khoi finally
		   }
		
		
	}
}
