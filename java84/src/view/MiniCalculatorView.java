package view;
//import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.MiniCaculatorController;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.awt.Color;

import model.MiniCalculatorModel;

public class MiniCalculatorView extends JFrame{
	private MiniCalculatorModel miniCalulatorModel;
	private JTextField jTextField_fistValue;
	private JTextField jTextField_seconValue;
	private JTextField jTextField_answer;
	

	public MiniCalculatorView() {
		this.miniCalulatorModel =new MiniCalculatorModel();
		this.init();
	}

	private void init() {
		this.setTitle("Casio  fx100");
		this.setSize(300,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font font = new Font("Arial",Font.BOLD,20);
		jTextField_fistValue = new JTextField(20);
		jTextField_fistValue.setFont(font);
		jTextField_fistValue.setForeground(Color.RED);
		
		jTextField_seconValue =new JTextField(20);
		jTextField_seconValue.setFont(font);
		jTextField_seconValue.setForeground(Color.RED);
		
		jTextField_answer = new JTextField(20);
		jTextField_answer.setFont(font);
		jTextField_answer.setForeground(Color.RED);
		
		MiniCaculatorController  src =new MiniCaculatorController(this);
		
		JLabel jLable1 = new JLabel("fist value");
		JLabel  jLable2 = new JLabel("second value");
		JLabel  jLable3 = new JLabel("answer");

		Font font_button = new Font("Arial",Font.BOLD,30);
		JButton  jButton_plus = new JButton("+");
		jButton_plus.setFont(font_button);
		jButton_plus.addActionListener(src);
		
		
		JButton  jButton_minus = new JButton("-");
		jButton_minus.setFont(font_button);
		jButton_minus.addActionListener(src);
		
		JButton  jButton_multiply = new JButton("*");
		jButton_multiply.setFont(font_button);
		JButton  jButton_divide = new JButton("/");
		jButton_divide.setFont(font_button);
		JButton  jButton_pow = new JButton("^");
		jButton_pow.setFont(font_button);
		JButton  jButton_mod = new JButton("%");
		jButton_mod.setFont(font_button);
		
		JPanel jPanel_north =new JPanel();
		jPanel_north.setLayout(new GridLayout(3,2));
		jPanel_north.add(jLable1);
		jPanel_north.add(jTextField_fistValue);
		jPanel_north.add(jLable2);
		jPanel_north.add(jTextField_seconValue);
		jPanel_north.add(jLable3);
		jPanel_north.add(jTextField_answer);
		
		JPanel jPanel_center = new JPanel();
		jPanel_center.setLayout(new GridLayout(2,3));
		
		jPanel_center.add(jButton_plus);
		jPanel_center.add(jButton_minus);
		jPanel_center.add(jButton_multiply);
		jPanel_center.add(jButton_divide);
		jPanel_center.add(jButton_pow);
		jPanel_center.add(jButton_mod);
		
		this.setLayout(new BorderLayout());
		this.add(jPanel_north,BorderLayout.NORTH);
		this.add(jPanel_center,BorderLayout.CENTER);

		
		this.setVisible(true);
		
	}

	
	
	public void plus() {
		 
		 this.miniCalulatorModel.setFistValue(Double.valueOf(this.jTextField_fistValue.getText()));
		 this.miniCalulatorModel.setSecondValue(Double.valueOf(this.jTextField_seconValue.getText()));
		 this.miniCalulatorModel.plus();
		 this.jTextField_answer.setText(this.miniCalulatorModel.getAnswer()+"");
	}
	
	public void minus() {
		
	}
	public void mutiply() {
		
	}
	public void divide() {
		
	}
	public void pow() {
		
	}
	public void mod() {
		
	}
	
}
