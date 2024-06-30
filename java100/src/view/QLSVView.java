package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.QLSVModel;
import model.ThiSinh;
import model.Tinh;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.table.DefaultTableModel;

import controller.QLSVController;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;

public class QLSVView extends JFrame {
	private Tinh tinh;
	ThiSinh thiSinh;
	private JPanel contentPane;
	public QLSVModel model;
	
	private JTextField jTextFild_maThiSinh_timKiem;
	private JTable table;
	public JTextField textField_MSV;
	public JTextField textField_HVT;
	public JTextField textField_ngaySinh;
	public JTextField textField_mon1;
	public JTextField textField_mon2;
	public JTextField textField_mon3;
	public ButtonGroup group_gioiTinh;
	public JComboBox comboBox_queQuan;
	public JRadioButton radioButton_nam;
	public JRadioButton radioButton_nu;
	public JComboBox  comboBox_queQuan_timKiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSVView frame = new QLSVView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QLSVView() {
		this.tinh = new Tinh();
		this.model = new QLSVModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 707);
		
		//khởi tạo hàm ationListener
		QLSVController action = new QLSVController(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(menuFile);
		
		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(action);
		menuFile.add(menuOpen);
		
		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(action);
		menuFile.add(menuSave);
		
	
		
		JSeparator separator = new JSeparator();
		menuFile.add(separator);
		
		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(action);
		menuFile.add(menuExit);
		
		JMenu menuAbout = new JMenu("About");
		menuAbout.addActionListener(action);
		menuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(menuAbout);
		
		JMenuItem menuAboutMe = new JMenuItem("About me");
		menuAboutMe.addActionListener(action);
		menuAbout.add(menuAboutMe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lable_QueQuan = new JLabel("Quê quán");
		lable_QueQuan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lable_QueQuan.setBounds(7, 20, 80, 22);
		contentPane.add(lable_QueQuan);
		
		
		comboBox_queQuan_timKiem = new JComboBox();		
		for(String tinh : this.tinh.getDSTinh())
			comboBox_queQuan_timKiem.addItem(tinh);
		
		comboBox_queQuan_timKiem.setBounds(97, 11, 159, 44);
		contentPane.add(comboBox_queQuan_timKiem);
		
		JLabel lable_maThiSinh = new JLabel("Mã thí sinh");
		lable_maThiSinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lable_maThiSinh.setBounds(279, 17, 110, 29);
		contentPane.add(lable_maThiSinh);
		
		jTextFild_maThiSinh_timKiem = new JTextField();
		jTextFild_maThiSinh_timKiem.setBounds(379, 11, 150, 44);
		contentPane.add(jTextFild_maThiSinh_timKiem);
		jTextFild_maThiSinh_timKiem.setColumns(10);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.addActionListener(action);
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTim.setBounds(545, 11, 66, 44);
		contentPane.add(btnTim);
		
		JButton btnHuyTim = new JButton("Hủy tìm");
		btnHuyTim.addActionListener(action);
		btnHuyTim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHuyTim.setBounds(626, 9, 90, 44);
		contentPane.add(btnHuyTim);
		
		JLabel lable_QueQuan_1 = new JLabel("Danh sách thí sinh");
		lable_QueQuan_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lable_QueQuan_1.setBounds(7, 90, 193, 22);
		contentPane.add(lable_QueQuan_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(7, 75, 709, 2);
		contentPane.add(separator_1);
		
		
		///////// setup file 
		
		/// khởi tạo tạo Jtable///////
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 th\u00ED sinh", "H\u1ECD t\u00EAn", "Qu\u00EA qu\u00E1n", "Ng\u00E0y sinh", "Gi\u1EDBi t\u00EDnh", "\u0110i\u1EC3m 1", "\u0110i\u1EC3m 2", "\u0110i\u1EC3m 3"
			}
		));
		
		// xét chiều cao cho hàng trong talbe
		table.setRowHeight(25);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(7, 123,709, 199);
		contentPane.add(scrollPane);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(7, 333, 709, 2);
		contentPane.add(separator_1_1);
		
