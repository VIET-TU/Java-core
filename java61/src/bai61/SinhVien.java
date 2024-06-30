package bai61;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

import javax.print.attribute.standard.OrientationRequested;
import javax.swing.text.AttributeSet.ColorAttribute;

public class SinhVien{
	static class sinh_vien implements Comparable{
		private String maSinhVien;
		private String hoVaTen;
		private int namSinh;
		private double  diemTrungBinh;
		public sinh_vien(String maSinhVien, String hoVaTen, int namSinh, double diemTrungBinh) {
			super();
			this.maSinhVien = maSinhVien;
			this.hoVaTen = hoVaTen;
			this.namSinh = namSinh;
			this.diemTrungBinh = diemTrungBinh;
		}
		
		public sinh_vien(String maSinhVien) {
			this.maSinhVien = maSinhVien;
		}

		/**
		 * @return the maSinhVien
		 */
		public String getMaSinhVien() {
			return maSinhVien;
		}
		/**
		 * @param maSinhVien the maSinhVien to set
		 */
		public void setMaSinhVien(String maSinhVien) {
			this.maSinhVien = maSinhVien;
		}
		/**
		 * @return the hoVaTen
		 */
		public String getHoVaTen() {
			return hoVaTen;
		}
		/**
		 * @param hoVaTen the hoVaTen to set
		 */
		public void setHoVaTen(String hoVaTen) {
			this.hoVaTen = hoVaTen;
		}
		/**
		 * @return the namSinh
		 */
		public int getNamSinh() {
			return namSinh;
		}
		/**
		 * @param namSinh the namSinh to set
		 */
		public void setNamSinh(int namSinh) {
			this.namSinh = namSinh;
		}
		/**
		 * @return the diemTrungBinh
		 */
		public double getDiemTrungBinh() {
			return diemTrungBinh;
		}
		/**
		 * @param diemTrungBinh the diemTrungBinh to set
		 */
		public void setDiemTrungBinh(double diemTrungBinh) {
			this.diemTrungBinh = diemTrungBinh;
		}
		@Override
		public String toString() {
			return "sinh_vien [maSinhVien=" + maSinhVien + ", hoVaTen=" + hoVaTen + ", namSinh=" + namSinh
					+ ", diemTrungBinh=" + diemTrungBinh + "]";
		}
		@Override
		public int hashCode() {
			return Objects.hash(diemTrungBinh, hoVaTen, maSinhVien, namSinh);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			sinh_vien other = (sinh_vien) obj;
			return maSinhVien.equals(other.maSinhVien);
		}
		@Override
		public int compareTo(Object o) {
			sinh_vien sv_o  = (sinh_vien) o;
			if(this.diemTrungBinh==sv_o.diemTrungBinh)
				return 0;
			else if(this.diemTrungBinh>sv_o.diemTrungBinh)
				return 1;
			else 
				return -1;
					
		}
		
		
		
		
		
	}
	
	static class DanhSachSinhVien{
		private ArrayList<sinh_vien> dssv;

		public DanhSachSinhVien() {
			this.dssv = new ArrayList<>();
		}
		
		
		public DanhSachSinhVien(ArrayList<sinh_vien> dssv) {
			this.dssv = dssv;
		}


		// 1 the sinh vien vao danh sach
		public void themSV_vaoDS(sinh_vien sv) {
			this.dssv.add(sv);
		}
		
		//2 in danh sach sinh vien ra ngoai man hinh
		public void inDSSV() {
			for (sinh_vien sinhVien : dssv) {
				System.out.println(sinhVien);
			}
		}
		
		//3 ktr danh sach co dong hay khong
		public boolean ktraDSCoGiongKHong() {
			return this.dssv.isEmpty();
		}
		
		//4 lay so luong sinh vien trong ds
		public int laySoLuong() {
			return this.dssv.size();
		}
		
		//5 lam rong danh sach sv
		public boolean xoaHetDSV() {
			return this.dssv.remove(dssv);
		}
		
		
		// 6kiem tra sinh vien co ton tai trong dach hay khong dua vao ma sinh vien
		
