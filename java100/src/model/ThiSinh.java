package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class ThiSinh implements Serializable{
	public int maxThiSinh;
	public String tenThiSinh;
	public String queQuan;
	public Date ngaySinh;
	public boolean gioiTinh;
	public double diemMon1;
	public double diemMon2;
	public double diemMon3;
	
	public ThiSinh(int maxThiSinh, String tenThiSinh, String queQuan2, Date ngaySinh, boolean gioiTinh, double diemMon1,
			double diemMon2, double diemMon3) {
		this.maxThiSinh = maxThiSinh;
		this.tenThiSinh = tenThiSinh;
		this.queQuan = queQuan2;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.diemMon1 = diemMon1;
		this.diemMon2 = diemMon2;
		this.diemMon3 = diemMon3;
	}
	/**
	 * @return the maxThiSinh
	 */
	public int getMaxThiSinh() {
		return maxThiSinh;
	}
	/**
	 * @param maxThiSinh the maxThiSinh to set
	 */
	public void setMaxThiSinh(int maxThiSinh) {
		this.maxThiSinh = maxThiSinh;
	}
	/**
	 * @return the tenThiSinh
	 */
	public String getTenThiSinh() {
		return tenThiSinh;
	}
	/**
	 * @param tenThiSinh the tenThiSinh to set
	 */
	public void setTenThiSinh(String tenThiSinh) {
		this.tenThiSinh = tenThiSinh;
	}
	/**
	 * @return the queQuan
	 */
	public String getQueQuan() {
		return queQuan;
	}
	/**
	 * @param queQuan the queQuan to set
	 */
	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}
	/**
	 * @return the ngaySinh
	 */
	public Date getNgaySinh() {
		return ngaySinh;
	}
	/**
	 * @param ngaySinh the ngaySinh to set
	 */
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	/**
	 * @return the gioiTinh
	 */
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	/**
	 * @param gioiTinh the gioiTinh to set
	 */
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	/**
	 * @return the diemMon1
	 */
	public double getDiemMon1() {
		return diemMon1;
	}
	/**
	 * @param diemMon1 the diemMon1 to set
	 */
	public void setDiemMon1(double diemMon1) {
		this.diemMon1 = diemMon1;
	}
	/**
	 * @return the diemMon2
	 */
	public double getDiemMon2() {
		return diemMon2;
	}
	/**
	 * @param diemMon2 the diemMon2 to set
	 */
	public void setDiemMon2(double diemMon2) {
		this.diemMon2 = diemMon2;
	}
	/**
	 * @return the diemMon3
	 */
	public double getDiemMon3() {
		return diemMon3;
	}
	/**
	 * @param diemMon3 the diemMon3 to set
	 */
	public void setDiemMon3(double diemMon3) {
		this.diemMon3 = diemMon3;
	}
	@Override
	public String toString() {
		return "ThinhSinh [maxThiSinh=" + maxThiSinh + ", tenThiSinh=" + tenThiSinh + ", queQuan=" + queQuan
				+ ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", diemMon1=" + diemMon1 + ", diemMon2="
				+ diemMon2 + ", diemMon3=" + diemMon3 + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(diemMon1, diemMon2, diemMon3, gioiTinh, maxThiSinh, ngaySinh, queQuan, tenThiSinh);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ThiSinh other = (ThiSinh) obj;
		return Double.doubleToLongBits(diemMon1) == Double.doubleToLongBits(other.diemMon1)
				&& Double.doubleToLongBits(diemMon2) == Double.doubleToLongBits(other.diemMon2)
				&& Double.doubleToLongBits(diemMon3) == Double.doubleToLongBits(other.diemMon3)
				&& gioiTinh == other.gioiTinh && maxThiSinh == other.maxThiSinh
				&& Objects.equals(ngaySinh, other.ngaySinh) && Objects.equals(queQuan, other.queQuan)
				&& Objects.equals(tenThiSinh, other.tenThiSinh);
	}
	
	
	
}
