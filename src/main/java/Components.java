package main.java;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class Components {
	static JFrame frame;
	static JTextField disp;
	static LinkedList<String> data=new LinkedList<String>();
	
	public Components(JFrame frame) {
		Components.frame=frame;
		frame.add(display());
		frame.add(operatorButton("/resources/plus.png", "+", 50, 80));
		frame.add(operatorButton("/resources/multiply.png", "*", 120, 80));
		frame.add(operatorButton("/resources/minus.png", "-", 50, 160));
		frame.add(operatorButton("/resources/divide.png", "/", 120, 160));
		frame.add(operatorButton("/resources/modulo.png", "%", 50, 240));
		frame.add(allClear());
		frame.add(result());
	}
	
	public static JTextField display() {
		Border border=BorderFactory.createLineBorder(new Color(250, 160, 50), 5, true);		
		disp=new JTextField();
		disp.setBorder(border);
		disp.setBounds(	50, 0, 210, 50);
		disp.setFont(new Font("Arial", Font.PLAIN, 25));;
		disp.setVisible(true);
		
		return disp;
	}
	
	public static JButton operatorButton(String iconPath, String operator, int x, int y) {
	    ImageIcon image = new ImageIcon(Components.class.getResource(iconPath));
	    Icon newImage = new ImageIcon(image.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
	    
	    Border border=BorderFactory.createLineBorder(new Color(250, 160, 50), 5, true);
	    
	    JButton button = new JButton(newImage);
	    button.setBounds(x, y, 40, 40);
	    button.setBorder(border);
	    button.setVisible(true);
	    button.addActionListener(e -> {
	        try {
	            if (disp.getText().contains("."))
	                Double.parseDouble(disp.getText());
	            else
	                Integer.parseInt(disp.getText());
	            data.add(disp.getText());
	            data.add(operator);
	        } catch (Exception f) {
	            JOptionPane.showMessageDialog(frame, "invalid number");
	            disp.setText("");
	        }
	        disp.setText("");
            disp.requestFocus();
            SwingUtilities.invokeLater(() -> {
                disp.requestFocusInWindow();
                disp.setCaretPosition(0);
            });
	    });
	    return button;
	}
	
	public static JButton allClear() {
		ImageIcon image = new ImageIcon(Components.class.getResource("/resources/ac.png"));
		Icon newImage = new ImageIcon(image.getImage().getScaledInstance(80, 50, Image.SCALE_SMOOTH));
		Border border=BorderFactory.createLineBorder(new Color(250, 160, 50), 5, true);
		
		JButton button = new JButton(newImage);
		button.setBounds(190, 80, 70, 40);
		button.setBorder(border);
		button.setVisible(true);
		button.addActionListener(e -> {
			disp.setText("");
			SwingUtilities.invokeLater(() -> {
                disp.requestFocusInWindow();
                disp.setCaretPosition(0);
            });
		});
		
		return button;
	}
	
	public static JButton result() {
		ImageIcon image = new ImageIcon(Components.class.getResource("/resources/result.png"));
		Icon newImage = new ImageIcon(image.getImage().getScaledInstance(80, 50, Image.SCALE_SMOOTH));
		Border border=BorderFactory.createLineBorder(new Color(250, 160, 50), 5, true);
		
		JButton button = new JButton(newImage);
		button.setBorder(border);
		button.setBounds(190, 160, 70, 40);
		button.setVisible(true);
		button.addActionListener(e -> {
			try {
	            if (disp.getText().contains("."))
	                Double.parseDouble(disp.getText());
	            else
	                Integer.parseInt(disp.getText());
	            data.add(disp.getText());
	        } catch (Exception f) {
	            JOptionPane.showMessageDialog(frame, "invalid number");
	            disp.setText("");
	        }
			try {
				disp.setText(Calculate.evaluateExpression(data).toString());
			}
			catch (PopupException x) {
				JOptionPane.showMessageDialog(frame, x.getMessage());
				disp.setText("");
				data.clear();
			}
			SwingUtilities.invokeLater(() -> {

	            data.clear();
                disp.requestFocusInWindow();
                disp.setCaretPosition(1);
            });
		});
		
		return button;
	}


}
