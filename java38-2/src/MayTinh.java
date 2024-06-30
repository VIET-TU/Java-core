
public class MayTinh {
	private HangSanXuat hangSanXuat;
	private Ngay ngaySanXuat;
	private double giaBan;
	private double thoidGianBaoHanh;
	
	public MayTinh(HangSanXuat hangSanXuat, Ngay ngaySanXuat, double giaBan, double thoidGianBaoHanh) {		
		this.hangSanXuat = hangSanXuat;
		this.ngaySanXuat = ngaySanXuat;
		this.giaBan = giaBan;
		this.thoidGianBaoHanh = thoidGianBaoHanh;
	}
	
	public boolean kiemTraGiaBanThapHon(MayTinh mtKhac) {
		return this.giaBan == mtKhac.giaBan;
	}
	
	public String layTenQuocGia() {
		return this.hangSanXuat.getQuocGia();
	}
	
	
}
