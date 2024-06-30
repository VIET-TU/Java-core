class BankAccount {
     
    long amount = 5000000; // Số tiền có trong tài khoản 
     
    public  boolean checkAccountBalance(long withDrawAmount) {
        // Giả lập thời gian đọc cơ sở dữ liệu và kiểm tra tiền
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         
        if (withDrawAmount <= amount) {
            // Cho phép rút tiền
            return true;
        }
         
        // Không cho phép rút tiền
        return false;
    }
     
    
    public synchronized void withdrawWhenBalanceEnough(String threadName, long withdrawAmount) {
        // In thông tin người rút
        System.out.println(threadName + " check: " + withdrawAmount);
        while (!checkAccountBalance(withdrawAmount)) {
            // Nếu không đủ tiền, thì đợi cho đến khi có đủ tiền thì rút
            System.out.println(threadName + " wait for balance enough");
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        // Đủ tiền, hoặc không còn đợi nữa, thì được phép rút
        // Giả lập thời gian rút tiền và
        // cập nhật số tiền còn lại vào cơ sở dữ liệu
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        amount -= withdrawAmount;
        System.out.println(threadName + " withdraw successful: " + withdrawAmount);
        System.out.println(amount);
    }
    public synchronized void deposit(String threadName, long depositAmount) {
        // In thông tin người nạp tiền
        System.out.println(threadName + " deposit: " + depositAmount);
        // Giả lập thời gian nạp tiền và
        // cập nhật số tiền mới vào cơ sở dữ liệu
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        amount += depositAmount;
        System.out.println(amount);
        // Đánh thức đối tượng đang ngủ và chờ có tiền thì rút
        notifyAll();
        System.out.println("deposit done");
    }

}
class WithdrawThread extends Thread {
	 
    String threadName = "";
    long withdrawAmount = 0;
    BankAccount bankAccount;
     
    public WithdrawThread(String threadName, BankAccount bankAccount, long withdrawAmount) {
        this.threadName = threadName;
        this.bankAccount = bankAccount;
        this.withdrawAmount = withdrawAmount;
    }
     
    @Override
    public void run() {
    	 bankAccount.withdrawWhenBalanceEnough(threadName, withdrawAmount);
        
    }
}

class DepositThread extends Thread {
	 
    String threadName = "";
    long depositAmount = 0;
    BankAccount bankAccount;
 
    public DepositThread(String threadName, BankAccount bankAccount, long depositAmount) {
        this.threadName = threadName;
        this.bankAccount = bankAccount;
        this.depositAmount = depositAmount;
    }
 
    @Override
    public void run() {
        bankAccount.deposit(threadName, depositAmount);
    }
}

public class MuatualEclusive {
    
		public static void main(String[] args) {
	        BankAccount bankAccount = new BankAccount();

	     // Người chồng rút 15 triệu
	        WithdrawThread husbandThread = new WithdrawThread("Husband", bankAccount, 10000000);
	        husbandThread.start();
	        
	        // Anh chồng nạp vào 5 triệu VND
	        DepositThread other = new DepositThread("Other", bankAccount, 5000000);
	        other.start();
	       
	        // Người vợ rút hết tiền (20 triệu)
	        WithdrawThread wifeThread = new WithdrawThread("Wife", bankAccount, 10000000);
	        wifeThread.start();
	        
	         
	             
	     
		}
}


