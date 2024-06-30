import java.util.Objects;

public class SinhVien {
	private String maSinhVien;
	private String hoVaTen;
	private Ngay ngaySinh;
	private double diemTrungBinh;
	private Lop lop;
	
	
	public SinhVien(String maSinhVien, String hoVaTen, Ngay ngaySinh, double diemTrungBinh, Lop lop) {
		super();
		this.maSinhVien = maSinhVien;
		this.hoVaTen = hoVaTen;
		this.ngaySinh = ngaySinh;
		this.diemTrungBinh = diemTrungBinh;
		this.lop = lop;
	}
	

	public String layTenKhoa() {
		return this.lop.getTenKhoa();
	}
	
	public boolean kiemTraThiDau() {
		return this.diemTrungBinh >=5.0;
	}


	public boolean kiemTraNgaySinh(SinhVien svKhac) {
		return this.ngaySinh.equals(svKhac.ngaySinh);
	}
	
	
	
}
