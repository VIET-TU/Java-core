public class Test {
	 enum Season {
	        SPRING(5), SUMMER(10), FALL(15), WINTER(30);

			Season(int i) {
				// TODO Auto-generated constructor stub
			}
	 
//	        private int value;
//	 
//	        Season(int valuea) {
//	            this.value = valuea;
//	        }
	    }
	 
	    public static void main(String args[]) {
	        for (Season s : Season.values()) {
	            System.out.println( s);
	        }
	    }
}