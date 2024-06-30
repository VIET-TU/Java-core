package menuView;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

import controller.MenuController;
import menuModel.MenuModel;

public class MenuView extends JFrame{
	public MenuModel menuModel;
	private JRadioButton jRadioButton_com;
	private JRadioButton jRadioButton_pho;
	private JRadioButton jRadioButton_banhMi;
	private JCheckBox jCheckBox_cocacola;
	private JCheckBox jCheckBox_banhNgot;
	private JCheckBox jCheckBox_nem;
	private JCheckBox jCheckBox_traSua;

	public JLabel jLabel_thanhToan;
	private JButton jButton_thanhToan;
	public ButtonGroup buttonGroup_monChinh;
	public ArrayList<JCheckBox> arrayLis_monPhu;
	public JComboBox<String> jComboBox_monChinh;
	public JList<String> jList_monPhu;

	public MenuView()  {
		this.menuModel = new MenuModel();
		this.init();
	}

	private void init() {
		this.setTitle("menu mon an");
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		MenuController mc = new MenuController(this);
		
		JPanel jPanel_monChinh = new JPanel(new BorderLayout(20,20));
		Font font = new Font("Arial",Font.BOLD,20);
		String[] cacMonChinh = new String[] {"CƠM","PHỞ","BÁNH MÌ"};
		jComboBox_monChinh = new JComboBox<String>(cacMonChinh);
		jComboBox_monChinh.setFont(font);
		jPanel_monChinh.add(jComboBox_monChinh,BorderLayout.CENTER);
		
		JPanel jPanel_monPhu = new JPanel(new BorderLayout());
		String[] monPhu = new String[] {"cocacola","bánh ngọt","nem","trà sữa"};
		jList_monPhu = new JList<String>(monPhu);
		jList_monPhu.setFont(font);
		jPanel_monPhu.add(jList_monPhu,BorderLayout.CENTER);
		
		
		Font font_thanhToan = new Font("Arial",Font.BOLD,20);
		JPanel jPanel_thanhToan = new JPanel(new GridLayout(1,2,10,10));
		jLabel_thanhToan = new JLabel();
		jLabel_thanhToan.setFont(font_thanhToan);
		jButton_thanhToan = new JButton("Thanh toán");
		jButton_thanhToan.addActionListener(mc);
		jButton_thanhToan.setFont(font_thanhToan);
		jPanel_thanhToan.add(jButton_thanhToan);
		jPanel_thanhToan.add(jLabel_thanhToan);
		
		this.setLayout(new BorderLayout());
		this.add(jPanel_monChinh,BorderLayout.NORTH);
		this.add(jPanel_monPhu, BorderLayout.CENTER);
		this.add(jPanel_thanhToan, BorderLayout.SOUTH);
		
		this.setVisible(true);
		
		
	}
	
	public void hienThiKetQua() {
		String kq ="Món chinh: " + this.menuModel.getMonChinh() + "; "
				+ "món phụ: " +  this.menuModel.getMonPhu() + " "
				+ "tông: " + String.valueOf(this.menuModel.getTongTien());
		this.jLabel_thanhToan.setText(kq);
	}
	
	
}
