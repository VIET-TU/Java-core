public class Test {
	public static void main(String[] args) {
		
		ToaDo td3 = new ToaDo(12, 1);
		
		Hinh hinh3 = new Hinh(td3);
		
		
		Hinh h3 = new HinhChuNhat(td3,5, 10);
		
		h3.InToaDoXY();
		
		
		
	}
}