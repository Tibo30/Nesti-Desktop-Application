package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;

public class TextField extends JTextField{
	private String nameField;
	
	public TextField(String name, int x, int y) {
	
		
		this.nameField=name;
		this.setBounds(x, y,226,27);
		this.setText(nameField);
		this.setColumns(10);
		this.setForeground(new Color(192, 192, 192));
		this.setFont(new Font("Rockwell Nova", Font.PLAIN, 14));
}
	
	
}
