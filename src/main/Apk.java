package main;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Apk {
	public static void main(String[] args) {
		
		JFrame frame= new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setResizable(true);
		ImageIcon logo=new ImageIcon("logo.png");
		frame.setIconImage(logo.getImage());
	}
}
