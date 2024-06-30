package controller;
import javax.swing.Action;

import model.thiSinh_;
import view.QLSV_view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QLSV_controller implements ActionListener{
	
	public QLSV_view view ;
	
	public QLSV_controller(QLSV_view view) {
		this.view = view;
	}
	public void actionPerformed(ActionEvent e) {
		String comm = e.getActionCommand();
		
		if(comm.equals("Thêm")) {
//			System.out.println("Sửa");
			view.xoaFrom();
		}
		else if(comm.equals("LÆ°u")) {
			System.out.println("Ä‘Ã£ báº¥m lÆ°u");
			view.thucHienThemThiSinh();
		}else if(comm.equals("Cáº­p nháº­t")) 
		{
			view.hienThiThongTinThiSinh_vaoTable();
		}
		else if(comm.equals("XÃ³a")) {
			view.thuHienXoa();
		}
		else if(comm.equals("Há»§y bá»�")) {
			
			view.xoaFrom();
		}
		else if(comm.equals("TÃ¬m")) {
//			System.out.println("bam tÃ¬m");
			view.thuHienTim();
		}
		else if(comm.equals("Há»§y tÃ¬m")) {
			this.view.thucHienHuyBo();
		}
		
	}
	
	
}
