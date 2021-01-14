package view;
import javax.swing.JButton;

public class Button extends JButton {
	private String nameField;
/**
 * This is the constructor for the Button class
 * @param name
 * @param x
 * @param y
 * @param L
 * @param l
 * @param object
 */
	public Button(String name, int x, int y, int L, int l, ValueNeeded object) {
		this.nameField = name;
		this.setBounds(x, y, L, l);
		this.setText(nameField);
		
		
		this.addActionListener(new ButtonListener(name, object)); // We add actionListener to all the buttons
	}

}