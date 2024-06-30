package controller;
import java.awt.event.ActionEvent;
import java.lang.String;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import java.lang.String;
import java.util.Enumeration;
import java.util.List;

import menuView.MenuView;

public class MenuController implements ActionListener {
	private MenuView menuView;
	private String soTien_Chuoi;
	private Object String;
	
	public MenuController(MenuView menuView) {
		this.menuView = menuView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		String  monChinh =  (String)menuView.jComboBox_monChinh.getSelectedItem();
//		
//		String monPhu = "";
//
//		String[] luaChonMonPhus = (String[]) menuView.jList_monPhu.getSelectedValues();
//		for(int i=0;i<luaChonMonPhus.length;i++) monPhu = monPhu + luaChonMonPhus[i] + "; ";
		
		String monChinh = (String)menuView.jComboBox_monChinh.getSelectedItem();

		String monPhu = "";
		Object[] luaChonMonPhus = menuView.jList_monPhu.getSelectedValues();
		for (Object o : luaChonMonPhus) {
			monPhu = monPhu + o + "; ";
		}
		
//		String monPhu = "";
//		List luaChonMonPhus = menuView.jList_monPhu.getSelectedValuesList();
//		for (Object o : luaChonMonPhus) {
//			monPhu = monPhu + o + "; ";
//		}
		
		
		menuView.menuModel.setMonChinh(monChinh);
		menuView.menuModel.setMonPhu(monPhu);
		menuView.menuModel.tinhTongTien();
		menuView.hienThiKetQua();
		 
			String  soTien_Chuoi = JOptionPane.showInputDialog(menuView,
						menuView.jLabel_thanhToan.getText()+"dsfdfssafsdfasdfsfasdfasdfcasdfcasfasdadsfac"+
						"\nnhập vào số tiền",
						"thông báo",
						 JOptionPane.PLAIN_MESSAGE
						);
	//		double tien = Double.valueOf(soTien_Chuoi);
		
		
		
		try {
			double tien = Double.valueOf(soTien_Chuoi);
			JOptionPane.showMessageDialog(menuView,
					"tiền thừa của bạn là" + (tien-menuView.menuModel.getTongTien()),
					"thông báo"
					, JOptionPane.INFORMATION_MESSAGE
					);
		} 
		catch(Exception a){
			JOptionPane.showMessageDialog(menuView,
					"nhập sai dữ liệu",
					"ERRO", 
					JOptionPane.ERROR_MESSAGE
					);
		}
	}
	
}
