package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Label extends JLabel {
	private String nameField;
	private ValueNeeded object;

	
	public Label(String name, int x, int y, int L, int l, ValueNeeded object) {
		this.nameField = name;
		this.object = object;
		this.setBounds(x, y, L, l);
		this.setText(nameField);
		this.setForeground(Color.DARK_GRAY);
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setFont(new Font("Rockwell Nova", Font.PLAIN, 14));
		this.setBounds(x, y, L, l);
		}
	
}
