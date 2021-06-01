package components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;


public class Button extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
				|| (name.equals("Manage_Modify_PassWord")) || (name.equals("Order_Modify"))|| (name.equals("Product Modify"))) {

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
			if (name.equals("Order_Modify")) {
				nameField = "Modify";
			}
			if (name.equals("Manage_Modify_Profile")) {
				nameField = "Modify Profil";
			}
			if (name.equals("Manage_Modify_PassWord")) {
				nameField = "Modify Password";
			}
			if(name.equals("Product Modify")) {
				nameField = "Modify";
			}
		}
		if ((name.equals("Profil_Save_Password")) || (name.equals("Order_Submit")) || (name.equals("Order_Create"))
				|| (name.equals("Profil_Save_Profil")) || (name.equals("Article_Create")) || (name.equals("Save"))
				|| (name.equals("History_Submit"))) {

			this.setBackground(new Color(173, 246, 100));
			if (name.equals("Profil_Save_Password")) {
				nameField = "Save Password";
			}
			if (name.equals("Profil_Save_Profil")) {
				nameField = "Save Profil";
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
		if ((name.equals("SupplierBlock / Unblock")) || (name.equals("Creating Date"))
				|| (name.equals("Update Date") || (name.equals("Orders treated")) || (name.equals("Orders in progress")))
				|| (name.equals("Manage_Block / Unblock"))) {

			this.setBackground(new Color(191, 244, 255));
			if (name.equals("SupplierBlock / Unblock")) {
				nameField = "Block / Unblock";
			}
			if (name.equals("Manage_Block / Unblock")) {
				nameField = "Block / Unblock";
			}

		}
		if ((name.equals("DEL")) || (name.equals("Block /Unblock selected Element"))) {
			this.setBackground(new Color(243, 101, 101));
			if ( name.equals("Unblock selected Element")) {
				this.setBackground(new Color(0, 0, 101));
			}
		}

		if (name.equals("OrderArticle_Launch") || name.equals("Launch_Supplier") || (name.equals("Order_Launch")) || (name.equals("Article_Launch"))
				|| (name.equals("Product_Launch")) || (name.equals("Manage_Launch"))) {
			nameField = "Launch";
		}
		if ((name.equals("+_Supplier")) || (name.equals("+_Order1")) || (name.equals("+_Order2"))
				|| (name.equals("-_Order")) || (name.equals("+_Product")) || (name.equals("x_Order"))|| (name.equals("+_Product"))) {

			this.setFont(new Font("Tahoma", Font.BOLD, 11));

			if ((name.equals("+_Supplier")) || (name.equals("+_Order")) || (name.equals("+_Order2"))
					|| (name.equals("+_Product")) || (name.equals("+_Order1"))) {
				nameField = "+";
			}
			if ((name.equals("-_Supplier")) || (name.equals("-_Order"))) {
				nameField = "-";
			}
			if ( (name.equals("x_Order"))) {
				nameField = "x";
			}

			if (name.equals("x_Order")) {
				this.setBackground(new Color(243, 101, 101));
			}
			if (name.equals("+_Product")){
				this.setBackground(new Color(173, 246, 100));
			}
		}
		
		this.setText(nameField);
		this.addActionListener(new ButtonListener(name)); // We add actionListener to all the buttons
	}
	
	public void blocked() {
	
		this.setBackground(Color.red);
		this.setText("Blocked");
		
	
	}
	
	public void unblocked() {
		this.setBackground(Color.green);
		this.setText("Unblocked");
	}

}