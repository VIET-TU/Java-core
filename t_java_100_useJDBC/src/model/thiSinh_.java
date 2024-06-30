package model;

import java.sql.Date;
import java.util.Objects;

public class thiSinh_ {
	private int msv;
	private String hoVaTen;
	private String queQuan;
	private Date ngaySin;
	private boolean gioiTinh;
	double mon1,mon2,mon3;
	
	public thiSinh_(int msv, String hoVaTen, String queQuan, Date ngaySin, boolean gioiTinh, double mon1, double mon2,
			double mon3) {
		super();
		this.msv = msv;
		this.hoVaTen = hoVaTen;
		this.queQuan = queQuan;
		this.ngaySin = ngaySin;
		this.gioiTinh = gioiTinh;
		this.mon1 = mon1;
		this.mon2 = mon2;
		this.mon3 = mon3;
	}
	

	public int getMsv() {
		return msv;
	}



	public void setMsv(int msv) {
		this.msv = msv;
	}


	/**
	 * @return the hoVaTen
	 */
	public String getHoVaTen() {
		return hoVaTen;
	}



	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}



	public String getQueQuan() {
		return queQuan;
	}



	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}


	/**
	 * @return the ngaySin
	 */
	public Date getNgaySin() {
		return ngaySin;
	}



	public void setNgaySin(Date ngaySin) {
		this.ngaySin = ngaySin;
	}



	public boolean isGioiTinh() {
		return gioiTinh;
	}



	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}



	public double getMon1() {
		return mon1;
	}



	public void setMon1(double mon1) {
		this.mon1 = mon1;
	}


	public double getMon2() {
		return mon2;
	}



	public void setMon2(double mon2) {
		this.mon2 = mon2;
	}



	public double getMon3() {
		return mon3;
	}


	public void setMon3(double mon3) {
		this.mon3 = mon3;
	}


	@Override
	public int hashCode() {
		return Objects.hash(gioiTinh, hoVaTen, mon1, mon2, mon3, msv, ngaySin, queQuan);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		thiSinh_ other = (thiSinh_) obj;
		return gioiTinh == other.gioiTinh && Objects.equals(hoVaTen, other.hoVaTen)
				&& Double.doubleToLongBits(mon1) == Double.doubleToLongBits(other.mon1)
				&& Double.doubleToLongBits(mon2) == Double.doubleToLongBits(other.mon2)
				&& Double.doubleToLongBits(mon3) == Double.doubleToLongBits(other.mon3) && msv == other.msv
				&& Objects.equals(ngaySin, other.ngaySin) && Objects.equals(queQuan, other.queQuan);
	}
	
	
	
}
