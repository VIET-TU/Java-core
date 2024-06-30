package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.imageio.metadata.IIOMetadataFormatImpl;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//import com.mysql.cj.xdevapi.Table;

import controller.QLSV_controller;
import model.QLSV_model;
import model.Tinh;
import model.thiSinh_;

import javax.swing.JRadioButton;

public class QLSV_view extends JFrame {

	private JPanel contentPane;
	private JTextField textField_msv;
	private JTextField textField_hoVaTen;
	private JTextField textField_ngaySinh;
	private JTextField textField_mon1;
	private JTextField textField_mon2;
	private JTextField textField_mon3;
	private JComboBox comboBox_queQuan1;
	private JComboBox comboBox_queQuan_2;
	private JRadioButton radioButton_nam;
	private JRadioButton radioButton_nu;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnCapNhat;
	private JButton btnLuu;
	private JButton btnHuyBo;
	public ButtonGroup group_gioiTinh;
	private JTable table;
	public QLSV_model  model; 
	public Tinh tinh;
	private JTextField textField_msv_tk;
	private JButton btnNewButton_tim;

	private JButton btnNewButton_huyTim;
	private JLabel lblNewLabel_msv_tk;


	public QLSV_view() {
		this.setLocationRelativeTo(null);
		
		this.model = new QLSV_model();
		
		QLSV_controller ac = new QLSV_controller(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 741);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Open");
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Save");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Exit");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("About");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("About me");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox_queQuan1 = new JComboBox<String>(tinh.getDSTinh());

		
		comboBox_queQuan1.setBounds(112, 11, 140, 40);
		contentPane.add(comboBox_queQuan1);
		
		JLabel lblNewLabel = new JLabel("QuÃª quÃ¡n");
		lblNewLabel.setBounds(10, 17, 77, 22);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblNewLabel_msv_tk = new JLabel("MÃ£ thÃ­ Sinh");
		lblNewLabel_msv_tk.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_msv_tk.setBounds(279, 15, 89, 27);
		contentPane.add(lblNewLabel_msv_tk);
		
		btnNewButton_tim = new JButton("TÃ¬m");
		btnNewButton_tim.addActionListener(ac);
		btnNewButton_tim.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_tim.setBounds(523, 11, 77, 40);
		contentPane.add(btnNewButton_tim);
		
		btnNewButton_huyTim = new JButton("Há»§y tÃ¬m");
		btnNewButton_huyTim.addActionListener(ac);
		
