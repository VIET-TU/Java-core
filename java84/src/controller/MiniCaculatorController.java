package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MiniCalculatorView;

public class MiniCaculatorController implements ActionListener  {
	private MiniCalculatorView miniView;
	
	
	
	public MiniCaculatorController(MiniCalculatorView miniView) {
		this.miniView = miniView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		
		if(src.equals("+")) this.miniView.plus();

		
	}

}
