package model;

import java.io.Serializable;
import java.util.ArrayList;

public class QLSVModel implements Serializable{
	public ArrayList<ThiSinh> dsThiSinh;
	public String luaChon;
	public String tenFile;

	public QLSVModel() {
		this.dsThiSinh = new ArrayList<ThiSinh>();
		this.tenFile = "";
		this.luaChon = "";
		
	}
	

	/**
	 * @return the tenFile
	 */
	public String getTenFile() {
		return tenFile;
	}


	/**
	 * @param tenFile the tenFile to set
	 */
	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}


	/**
	 * @return the dsThiSinh
	 */
	public ArrayList<ThiSinh> getDsThiSinh() {
		return dsThiSinh;
	}

	/**
	 * @param dsThiSinh the dsThiSinh to set
	 */
	public void setDsThiSinh(ArrayList<ThiSinh> dsThiSinh) {
		this.dsThiSinh = dsThiSinh;
	}
	
	public void insert(ThiSinh thiSinh) {
		this.dsThiSinh.add(thiSinh);
	}
	
	public void delete(ThiSinh thiSinh) {
		this.dsThiSinh.remove(thiSinh);
	}
	
	public void update(ThiSinh thiSinh) {
		this.dsThiSinh.remove(thiSinh);
		this.dsThiSinh.add(thiSinh);
	}
	
	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}
	
	public String getLuaChon() {
		return this.luaChon;
	}
	
	// thông qua mã sinh viên
	public boolean kiemTraTonTai(ThiSinh ts) {
		for(ThiSinh thiSinh : dsThiSinh) {
			if(thiSinh.maxThiSinh == ts.maxThiSinh) return true;
		}
		return false;
	}
	
}
