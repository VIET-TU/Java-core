package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.CounterView;

public class CounterListener implements ActionListener {
	private CounterView cv;
	
	public CounterListener(CounterView cv) {
		this.cv = cv;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String sc = e.getActionCommand();
		System.out.println("ban vua nhan nut "+sc);
		
		if(sc.equals("UP")) this.cv.increment();
		
		if(sc.equals("DOWN")) this.cv.decrement();
		
	}
	
}
