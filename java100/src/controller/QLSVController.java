package controller;

import view.QLSVView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import model.ThiSinh;
import model.Tinh;


public class QLSVController implements ActionListener{
	int a =5;
	double b = 6;
	
	QLSVView view;

	public QLSVController(QLSVView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		if(cm.equals("ThÃªm")) {
			this.view.xoaForm();
			this.view.model.setLuaChon(cm);
		}			
		else if(cm.equals("LÆ°u")) {
			this.view.thucHienThemThiSinh();
		}else if(cm.equals("Cáº­p nháº­t")) {
			this.view.hienThiThongTinThiSinhDaChon();
		}
		else if(cm.equals("XÃ³a")){
			this.view.thuHienXoa();
		}
		else if(cm.equals("Há»§y bá»�")) {
			this.view.xoaForm();
		}
		else if(cm.equals("TÃ¬m")) {
			this.view.thucHienTim();
		}else if(cm.equals("Há»§y tÃ¬m")) {
			this.view.thucHienTaiLaiDuLieu();
		}
		else if(cm.equals("Open")) {
			this.view.thucHienOpenFile();
		}
		else if(cm.equals("Save")) {
			this.view.thucHienSaveFile();
		}
		else if(cm.equals("Exit")) {
			this.view.thucHienExit();
		}
		else if(cm.equals("About me")) {
			this.view.thucHienAboutMe();
		}
		
		
			
			
	}
	public static void main(String[] args) {
		int a = 9;
	}
	
}