		public boolean ktraSVTonTai(String msv) {
			for(sinh_vien sv : this.dssv) {
				if(sv.maSinhVien.equals(msv)) return true;
			}
			
			return false;
				
		}
		// 7 xoa sinh sinh vien dua tren msv
		public boolean xoaSinhVien(sinh_vien sv) {
			return this.dssv.remove(sv);
		}
		
		// 8 Tìm kiếm tất cả sinh viên dựa trên Tên được nhập từ bàn phím.
		public void TK_duaTrenTen(String ten) {
			for (sinh_vien sinh_vien : dssv) {
				if(sinh_vien.hoVaTen.endsWith(ten))
					System.out.println(sinh_vien);
			}
		}
		
		// 9.	Xuất ra danh sách sinh viên có điểm từ cao đến thấp.
		public void sort_thoeDiemTB() {
			Collections.sort(this.dssv);
		}
		
		
		
	}
	
	static class Test{
		public static void main(String[] args) {
			DanhSachSinhVien ds_sv = new DanhSachSinhVien();
			Scanner sc = new Scanner(System.in);
			int luaChon=0;
			do {
				System.out.println("MENU ---------- ");
				System.out.println("Vui lòng chọn chức năng: ");
				System.out.println(
				  "1.	Thêm sinh viên vào danh sách.\n"
				+ "2.	In danh sách sinh viên ra màn hình.\n"
				+ "3.	Kiểm tra danh sách có rỗng hay không.\n"
				+ "4.	Lấy ra số lượng sinh viên trong danh sách.\n"
				+ "5.	Làm rỗng danh sách sinh viên.\n"
				+ "6.	Kiểm tra sinh viên có tồn tại trong danh sách hay không, dựa trên mã sinh viên.\n"
				+ "7.	Xóa một sinh viên ra khỏi danh sách dựa trên mã sinh viên.\n"
				+ "8.	Tìm kiếm tất cả sinh viên dựa trên Tên được nhập từ bàn phím.\n"
				+ "9.	Xuất ra danh sách sinh viên có điểm từ cao đến thấp.\n"
				+ "0.   Thoát khỏi chương trình");
				luaChon = sc.nextInt();
				sc.nextLine();
			
				if(luaChon==1) {
					System.out.println("nhap ma sinh vien: ");String maSinhVien = sc.nextLine() ;
					System.out.println("nhap ho va ten ");String hoVaTen = sc.nextLine() ;
					System.out.println("nhap nam sinh: ");int namSinh = sc.nextInt();
					System.out.println("nhap diem trung binh: ");double  diemTrungBinh = sc.nextDouble();
					
					sinh_vien sv = new sinh_vien(maSinhVien, hoVaTen, namSinh, diemTrungBinh);
					ds_sv.themSV_vaoDS(sv);
				}
				else if(luaChon==2) {
					ds_sv.inDSSV();
				}
				else if(luaChon==3) {// dang bij loi
					System.out.println(ds_sv.ktraDSCoGiongKHong());
				}
				else if(luaChon==4) {
					System.out.println("so luong sinh vien: "+ds_sv.laySoLuong());
				}
				else if(luaChon==5) {
					System.out.println("lam rong danh sach sinh vien: "+ds_sv.xoaHetDSV());
				}
				
				else if(luaChon==6) {
					String msv = sc.nextLine();
					System.out.println("sinh vien vua nhap co ton tai khong: "
					+ds_sv.ktraSVTonTai(msv));
				}
				
				else if(luaChon==7) {
					String msv = sc.nextLine();
					ds_sv.xoaSinhVien(new sinh_vien(msv));
				}
				else if(luaChon==8) {
					System.out.println("nhap ten muon tim");
					String ten = sc.nextLine();
					ds_sv.TK_duaTrenTen(ten);
				}
				else if(luaChon==9) {
					ds_sv.sort_thoeDiemTB();
					ds_sv.inDSSV();
				}
					
				
			}while(luaChon!=0);
		}
	}
	
	
}