public class MyThread extends Object {
     
    long amount = 5000000; // Số tiền có trong tài khoản
    String accountName = "";
     
    public MyThread(String accountName) {
        this.accountName = accountName;
    }
 
    public synchronized void withdraw(long withdrawAmount) {
        // In ra trạng thái bắt đầu trừ tiền
        System.out.println(accountName + " withdrawing...");
         
        // Trừ tiền
        amount -= withdrawAmount;
        System.out.println("sau khi tru tien của " +accountName+": "+amount);
    }
     
    public synchronized void deposit(long depositAmount) {
        // In ra trạng thái bắt đầu nạp tiền
        System.out.println(accountName + " depositting...");
         
        // Nạp tiền
        amount += depositAmount;
        System.out.println("sau khi tru tien của " +accountName+": "+amount);
        
    }
     
    public synchronized void transferTo(MyThread toAccount, long transferAmount) {
        
            // Rút tiền từ tài khoản này
            this.withdraw(transferAmount);
             
            
                // Nạp tiền vào toAccount
                toAccount.deposit(transferAmount);
            
             
            // In số dư tài khoản khi kết thúc quá trình chuyển tiền
            System.out.println("The amount of " + accountName + " is: " + amount);
        
    }
    
    public static void main(String[] args) {
        // Khai báo tài khoản của anh chồng và cô vợ riêng
        MyThread husbandAccount = new MyThread("Husband's Account");
        MyThread wifeAccount = new MyThread("Wife's Account");
     
        // Anh chồng muốn chuyển 3 triệu từ tài khoản của ảnh qua tài khoản cô vợ
        Thread husbandThread = new Thread() {
            @Override
            public void run() {
                husbandAccount.transferTo(wifeAccount, 3000000);
            }
        };
     
        // Cô vợ muốn chuyển 2 triệu từ tài khoản của cổ qua tài khoản của anh chồng
        Thread wifeThread = new Thread() {
            @Override
            public void run() {
                wifeAccount.transferTo(husbandAccount, 2000000);
            }
        };
     
        // Hai người thực hiện lệnh chuyển tiền gần như đồng thời
        husbandThread.start();
        wifeThread.start();
    }
}


