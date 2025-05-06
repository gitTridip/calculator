package main.java;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Frame extends JFrame {
	private static final long serialVersionUID = 1L;

	protected Frame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(320, 360);
		this.setResizable(false);
		this.setLayout(null);
		
		ImageIcon logo=new ImageIcon(Frame.class.getResource("/resources/logo.png"));
		this.setIconImage(logo.getImage());
		
		new Components(this);

		this.setVisible(true);
	}
}
