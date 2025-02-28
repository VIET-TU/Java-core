package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;

import view.MenuExampleView;

public class MenuController implements ActionListener{
	private MenuExampleView menuExampleView;
	
	
	
	public MenuController(MenuExampleView menuExampleView) {
		this.menuExampleView = menuExampleView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if(button.equals("Exit")) {
			System.exit(0);
		}if(button.equals("Toolbar")) {
			System.out.println("Toolbar");
			AbstractButton checkBox =  (AbstractButton) e.getSource();
			boolean check = checkBox.getModel().isSelected();
			if(check) {
				System.out.println("check");
				this.menuExampleView.enableToolbar();
			}else {
				System.out.println("unCheck");
				this.menuExampleView.disableToolbar();
			}
		}else{
			this.menuExampleView.setTextJLabel("Bạn đã click: "+button);
		}
	}

}