package model;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.Date; 
//import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class QLSV_model {
	public thiSinh_ thiSinh;
	public static Connection conn;
	public static Statement stmt;
	public String luaChon;
	public Set<Integer> msv_model ;
	
	public ArrayList<thiSinh_> dsThiSinh;
	
	public QLSV_model() {
		this.dsThiSinh = new ArrayList<thiSinh_>();
		this.msv_model = new HashSet<Integer>();
	}
	/**
	 * @return the luaChon
	 */
	public String getLuaChon() {
		return luaChon;
	}


	/**
	 * @param luaChon the luaChon to set
	 */
	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}


	public static  Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/thong_tin_ts";
		String user = "root";
		String passwork = "";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
				conn = DriverManager.getConnection(url, user, passwork);
				return conn;
				
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}	
			
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	

	
	public ArrayList<thiSinh_> getDsThiSinh() {
		return dsThiSinh;
	}

	
	public void setDsThiSinh(ArrayList<thiSinh_> dsThiSinh) {
		this.dsThiSinh = dsThiSinh;
	}
	
	public static ArrayList<thiSinh_> findAll(){
		ArrayList<thiSinh_> dsThiSinh = new ArrayList<thiSinh_>();
		String sql = "select *from thi_sinh;";
		Connection conn = getConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				boolean gt = false;
				if(rs.getString(5).equals("Nam")) gt = true;

				
				thiSinh_ ts = new thiSinh_(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getDate(4),
						gt,rs.getDouble(6), rs.getDouble(7), rs.getDouble(8));
				
				dsThiSinh.add(ts);
			}
			return dsThiSinh;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return null;
	}
	
	public static int  insert(thiSinh_ ts) {

		String sql = "insert into thi_sinh values(?,?,?,?,?,?,?,?);";
		
		PreparedStatement pstmt;
		try {

			Connection conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			///
			pstmt.setInt(1, ts.getMsv());
			pstmt.setString(2, ts.getHoVaTen());
			
			pstmt.setString(3, ts.getQueQuan());

			pstmt.setDate(4, ts.getNgaySin());
			String gt;
			if(ts.isGioiTinh())  gt = "Nam";
			else gt = "Nữ";
			pstmt.setString(5, gt);
			pstmt.setDouble(6, ts.getMon1());
			pstmt.setDouble(7, ts.getMon2());
			pstmt.setDouble(8, ts.getMon3());
			
			int row = pstmt.executeUpdate();
			return row;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public static void delete(thiSinh_ thisinh) {
		String sql = "delete from thi_sinh where msv = ?";
		Connection conn = getConnection();
		PreparedStatement pstmt;
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, thisinh.getMsv());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void update(thiSinh_ ts) throws SQLException {
		String sql = "UPDATE thi_sinh SET hoVaTen = ?, tinh=?, ngaySinh=?,gioiTinh=?,mon1 =?,mon2=?,mon3=? where msv = ? ;";
		
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,ts.getHoVaTen());
		pstmt.setString(2,ts.getQueQuan());
		pstmt.setDate(3, ts.getNgaySin());
		
		String gt =  ts.isGioiTinh() ? "Nam" : "Nữ";
		
		pstmt.setString(4, gt);
		
		pstmt.setDouble(5, ts.getMon1());
		pstmt.setDouble(6, ts.getMon2());
		pstmt.setDouble(7, ts.getMon3());
		pstmt.setInt(8, ts.getMsv());
		
		pstmt.executeUpdate();
	}
	
	public  Set timKiem_queQuan(String string) {
		String sql = "SELECT *FROM thi_sinh WHERE tinh NOT IN (?)";
		Connection conn = getConnection();
	PreparedStatement pstmt;
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,string);

		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			this.msv_model.add(rs.getInt(1));
			
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	return msv_model;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
	
	}
	public Set timKiem_msv(int id) {
		String sql = "SELECT *FROM thi_sinh WHERE msv NOT IN (?)";
		Connection conn = getConnection();
	PreparedStatement pstmt;
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,id);

		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			this.msv_model.add(rs.getInt(1));
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	return msv_model;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
	
	}
	

}
