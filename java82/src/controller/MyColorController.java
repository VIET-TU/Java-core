package controller;
import java.awt.event.ActionListener;

import View.MyColorView;
import java.awt.Color;

import java.awt.event.ActionEvent;

public class MyColorController implements ActionListener{
	private MyColorView myColorView;
	
	
	public MyColorController(MyColorView myColorView) {
		this.myColorView = myColorView;
	}


	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		
		if(src.endsWith("Red text")) this.myColorView.changeTextColor(Color.RED);
		else if(src.endsWith("Yellow text")) this.myColorView.changeTextColor(Color.YELLOW);
		else if(src.endsWith("Green text")) this.myColorView.changeTextColor(Color.GREEN);
		else if(src.endsWith("Red background")) this.myColorView.changeBackColor(Color.RED);
		else if(src.endsWith("Yellow background")) this.myColorView.changeBackColor(Color.YELLOW);
		else if(src.endsWith("Green background")) this.myColorView.changeBackColor(Color.GREEN);
	}
}