		JLabel lable_QueQuan_2 = new JLabel("Mã thí Sinh");
		lable_QueQuan_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lable_QueQuan_2.setBounds(17, 354, 80, 22);
		contentPane.add(lable_QueQuan_2);
		
		textField_MSV = new JTextField();
		textField_MSV.setColumns(10);
		textField_MSV.setBounds(107, 351, 193, 32);
		contentPane.add(textField_MSV);
		
		JLabel lable_QueQuan_2_1 = new JLabel("Họ và tên");
		lable_QueQuan_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lable_QueQuan_2_1.setBounds(17, 402, 80, 22);
		contentPane.add(lable_QueQuan_2_1);
		
		JLabel lable_QueQuan_2_2 = new JLabel("Quê quán");
		lable_QueQuan_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lable_QueQuan_2_2.setBounds(17, 452, 80, 22);
		contentPane.add(lable_QueQuan_2_2);
		
		JLabel lable_QueQuan_2_3 = new JLabel("Ngày sinh");
		lable_QueQuan_2_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lable_QueQuan_2_3.setBounds(17, 508, 80, 22);
		contentPane.add(lable_QueQuan_2_3);
		
		comboBox_queQuan = new JComboBox();
		for(String tinh : this.tinh.getDSTinh())
			comboBox_queQuan.addItem(tinh);
		comboBox_queQuan.setBounds(107, 451, 193, 29);
		contentPane.add(comboBox_queQuan);
		
		textField_HVT = new JTextField();
		textField_HVT.setColumns(10);
		textField_HVT.setBounds(107, 399, 193, 32);
		contentPane.add(textField_HVT);
		
		textField_ngaySinh = new JTextField();
		textField_ngaySinh.setColumns(10);
		textField_ngaySinh.setBounds(107, 505, 193, 32);
		contentPane.add(textField_ngaySinh);
		
		JLabel lable_QueQuan_2_4 = new JLabel("Giới tính");
		lable_QueQuan_2_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lable_QueQuan_2_4.setBounds(363, 360, 80, 22);
		contentPane.add(lable_QueQuan_2_4);
		
		radioButton_nam = new JRadioButton("Nam");
		radioButton_nam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radioButton_nam.setBounds(440, 360, 66, 23);
		contentPane.add(radioButton_nam);
		
		radioButton_nu = new JRadioButton("Nữ");
		radioButton_nu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radioButton_nu.setBounds(518, 360, 110, 23);
		contentPane.add(radioButton_nu);
		
		group_gioiTinh = new ButtonGroup();
		group_gioiTinh.add(radioButton_nam);
		group_gioiTinh.add(radioButton_nu);
		
		JLabel lable_QueQuan_2_5 = new JLabel("Môn 1");
		lable_QueQuan_2_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lable_QueQuan_2_5.setBounds(363, 402, 80, 22);
		contentPane.add(lable_QueQuan_2_5);
		
		JLabel lable_QueQuan_2_6 = new JLabel("Môn 2");
		lable_QueQuan_2_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lable_QueQuan_2_6.setBounds(363, 458, 80, 22);
		contentPane.add(lable_QueQuan_2_6);
		
		JLabel lable_QueQuan_2_7 = new JLabel("Môn 3");
		lable_QueQuan_2_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lable_QueQuan_2_7.setBounds(363, 514, 80, 22);
		contentPane.add(lable_QueQuan_2_7);
		
		textField_mon1 = new JTextField();
		textField_mon1.setColumns(10);
		textField_mon1.setBounds(468, 399, 193, 32);
		contentPane.add(textField_mon1);
		
		textField_mon2 = new JTextField();
		textField_mon2.setColumns(10);
		textField_mon2.setBounds(468, 452, 193, 32);
		contentPane.add(textField_mon2);
		
