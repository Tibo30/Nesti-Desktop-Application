package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Label extends JLabel {
	private String nameField;
	private ValueNeeded object;

	
	public Label(String name, int x, int y, int L, int l) {
		this.nameField = name;
		
		this.setBounds(x, y, L, l);
		this.setText(nameField);
		this.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		if (name.equals("Search")||(name.equals("Launch"))||(name.equals("Search with order number"))) {
			this.setFont(new Font("Tahoma",Font.BOLD,12));
		}
		if (name.equals("Joe Smith")||(name.equals("Welcome"))) {
			this.setForeground(new Color(255, 250, 250));
			this.setHorizontalAlignment(SwingConstants.CENTER);
			this.setFont(new Font("Times New Roman", Font.BOLD, 40));
		}
		}
	
}
