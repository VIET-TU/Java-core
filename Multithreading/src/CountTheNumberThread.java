
public class CountTheNumberThread {
	int count =0;
	boolean isStop = false;
	public void run() {
		while(!isStop) {
			count++;
			
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}	
		}	
	}
	
	public void end() {
			this.isStop = true;
		}
		
		public int getCount() {
			return count;
		}
		
}