		textField_mon3 = new JTextField();
		textField_mon3.setColumns(10);
		textField_mon3.setBounds(468, 508, 193, 32);
		contentPane.add(textField_mon3);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(7, 561, 709, 2);
		contentPane.add(separator_1_1_1);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(action);
		
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThem.setBounds(0, 586, 116, 44);
		contentPane.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(action);
		
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoa.setBounds(151, 586, 107, 44);
		contentPane.add(btnXoa);
		
		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.addActionListener(action);
		
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCapNhat.setBounds(291, 586, 110, 44);
		contentPane.add(btnCapNhat);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(action);
		
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLuu.setBounds(440, 586, 110, 44);
		contentPane.add(btnLuu);
		
		JButton btnHuyBo = new JButton("Hủy bỏ");
		btnHuyBo.addActionListener(action);
		
		btnHuyBo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHuyBo.setBounds(587, 586, 123, 44);
		contentPane.add(btnHuyBo);
	}
		
		// xóa dòng vừa chọn 
		public void xoaForm() {		
			this.textField_MSV.setText("");
			this.textField_HVT.setText("");
			this.textField_ngaySinh.setText("");
			this.textField_mon1.setText("");
			this.textField_mon2.setText("");
			this.textField_mon3.setText("");
			this.comboBox_queQuan.setSelectedIndex(-1); // Xóa lựa chọn sao cho không có nút nào trong Nhóm nút được chọn.

			this.group_gioiTinh.clearSelection(); // xóa chọn radionbutton
		
	}
		
	// update sinh viên vào table
	public void themSinhVienVaoTable(ThiSinh ts) {
		DefaultTableModel talble_model = (DefaultTableModel) table.getModel();
		talble_model.addRow(new Object[] {
				ts.maxThiSinh+"", 
				ts.tenThiSinh,
				ts.queQuan,
				ts.ngaySinh.getDate()+"/"+(ts.ngaySinh.getMonth()+1)+"/"+(ts.ngaySinh.getYear()+1900), //////////
				(ts.gioiTinh) ? "Nam" : "Nữ",
				ts.diemMon1+"",
				ts.diemMon2+"",
				ts.diemMon3+"",
		});
	}
		
	public void themHoacCapNhatThiSinhThiSinh(ThiSinh ts) {
		DefaultTableModel talble_model = (DefaultTableModel) table.getModel();
		if(!this.model.kiemTraTonTai(ts)) {
			this.model.insert(ts);
			this.themSinhVienVaoTable(ts);
		}else {
			
			ThiSinh tsCu = getThiSinhDangChon(); 
			
			// tìm chỉ mục trong danh sách với sự xuất hiện đầu tiên của phần tử được chỉ định
			int idMSVCu = this.model.dsThiSinh.indexOf(tsCu); 
			// Cập nhật giá trị của phần tử Arraylist  <set(index, element)>
			// index chỉ sô phần tử &  element là phần tử mới để thay thế.
			this.model.dsThiSinh.set(idMSVCu,ts);
			
			// lấy số lượng dòng của bảng
			int soLuongDong = talble_model.getRowCount();
			for(int i=0;i<soLuongDong;i++) {
				String id = talble_model.getValueAt(i,0).toString();
				if(id.equals(ts.maxThiSinh+"")) {
					talble_model.setValueAt(ts.maxThiSinh + "", i, 0);
					talble_model.setValueAt(ts.tenThiSinh , i, 1);
					talble_model.setValueAt(ts.queQuan , i, 2);
					talble_model.setValueAt(ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/"
							+ (ts.getNgaySinh().getYear() + 1900) + "", i, 3);
					talble_model.setValueAt((ts.isGioiTinh() ? "Nam" : "Nữ"), i, 4);
					talble_model.setValueAt(ts.getDiemMon1() + "", i, 5);
					talble_model.setValueAt(ts.getDiemMon2() + "", i, 6);
					talble_model.setValueAt(ts.getDiemMon3() + "", i, 7);
					
				}
			}
		}
		
		
	}
	public ThiSinh getThiSinhDangChon() {
		// lấy hế hàng và cột của table
		DefaultTableModel talble_model = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow(); // lấy hàng mà người dùng đã chọn
		
		// getValueAt(int i,int j) -> lấy hàng i cột j 
		int maxThiSinh = Integer.valueOf(talble_model.getValueAt(i_row,0)+"");
		String tenThiSinh = talble_model.getValueAt(i_row,1)+"";
		String queQuan = talble_model.getValueAt(i_row,2)+"";
		Date ngaySinh = new Date(talble_model.getValueAt(i_row,3)+"");
		System.out.println(talble_model.getValueAt(i_row,3)+"");
		
		String text_gioiTinh = talble_model.getValueAt(i_row,4)+"";
		boolean gioiTinh = text_gioiTinh.equals("Nam");		
		double diemMon1 = Double.valueOf(talble_model.getValueAt(i_row,5)+"");
		double diemMon2 = Double.valueOf(talble_model.getValueAt(i_row,6)+"");
		double diemMon3 = Double.valueOf(talble_model.getValueAt(i_row,7)+"");
		
		ThiSinh ts = new ThiSinh(maxThiSinh, tenThiSinh, queQuan, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		return ts;
	}


	public void hienThiThongTinThiSinhDaChon() {
		ThiSinh ts = this.getThiSinhDangChon();
		
		this.textField_MSV.setText(ts.maxThiSinh+"");
		this.textField_HVT.setText(ts.tenThiSinh);
		this.comboBox_queQuan.setSelectedItem(ts.queQuan);
		this.textField_ngaySinh.setText(ts.ngaySinh.getDate()+"/"+(ts.ngaySinh.getMonth()+1)+"/"+(ts.ngaySinh.getYear()+1900));
		if(ts.gioiTinh) {
			this.radioButton_nam.setSelected(true);
		}else this.radioButton_nu.setSelected(true);
		this.textField_mon1.setText(ts.diemMon1+"");
		this.textField_mon2.setText(ts.diemMon2+"");
		this.textField_mon3.setText(ts.diemMon3+"");
	}

	public void thuHienXoa() {
		ThiSinh ts = getThiSinhDangChon();
		// lấy hết hà và cột của table
		DefaultTableModel talble_model = (DefaultTableModel) table.getModel();
		// lấy hàng mà người dùng chọn
		int id = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this,"Bạn có chắc chắn muốn xóa","Thông báo", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
		if(luaChon==JOptionPane.YES_OPTION) {
			this.model.delete(ts);
			talble_model.removeRow(id);
		}
	}

	public void thucHienThemThiSinh() {
		try {
			int maxThiSinh = Integer.valueOf(this.textField_MSV.getText());
			String tenThiSinh = this.textField_HVT.getText();
			String queQuan = this.comboBox_queQuan.getSelectedItem().toString();
			Date ngaySinh = new Date(this.textField_ngaySinh.getText());
			boolean gioiTinh = true;
			if(this.radioButton_nam.isSelected()) gioiTinh = true;
			else gioiTinh = false;			
			double diemMon1 = Double.valueOf(this.textField_mon1.getText());
			double diemMon2 = Double.valueOf(this.textField_mon2.getText());
			double diemMon3 = Double.valueOf(this.textField_mon3.getText());
			ThiSinh thiSinh =  new ThiSinh(maxThiSinh,tenThiSinh,queQuan,ngaySinh,gioiTinh,diemMon1,diemMon2,diemMon3);
			this.themHoacCapNhatThiSinhThiSinh(thiSinh);
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		}
	
		
	}

	public void thucHienTim() {
		// Tải lại dữ liệu sau mỗi lần tìm kiếm
		this.thucHienTaiLaiDuLieu();
		
		// thực hiện tìm kiếm
		String queQuan_timKiem = this.comboBox_queQuan_timKiem.getSelectedItem()+"";
		String maSinhVien_timKiem = this.jTextFild_maThiSinh_timKiem.getText()+"";
		int soLuongDong = table.getRowCount();
		
		Set<Integer> id_thiSinhCanXoa = new HashSet<Integer>();
		
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if(queQuan_timKiem.length()>0) {
			for(int i=0;i<soLuongDong;i++) {
				if(!(model_table.getValueAt(i,2)+"").equals(queQuan_timKiem))
						id_thiSinhCanXoa.add(Integer.valueOf(model_table.getValueAt(i, 0)+""));
			}
		}
		if(maSinhVien_timKiem.length()>0) {
			System.out.println(maSinhVien_timKiem);
			for(int i=0;i<soLuongDong;i++) {
				String maSinhVien = model_table.getValueAt(i, 0)+"";
				if(!maSinhVien.equals(maSinhVien_timKiem))
					id_thiSinhCanXoa.add(Integer.valueOf(model_table.getValueAt(i, 0)+""));
			}
		}
		// xóa sinh viên không thuộc vùng tìm kiếm
		for(int id : id_thiSinhCanXoa) {
			for(int i=0;i<soLuongDong;i++) {
				String id_trongTable = table.getValueAt(i,0)+"";
				if(id_trongTable.equals( String.valueOf(id))) {
					try { // xóa 1 dòng ra khỏi dòng bị lỗi => try cath lại
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break; // mỗi lần xóa ra bị lỗi => break chạy tiếp theo
					
					/* diên gải: vd trong hàm có id ={1,5,2,3}
					vòng1	thì nó sẽ tìm 1 và xóa sẽ báo lỗi => break và chạy vòng tiếp the
					vòng2	thì nó xẽ tìm 	5 và xóa sẽ bão lỗi => break và chạy vong tiêp theo
					tượng tự ok
					*/
				}
			}
			
		}
		
	}
	

	public void thucHienTaiLaiDuLieu() {
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
		for(ThiSinh ts : this.model.getDsThiSinh()) {
			this.themSinhVienVaoTable(ts);
		}	
		
	}

	public void thucHienOpenFile() {
		JFileChooser fc =new  JFileChooser();
		int value = fc.showOpenDialog(this);
		if(value == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			this.model.setTenFile(file.getAbsolutePath());
			openFile(file);////
			thucHienTaiLaiDuLieu();
		}
	}

	private void openFile(File file) {
		ArrayList<ThiSinh> dts = new ArrayList<>();
		
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ThiSinh thiSinh = null;
			while (true) {
				Object oj = ois.readObject();
				if (oj == null)
					break;
				if (oj != null) {
					thiSinh = (ThiSinh) oj;
					dts.add((ThiSinh) oj);
				}
				
			}
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.model.setDsThiSinh(dts);		
	}

	public void thucHienSaveFile() {
		if(this.model.getTenFile().length()>0) {
			File file = new File(this.model.getTenFile());
			saveFile(this.model.getTenFile());
		}
		else {
			JFileChooser fc =new  JFileChooser();
			int value = fc.showOpenDialog(this);
			if(value==fc.APPROVE_OPTION) {
				String file = fc.getSelectedFile()+"";
				saveFile(file);
			}
			
		}
	}

	public void saveFile(String file) {
		File file_ =new  File(file);
		try {
			FileOutputStream fis = new FileOutputStream(file_);
			ObjectOutputStream ois = new ObjectOutputStream(fis);
		    for(ThiSinh ts : this.model.getDsThiSinh()) {
		    	
		    	ois.writeObject(ts);
		    }
			ois.flush();
			ois.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public void thucHienExit() {
		int luaChon = JOptionPane.showConfirmDialog(this,"Bạn có muốn thoát khỏi chương trình","Chú ý",
				JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
		if(luaChon==JOptionPane.YES_OPTION)
			System.exit(0);
	}

	public void thucHienAboutMe() {
		JOptionPane.showMessageDialog(this,
				"Tên sản phẩm: Phầm mềm quản lí sinh viên \n"
				+"Phiên bản: 1.0 \n "
				+"Ngày phát hành: 13/1/2022\n"
				+"Người phát triển: Nguyễn Viết Tú",
				"Thông tinh phần mềm",
				JOptionPane.INFORMATION_MESSAGE
						);
	}
}
