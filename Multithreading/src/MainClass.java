import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		System.out.println("nhap một kí tự bất kì để quay số");
		( new Scanner(System.in)).nextLine();
		CountTheNumberThread thread = new CountTheNumberThread();
		thread.run();
		System.out.println("nhập một kí tự bất kì để dừng quay");
		( new Scanner(System.in)).nextLine();
		thread.end();
		
		System.out.println("con số may mắn " + thread.getCount());
	}
}
