package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPasswordField;

public class PasswordField extends JPasswordField{
	private String nameField;
	
	
	public PasswordField(String name, int x, int y,ValueNeeded object) {
		
		this.setBounds(x, y,226,27);
		this.setText(nameField);
		this.setColumns(10);
		this.setForeground(new Color(192, 192, 192));
		this.setFont(new Font("Rockwell Nova", Font.PLAIN, 14));
		
		
		
	}
}
