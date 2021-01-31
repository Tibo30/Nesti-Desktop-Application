package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;

public class TextField extends JTextField {
	private String nameField;

	public TextField(String name, int x, int y, int L, int l) {

		this.nameField = name;
		this.setBounds(x, y, L, l);
		this.setText("");
		this.setColumns(10);
		this.setBackground(new Color(255, 222, 173));
		this.setForeground(Color.BLACK);
		this.setFont(new Font("Rockwell Nova", Font.PLAIN, 14));

	
	
	
	}
}
