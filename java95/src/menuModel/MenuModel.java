package menuModel;

import java.util.StringTokenizer;

public class MenuModel {
	private String monChinh;
	private String monPhu;
	private double tongTien;
	public MenuModel() {
		this.monChinh = "";
		this.monPhu = "";
		this.tongTien = 0;
	}
	/**
	 * @return the monChinh
	 */
	public String getMonChinh() {
		return monChinh;
	}
	/**
	 * @param monChinh the monChinh to set
	 */
	public void setMonChinh(String monChinh) {
		this.monChinh = monChinh;
	}
	/**
	 * @return the monPhu
	 */
	public String getMonPhu() {
		return monPhu;
	}
	/**
	 * @param monPhu the monPhu to set
	 */
	public void setMonPhu(String monPhu) {
		this.monPhu = monPhu;
	}
	/**
	 * @return the tongTien
	 */
	public double getTongTien() {
		return tongTien;
	}
	/**
	 * @param tongTien the tongTien to set
	 */
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	
	public void tinhTongTien() {
		tongTien = 0;
		
		if(monChinh.equals("CƠM")) tongTien +=20000;
		else if (monChinh.equals("PHỞ")) tongTien += 50000;
		else if (monChinh.equals("BÁNH MÌ")) tongTien += 15000;
		
		///
		
		StringTokenizer stk =  new StringTokenizer(this.monPhu,";");
		while(stk.hasMoreElements()) {
			String a = (String) stk.nextElement();
			a = a.trim();
			if(a.equals("trà sữa")) {
				tongTien+= 5000;
			}else if(a.equals("bánh ngọt")) {
				tongTien+= 10000;
			}else if(a.equals("nem")) {
				tongTien+= 15000;
			}else if(a.equals("cocacola")) {
				tongTien+= 20000;
			}
		}
		
	}
	
	
}
