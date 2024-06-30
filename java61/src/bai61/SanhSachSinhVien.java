package bai61;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SanhSachSinhVien {
		private ArrayList<SinhVien> danhSach;
		
		public SanhSachSinhVien() {
			this.danhSach = new ArrayList<SinhVien>();
		}
		
		public SanhSachSinhVien(ArrayList<SinhVien> danhSach) {
			this.danhSach = danhSach;
		}
		
		// 1.	ThÃªm sinh viÃªn vÃ o danh sÃ¡ch.
		public void themSinhVien(SinhVien sv) {
			this.danhSach.add(sv);
		}
		
//		2.	In danh sÃ¡ch sinh viÃªn ra mÃ n hÃ¬nh.
		public void inDanhSachSinhVien() {
			for (SinhVien sinhVien : danhSach) {
				System.out.println(sinhVien);
			}
		}
		
//		3.	Kiá»ƒm tra danh sÃ¡ch cÃ³ rá»—ng hay khÃ´ng.
		public boolean kiemTraDanhSachRong() {
			return this.danhSach.isEmpty();
		}
		
//		4.	Láº¥y ra sá»‘ lÆ°á»£ng sinh viÃªn trong danh sÃ¡ch.
		public int laySoLuongSinhVien() {
			return this.danhSach.size();
		}
		
//		5.	LÃ m rá»—ng danh sÃ¡ch sinh viÃªn.
		public void lamRongDanhSach() {
			this.danhSach.removeAll(danhSach);
		}
		
//		6.	Kiá»ƒm tra sinh viÃªn cÃ³ tá»“n táº¡i trong danh sÃ¡ch hay khÃ´ng, dá»±a trÃªn mÃ£ sinh viÃªn.
		public boolean kiemTraTonTai(SinhVien sv) {
			return this.danhSach.contains(sv);
		}
		
//		7.	XÃ³a má»™t sinh viÃªn ra khá»�i danh sÃ¡ch dá»±a trÃªn mÃ£ sinh viÃªn.
		public boolean xoaSinhVien(SinhVien sv) {
			return this.danhSach.remove(sv);
		}
		
//		8.	TÃ¬m kiáº¿m táº¥t cáº£ sinh viÃªn dá»±a trÃªn TÃªn Ä‘Æ°á»£c nháº­p tá»« bÃ n phÃ­m.
		public void timSinhVien(String ten) {
			for (SinhVien sinhVien : danhSach) {
				if(sinhVien.getHoVaTen().indexOf(ten)>=0) {
					System.out.println(sinhVien);
				}
			}
		}
//		9.	Xuáº¥t ra danh sÃ¡ch sinh viÃªn cÃ³ Ä‘iá»ƒm tá»« cao Ä‘áº¿n tháº¥p.
		public void sapXepSinhVienGiamDanTheoDiem() {
			Collections.sort(this.danhSach, new Comparator<SinhVien>() {
			
				public int compare(SinhVien sv1, SinhVien sv2) {
					if(sv1.getDiemTrungBinh()<sv2.getDiemTrungBinh()) {
						return 1;
					}else if(sv1.getDiemTrungBinh()>sv2.getDiemTrungBinh()) {
						return -1;
					}else {
						return 0;
					}
				}	
			});
		}
}