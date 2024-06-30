package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.MyColorModel;
import controller.MyColorController;

public class MyColorView extends JFrame{
	private MyColorModel myColorModel;
	private JLabel jLabel;
	
	public MyColorView() {
//		this.myColorModel = new MyColorModel();
		this.init();
		this.setVisible(true);
	}

	private void init() {
		this.setTitle("My color");
		this.setSize(600,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jLabel =new JLabel("Tu Viet",JLabel.CENTER);
		jLabel.setFont(new Font("Arial",Font.PLAIN,30));
		
		MyColorController myColorController =new  MyColorController(this);
		
		JPanel jPanel = new JPanel();
		Font font_button = new Font("Arial",Font.PLAIN,20);
		
		JButton jButton_text_red = new JButton("Red text");
		jButton_text_red.setFont(font_button);
		jButton_text_red.setForeground(Color.RED);
		jButton_text_red.setBackground(Color.WHITE);
		jButton_text_red.addActionListener(myColorController);
		
		
		
		JButton jButton_text_yellow = new JButton("Yellow text");
		jButton_text_yellow.setFont(font_button);
		jButton_text_yellow.setForeground(Color.YELLOW);
		jButton_text_yellow.setBackground(Color.WHITE);
		jButton_text_yellow.addActionListener(myColorController);
		
		
		JButton jButton_text_green = new JButton("Green text");
		jButton_text_green.setFont(font_button);
		jButton_text_green.setForeground(Color.GREEN);
		jButton_text_green.setBackground(Color.WHITE);
		jButton_text_green.addActionListener(myColorController);
		
		JButton jButton_background_red = new JButton("Red background");
		jButton_background_red.setFont(font_button);
		jButton_background_red.setBackground(Color.RED);
		jButton_background_red.addActionListener(myColorController);
		jButton_background_red.setOpaque(true);
		
		JButton jButton_backgruond_yellow = new JButton("Yellow background");
		jButton_backgruond_yellow.setFont(font_button);
		jButton_backgruond_yellow.setBackground(Color.YELLOW);
		jButton_backgruond_yellow.addActionListener(myColorController);
        jButton_backgruond_yellow.setOpaque(true);
		
		JButton jButton_background_green = new JButton("Green background");
		jButton_background_green.setFont(font_button);
		jButton_background_green.setBackground(Color.GREEN);
		jButton_background_green.addActionListener(myColorController);
		jButton_background_green.setOpaque(true);
		
		jPanel.setLayout(new GridLayout(2,3));
		
		jPanel.add(jButton_text_red);
		jPanel.add(jButton_text_yellow);
		jPanel.add(jButton_text_green);
		jPanel.add(jButton_background_red);
		jPanel.add(jButton_backgruond_yellow);
		jPanel.add(jButton_background_green);
		
		this.setLayout(new BorderLayout());
		this.add(jPanel,BorderLayout.CENTER);
		this.add(jLabel,BorderLayout.NORTH);
		
	}
	
	public void changeTextColor(Color color) {
		this.jLabel.setForeground(color);
	}
	
	public void changeBackColor(Color color) {
		this.jLabel.setBackground(color);
		this.jLabel.setOpaque(true);
	}
	
	
	
}
