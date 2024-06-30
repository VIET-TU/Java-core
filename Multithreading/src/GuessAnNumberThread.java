import java.util.Scanner;

public class GuessAnNumberThread {
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Nhập một số nguyên để các thread đoán: ");
	    int guessNumber = scanner.nextInt();
	         
	    Runnable anonymousGuessANumber = new Runnable() {
	             
	        @Override
	        public void run() {
	            int randomNumber = 0;
	            int count = 0;
	            do {
	                randomNumber = (int) (Math.random() * 100 + 1);
	                count++;
	                System.out.println(Thread.currentThread().getName() + " đoán số " + randomNumber);
	                     
	                
	            } while (randomNumber != guessNumber);
	                 
	            System.out.println(Thread.currentThread().getName() + " đã đoán ra số " + guessNumber + " trong " + count + " lần đếm");
	        }
	    };
	         
	    Thread thread1 = new Thread(anonymousGuessANumber); 
	    thread1.setName("Thread 1");
	         
	    Thread thread2 = new Thread(anonymousGuessANumber);
	    thread2.setName("Thread 2");
	         
	    thread1.start();
	    thread2.start();
	}
}
