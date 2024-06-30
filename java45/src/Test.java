public class Test {
	public static void main(String[] args) {
		HangSanXuat h1 = new HangSanXuat("Hãng 1", "Việt Nam");
		HangSanXuat h2 = new HangSanXuat("Hãng 2", "USA");
		HangSanXuat h3 = new HangSanXuat("Hãng 3", "Nhật Bản");
		
		
		MayBay p2 = new MayBay(h2, "Xăng");
		PhuongTienDiChuyen p3 = new XeDap(h3);
		
		
		p2.catCanh();
		
	}
}