		btnNewButton_huyTim.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_huyTim.setBounds(610, 11, 119, 40);
		contentPane.add(btnNewButton_huyTim);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 60, 709, 2);
		contentPane.add(separator_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 sinh vi\u00EAn", "H\u1ECD v\u00E0 t\u00EAn", "Qu\u00EAn qu\u00E1n","NgÃ y sinh", "Gi\u1EDBi t\u00EDnh", "\u0110i\u1EC3m m\u00F4n 1", "\u0110i\u1EC3m m\u00F4n 2", "\u0110i\u1EC3m m\u00F4n 3"
			}
		));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 107, 709, 250);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel_2 = new JLabel("Danh sÃ¡ch thÃ­ sinh");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(10, 62, 257, 34);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 378, 709, 2);
     		contentPane.add(separator_1_1);
		
		JLabel lable_QueQuan_2 = new JLabel("MÃ£ thÃ­ Sinh");
		lable_QueQuan_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lable_QueQuan_2.setBounds(10, 406, 80, 22);
		contentPane.add(lable_QueQuan_2);
		
		textField_msv = new JTextField();
		textField_msv.setColumns(10);
		textField_msv.setBounds(112, 403, 193, 32);
		contentPane.add(textField_msv);
		
		JLabel lable_QueQuan_2_1 = new JLabel("Há»� vÃ  tÃªn");
		lable_QueQuan_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lable_QueQuan_2_1.setBounds(10, 449, 80, 22);
		contentPane.add(lable_QueQuan_2_1);
		
		JLabel lable_QueQuan_2_2 = new JLabel("QuÃªn quÃ¡n");
		lable_QueQuan_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lable_QueQuan_2_2.setBounds(10, 497, 80, 22);
		contentPane.add(lable_QueQuan_2_2);
		
		JLabel lable_QueQuan_2_3 = new JLabel("NgÃ y sinh");
		lable_QueQuan_2_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lable_QueQuan_2_3.setBounds(10, 547, 80, 22);
		contentPane.add(lable_QueQuan_2_3);
		
		textField_hoVaTen = new JTextField();
		textField_hoVaTen.setColumns(10);
		textField_hoVaTen.setBounds(112, 452, 193, 32);
		contentPane.add(textField_hoVaTen);
		
		comboBox_queQuan_2 = new JComboBox<String>(tinh.getDSTinh());
		comboBox_queQuan_2.setBounds(112, 499, 193, 29);
		contentPane.add(comboBox_queQuan_2);
		
		textField_ngaySinh = new JTextField();
		textField_ngaySinh.setColumns(10);
		textField_ngaySinh.setBounds(112, 537, 193, 32);
		contentPane.add(textField_ngaySinh);
		
		JLabel lable_QueQuan_2_4 = new JLabel("Giá»›i tÃ­nh");
		lable_QueQuan_2_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lable_QueQuan_2_4.setBounds(393, 412, 80, 22);
		contentPane.add(lable_QueQuan_2_4);
		
		
		
		radioButton_nam = new JRadioButton("Nam");
		radioButton_nam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radioButton_nam.setBounds(502, 412, 66, 23);
		contentPane.add(radioButton_nam);
		
		
		radioButton_nu = new JRadioButton("Ná»¯");
		radioButton_nu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radioButton_nu.setBounds(595, 412, 110, 23);
		contentPane.add(radioButton_nu);
		
		
		group_gioiTinh = new ButtonGroup();
		group_gioiTinh.add(radioButton_nam);
		group_gioiTinh.add(radioButton_nu);
		
		
		
		JLabel lable_QueQuan_2_5 = new JLabel("MÃ´n 1");
		lable_QueQuan_2_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lable_QueQuan_2_5.setBounds(393, 455, 80, 22);
		contentPane.add(lable_QueQuan_2_5);
		
		JLabel lable_QueQuan_2_5_1 = new JLabel("MÃ´n 2");
		lable_QueQuan_2_5_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lable_QueQuan_2_5_1.setBounds(393, 503, 80, 22);
		contentPane.add(lable_QueQuan_2_5_1);
		
		JLabel lable_QueQuan_2_5_2 = new JLabel("MÃ´n 3");
		lable_QueQuan_2_5_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lable_QueQuan_2_5_2.setBounds(393, 553, 80, 22);
		contentPane.add(lable_QueQuan_2_5_2);
		
		textField_mon1 = new JTextField();
		textField_mon1.setColumns(10);
		textField_mon1.setBounds(474, 452, 193, 32);
		contentPane.add(textField_mon1);
		
		textField_mon2 = new JTextField();
		textField_mon2.setColumns(10);
		textField_mon2.setBounds(474, 500, 193, 32);
		contentPane.add(textField_mon2);
		
		textField_mon3 = new JTextField();
		textField_mon3.setColumns(10);
		textField_mon3.setBounds(474, 550, 193, 32);
		contentPane.add(textField_mon3);
		
		btnThem = new JButton("ThÃªm");
		btnThem.addActionListener(ac);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThem.setBounds(10, 618, 116, 44);
		contentPane.add(btnThem);
		
		btnXoa = new JButton("XÃ³a");
		btnXoa.addActionListener(ac);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoa.setBounds(160, 618, 107, 44);
		contentPane.add(btnXoa);
		
		btnCapNhat = new JButton("Cáº­p nháº­t");
		btnCapNhat.addActionListener(ac);
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCapNhat.setBounds(309, 618, 110, 44);
		contentPane.add(btnCapNhat);
		
		btnLuu = new JButton("LÆ°u");
		btnLuu.addActionListener(ac);
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLuu.setBounds(458, 618, 110, 44);
		contentPane.add(btnLuu);
		
		btnHuyBo = new JButton("Há»§y bá»�");
		btnHuyBo.addActionListener(ac);
		btnHuyBo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHuyBo.setBounds(595, 618, 123, 44);
		contentPane.add(btnHuyBo);
		
		textField_msv_tk = new JTextField();
		textField_msv_tk.setBounds(373, 11, 140, 40);
		contentPane.add(textField_msv_tk);
		textField_msv_tk.setColumns(10);
		
		this.setVisible(true);
		this.tuDongThemVaoTable();
		
	}
	
	
	//******* láº­p trÃ¬nh cho cÃ¡c nÃºt**********///
	
	
	
	// tá»± Ä‘Ã´ng thÃªm dá»¯ liá»‡u vÃ o báº£ng tá»« database
	public void tuDongThemVaoTable() {
		if(model.findAll()== null) System.out.println("null rá»“i báº¡n ei");
		else {for (thiSinh_ ts : model.findAll()) {
			themThongTinVaoTable(ts);
			}
		}
		
	}
	
	
	
	// xÃ³a thÃ´ng tin á»Ÿ textfild
	public void xoaFrom() {
		this.textField_msv.setText("");
		this.textField_hoVaTen.setText("");
		this.comboBox_queQuan_2.setSelectedIndex(-1);
		this.textField_ngaySinh.setText("");
		this.group_gioiTinh.clearSelection();
		this.textField_mon1.setText("");
		this.textField_mon2.setText("");
		this.textField_mon3.setText("");
	}
	
	// thÃªm sinh viÃªn vÃ o table
	public void themThongTinVaoTable(thiSinh_ ts) {

		DefaultTableModel model_talbe = (DefaultTableModel) table.getModel();
		model_talbe.addRow(new Object[] {ts.getMsv()+"",ts.getHoVaTen(),ts.getQueQuan(),(ts.getNgaySin().getYear()+1900)+"-"+(ts.getNgaySin().getMonth()+1)+"-"+ts.getNgaySin().getDate()
			,(ts.isGioiTinh() ? "Nam" : "Ná»¯"), ts.getMon1()+"",ts.getMon2()+"",ts.getMon3()+""
			
		});
	}
	
	public void themHoacCapNhatThiSinh(thiSinh_ ts) {
		// láº¥y háº¿t hÃ ng vÃ  cá»™t cá»§a table
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if(model.insert(ts)!=0) {System.out.println("da thuc hien insert"); themThongTinVaoTable(ts);}
		else  { 
			try {
				model.update(ts);
				System.out.println("da thuc hien update");
				
				// láº¥y sá»‘ lÆ°á»£ng dÃ²ng cá»§a báº£ng
				int soLuongDong = model_table.getRowCount();
				for(int i=0;i<soLuongDong;i++) {
					String id = model_table.getValueAt(i,0).toString();
					if(id.equals(ts.getMsv()+"")) {
						model_table.setValueAt(ts.getHoVaTen() , i, 1);
						model_table.setValueAt(ts.getQueQuan() , i, 2);
						model_table.setValueAt((ts.getNgaySin().getYear()+1900)+"-"+(ts.getNgaySin().getMonth()+1)+"-"+ts.getNgaySin().getDate(), i, 3);
						model_table.setValueAt((ts.isGioiTinh() ? "Nam" : "Ná»¯"), i, 4);
						model_table.setValueAt(ts.getMon1() + "", i, 5);
						model_table.setValueAt(ts.getMon2() + "", i, 6);
						model_table.setValueAt(ts.getMon3() + "", i, 7);
					}
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public thiSinh_ layThiSinhDangChon() {
		System.out.println("do báº¥m nut cáº­p nháº­t -> laYthi Sinh Ä‘ang chá»�n");
		// láº¥y háº¿t hÃ ng vÃ  cá»™t cá»§a table
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		
		// láº¥y hÃ ng ngÆ°á»�i dÃ¹ng chá»�n
		int i_row = table.getSelectedRow();
		
		int msv =Integer.valueOf( model_table.getValueAt(i_row,0)+"") ;
		String hoTen = model_table.getValueAt(i_row,1)+"";
		String queQuan = model_table.getValueAt(i_row,2)+"";
		
		System.out.println("sai o truoc date");
		String date = model_table.getValueAt(i_row, 3)+"";
		System.out.println(date);
		
		Date ngaySinh = Date.valueOf(date);
		
		System.out.println("sai á»Ÿ sau date");
		
		boolean gt = (model_table.getValueAt(i_row,4).toString() == "Nam" ) ? true : false;
		
		double mon1 = Double.valueOf(model_table.getValueAt(i_row,5)+"");
		double mon2 = Double.valueOf(model_table.getValueAt(i_row,6)+"");
		double mon3 = Double.valueOf(model_table.getValueAt(i_row,7)+"");
		
		thiSinh_ ts = new thiSinh_(msv, hoTen, queQuan, ngaySinh, gt, mon1, mon2, mon3);
		
		return ts;
	}
	
	public void thucHienThemThiSinh() {
		int msv = Integer.valueOf(this.textField_msv.getText()+"");
		String hoVaTen = this.textField_hoVaTen.getText()+"";
		System.out.println(hoVaTen);
		String queQuan = this.comboBox_queQuan_2.getSelectedItem()+"";
		
		String date = this.textField_ngaySinh.getText()+"";
		System.out.println(date);
		Date ngaySinh = Date.valueOf(date);		
		boolean gioiTinh;
		if(this.radioButton_nam.isSelected()) gioiTinh = true;
		else gioiTinh = false;
		double mon1= Double.valueOf(this.textField_mon1.getText()+"");
		double mon2= Double.valueOf(this.textField_mon2.getText()+"");
		double mon3= Double.valueOf(this.textField_mon3.getText()+"");
		
		thiSinh_ ts = new thiSinh_(msv, hoVaTen, queQuan, ngaySinh,gioiTinh, mon1, mon2, mon3);
		
		System.out.println("da lay thong tin tu bang");
		themHoacCapNhatThiSinh(ts);
	}
	
	
	// cáº­p nháº­t thÃ­ sinh
	public void hienThiThongTinThiSinh_vaoTable() {
		thiSinh_ ts = layThiSinhDangChon();
		
		this.textField_msv.setText(ts.getMsv()+"");
		this.textField_hoVaTen.setText(ts.getHoVaTen());
		this.comboBox_queQuan_2.setSelectedItem(ts.getQueQuan());
		this.textField_ngaySinh.setText((ts.getNgaySin().getYear()+1900)+"-"+(ts.getNgaySin().getMonth()+1)+"-"+ts.getNgaySin().getDate());
		if(ts.isGioiTinh()) {
			this.radioButton_nam.setSelected(true);
		}else this.radioButton_nu.setSelected(true);
		this.textField_mon1.setText(ts.getMon1()+"");
		this.textField_mon2.setText(ts.getMon2()+"");
		this.textField_mon3.setText(ts.getMon3()+"");
		
	}
	
	// code nÃºt xÃ³a
	public void thuHienXoa() {
			thiSinh_ ts = layThiSinhDangChon();
		
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		
		// láº¥y hÃ ng ngÆ°á»�i dÃ¹ng chá»�n
			int i_row = table.getSelectedRow();
		
			
		int luaChon = JOptionPane.showConfirmDialog(this,"Báº¡n cÃ³ cháº¯c cháº¯n muá»‘n xÃ³a","ThÃ´ng bÃ¡o", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
		if(luaChon==JOptionPane.YES_OPTION) {
			model_table.removeRow(i_row);
			model.delete(ts);
		
		}
	}
	
	// thá»±c hiá»‡n tÃ¬m kiáº¿m
	public void thuHienTim() {
//		this.tuDongThemVaoTable();
		
		this.model.msv_model.clear();
		this.thuHienTaiLaiDuLieu();
		
		Set<Integer> msv = new HashSet<>();
		String quen_quan_tk = this.comboBox_queQuan1.getSelectedItem()+"";
		String msv_tk = this.textField_msv_tk.getText()+"";
		System.out.println(quen_quan_tk);
		if(quen_quan_tk.length()>0) {
			msv.addAll(this.model.timKiem_queQuan(quen_quan_tk));
		}
		System.out.println("ma sinh vien: "+msv_tk);
		if(msv_tk.length()>0) {
			msv.addAll(this.model.timKiem_msv(Integer.valueOf(msv_tk)));
		}
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		
		// láº¥y hÃ ng ngÆ°á»�i dÃ¹ng chá»�n
			int i_row = table.getRowCount();
			
			for(int id : msv) {
				for(int i=0;i<i_row;i++) {
					int id_table = Integer.valueOf(model_table.getValueAt(i,0)+"");
					if(id == id_table) {
						try {
							model_table.removeRow(i);
						}catch (Exception e) {
							// TODO: handle exception
						}
						break;
						
					}
				}
			}
	}
	
	public void thuHienTaiLaiDuLieu()  {
		// láº¥y sá»‘ lÆ°á»£ng báº£n ghi trong database
//		Connection conn = this.model.getConnection();
//		Statement stmt = conn.createStatement();
//		ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM thi_sinh");
//			rs.next();
			
			
		
		
		
		while(true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			if(soLuongDong==0)
				break;
			else {
				try {
					model_table.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		this.tuDongThemVaoTable();
		
	}
	
	public void thucHienHuyBo() {
		this.comboBox_queQuan1.setSelectedIndex(-1);
		textField_msv_tk.setText("");
		thuHienTaiLaiDuLieu();
	}
	
		
	
	
	public static void main(String[] args) {
		new QLSV_view();
	}
}
