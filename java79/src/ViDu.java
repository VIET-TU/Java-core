import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;

public class ViDu extends JFrame {
	public ViDu() {
		this.setTitle("hello work");
		this.setSize(600,600);
		this.setLocationRelativeTo(null);
		
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER,100,100);
//		FlowLayout fl = new Flow;
		
		this.setLayout(fl);
		
		JButton jb1 = new JButton("1");
		JButton jb2 = new JButton("2");
		JButton jb3 = new JButton("3");
		
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new ViDu();
	}
	
}
