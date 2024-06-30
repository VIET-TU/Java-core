 package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.*;

public class MainView extends JFrame {
	private JMenu menu, submenu;
	private JMenuItem i1, i2, i3, i4, i5;
	private JMenuBar mb = new JMenuBar();
	private JButton jButton;
	private JLabel jLabel;

	public MainView() {
		this.setTitle("TITV");
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		
		URL urlIconNotepad = MainView.class.getResource("notepad-icon.png");
		Image img = Toolkit.getDefaultToolkit().createImage(urlIconNotepad);
		this.setIconImage(img);
		
		// JMenuBar
		menu = new JMenu("Menu");
		submenu = new JMenu("Sub Menu");
		i1 = new JMenuItem("New");
//		i1.setIcon((Icon) Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("new-file-icon.png")));
		i1.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("new-file-icon.png"))));
		i2 = new JMenuItem("Save");
		i3 = new JMenuItem("Save As");
		i4 = new JMenuItem("Exit");
		i5 = new JMenuItem("Test");
		menu.add(i1);
		menu.add(i2);
		menu.add(i3);
		submenu.add(i4);
		submenu.add(i5);
		menu.add(submenu);
		mb.add(menu);

		
		// JLabel
		jLabel = new JLabel();
		jLabel.setIcon( new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("golang.png"))));
	
		// JButton
		jButton = new JButton("TEST BUTTON");
		jButton.setFont(new Font("Arial", Font.BOLD, 50));
		jButton.setSize(50, 50);
		
		
		this.setJMenuBar(mb);
		this.add(jLabel, BorderLayout.CENTER);
		this.add(jButton, BorderLayout.SOUTH);		
		
		this.setVisible(true);
	}

	
}
