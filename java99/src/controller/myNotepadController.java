package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import javax.swing.JFileChooser;

import view.myNotepadView;

public class myNotepadController  implements  ActionListener{

	private myNotepadView view;

	

	public myNotepadController(myNotepadView view) {
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		JFileChooser fc = new JFileChooser();
		
		if(command.equals("Open")) {
			int returnVal = fc.showOpenDialog(this.view); // hiển thị tại myNotepadView và trả về giá trị người dùng vừa chọn
			if(returnVal==JFileChooser.APPROVE_OPTION) { // nếu ng chọn là file thì đúng
				File file = fc.getSelectedFile();
				String file_name = file.getName();
				this.view.model.setFileName(file.getAbsolutePath());
				this.view.lblNewLabel.setText(this.view.model.getFileName());
				if(file_name.endsWith(".txt")) {
					try {
						List<String> allText = Files.readAllLines(file.toPath(),StandardCharsets.UTF_8);
						String result = "";
						for(String line : allText) {
							result += line +"\n";
						}
						this.view.textArea.setText(result);
					} catch (IOException e1) {
						e1.printStackTrace();                                                                
					}
				}
			}
	   }
	if(command.equals("Save")){
		if(this.view.model.getFileName().length()>0) {
			save(this.view.model.getFileName());
		}
		else {
			int returnVal = fc.showSaveDialog(this.view);// chưa có sẽ tự tạo file
			if(returnVal==JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile(); // lấy file đã được chọn
				save(file.getAbsolutePath());
			}
				
		}			
	}
		
   }
	public  void save(String file) {
		try {
			 PrintWriter pw = new PrintWriter(file,StandardCharsets.UTF_8);
			 String data = this.view.textArea.getText();
			 pw.print(data);
			 pw.flush();
			 pw.close();
		 } catch (IOException e1) {
			 e1.printStackTrace();
		 }	
	}
}


