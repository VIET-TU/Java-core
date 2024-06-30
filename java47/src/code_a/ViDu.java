package code_a;


public class ViDu {

	 
		static int count=0; //se lay bo nho chi mot lan và giu lai gia tri cua no  
		 //ket qua thuc hien in ra 3 dong cac gia tri : 1,2,3 
		public ViDu() {
			// TODO Auto-generated constructor stub
		 
		count++;  
		System.out.println(count);  
		}  
		public void adc() {
			count = 100;
		}

		public static void main(String args[]){  

		ViDu v1 =new ViDu();
		
		v1.adc();
		ViDu v2 =new ViDu();
		ViDu v3 =new ViDu();

	}  
		
}
