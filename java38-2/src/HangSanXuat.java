
public class HangSanXuat {
	private String tenHangSanXuat;
	private QuocGia quocGia;
	
	public HangSanXuat(String tenHangSanXuat, QuocGia quocGia) {
		
		this.tenHangSanXuat = tenHangSanXuat;
		this.quocGia = quocGia;
	}

	public String getQuocGia() {
		return quocGia.getTenQuocGia();
	}

	
	
	
	
	
}
