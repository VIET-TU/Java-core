
public class BoPhim {
	private String tenPhim;
	private int namSanXuat;
	private HangSanXuat hangSanXuat;
	private double giaVe;
	private Ngay ngayChieu;
	
	public BoPhim(String tenPhim, int namSanXuat, HangSanXuat hangSanXuat, double giaVe, Ngay ngayChieu) {
		super();
		this.tenPhim = tenPhim;
		this.namSanXuat = namSanXuat;
		this.hangSanXuat = hangSanXuat;
		this.giaVe = giaVe;
		this.ngayChieu = ngayChieu;
	}
	
	public boolean kiemTraGiaVeReHon(BoPhim boPhimKhac) {
		return this.giaVe == boPhimKhac.giaVe;
	}
	
	public String layTenHangSanXuatPhim() {
		return this.tenPhim;
	}
	
	public double giaSauKhiKhuyenMai(double x) {
		return this.giaVe*(1-x/100);
	}
	
}
