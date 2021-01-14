package view;

import java.awt.Color;

import javax.swing.JButton;

public class Button extends JButton {
	private String nameField;

	/**
	 * This is the constructor for the Button class
	 * 
	 * @param name
	 * @param x
	 * @param y
	 * @param L
	 * @param l
	 * @param object
	 */
	public Button(String name, int x, int y, int L, int l) {
		this.nameField = name;
		this.setBounds(x, y, L, l);

		if ((name.equals("Profil_Modify_Profile")) || (name.equals("Profil_Modify_Password"))
				|| (name.equals("Supplier_Create") || (name.equals("Supplier_Modify")) || (name.equals("Order_Modify")))
				|| (name.equals("Article_Modify")) || (name.equals("Manage_Modify_Profile"))
				|| (name.equals("Manage_Modify_PassWord"))) {
			
			this.setBackground(new Color(232, 250, 126));
			if (name.equals("Profil_Modify_Profile")) {
				nameField = "Modify Profile";
			}
			if (name.equals("Profil_Modify_Password")) {
				nameField = "Modify Password";
			}
			if (name.equals("Supplier_Create")) {
				nameField = "Create";
			}
			if (name.equals("Supplier_Modify")) {
				nameField = "Modify";
			}
			if (name.equals("Article_Modify")) {
				nameField = "Modify";
			}
			if (name.equals("Manage_Modify_Profile")) {
				nameField = "Modify";
			}
			if (name.equals("Manage_Modify_PassWord")) {
				nameField = "Modify";
			}
		}
		if ((name.equals("Profil_Save_Password")) || (name.equals("Order_Submit")) || (name.equals("Order_Create"))
				|| (name.equals("Article_Create")) || (name.equals("Save")) || (name.equals("History_Submit"))) {
			
			this.setBackground(new Color(173, 246, 100));
			if (name.equals("Profil_Save_Password")) {
				nameField = "Save Password";
			}
			if (name.equals("Order_Submit")) {
				nameField = "Submit";
			}
			if (name.equals("Order_Create")) {
				nameField = "Create";
			}
			if (name.equals("Article_Create")) {
				nameField = "Create";
			}
			if (name.equals("History_Submit")) {
				nameField = "Submit";
			}
		}
		if ((name.equals("Supplier_Block / Unblock")) || (name.equals("Creating Date"))
				|| (name.equals("Update Date") || (name.equals("Orders placed")) || (name.equals("Orders in progress")))
				|| (name.equals("Manage_Block / Unblock"))) {
			
			this.setBackground(new Color(191, 244, 255));
			if (name.equals("Supplier_Block / Unblock")) {
				nameField = "Block / Unblock";
			}
			if (name.equals("Manage_Block / Unblock")) {
				nameField = "Block / Unblock";
			}

		}
		if ((name.equals("DEL")) || (name.equals("Block /Unblock selected Element"))) {
			this.setBackground(new Color(165, 374, 211, 45));
		}
		this.setText(nameField);
		this.addActionListener(new ButtonListener(name)); // We add actionListener to all the buttons
	}

}