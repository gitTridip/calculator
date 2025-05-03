package main.java;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Frame extends JFrame {
	private static final long serialVersionUID = 1L;

	protected Frame(){
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 600);
		this.setResizable(true);
		
		ImageIcon logo=new ImageIcon(Apk.class.getResource("/resources/logo.png"));
		this.setIconImage(logo.getImage());
	}
}
