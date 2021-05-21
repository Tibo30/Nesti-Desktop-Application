package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
	String text;

	public ButtonListener() {
	}

	public ButtonListener(String name) {
		this.text = name;

	}

	public void actionPerformed(ActionEvent e) {
		switch (text) {

		case "Profil_Modify_Profile": {

			break;
		}

		case "Profil_Modify_Password": {

			break;
		}
		case "Profil_Save_Password": {

			break;
		}
		case "Launch": {

			break;
		}
		case "Supplier_Block / Unblock": {

			break;
		}
		case "+_Order1": {

			break;
		}
		case "+_Order2": {

			break;
		}
		case "-_Order": {

			break;
		}
		case "x_Order": {

			break;
		}
		case "Order_Launch": {

			break;
		}

		case "LaunchSupplier": {
			

			break;
		}

		case "Supplier_Create": {

			

			break;
		}
		case "Supplier_Modify": {

			break;
		}
		case "DEL": {

			break;
		}

		case "Supplier Adress": {

			break;
		}
		case "+2": {

			break;
		}
		case "-": {

			break;
		}
		case "x": {

			break;
		}
		case "Order_Modify": {

			break;
		}
		case "Order_Submit": {

			break;
		}
		case "Order_Create": {

			break;
		}
		case "Article_Launch": {

			break;
		}

		case "Article_Create": {

			break;
		}
		case "Article_Modify": {

			break;
		}
		case "Creating Date": {

			break;
		}
		case "Update Date": {

			break;
		}
		case "Block /Unblock selected Element": {
			

			break;
		}
		case "Save": {

			break;
		}

		case "+_Product": { 
			

			break;
		}
		case "Product Modify": {
			
			
			break;
		}
		case "History_Submit": {

			break;
		}

		case "Orders placed": {

			break;
		}

		case "Orders in progress": {

			break;
		}
		case "Manage_Modify_Profile": {

			break;
		}
		case "Manage_Modify_PassWord": {

			break;
		}
		case "Manage_Block / Unblock": {

			break;
		}
//		case "Manage_Launch": {
//            try {
//                // create the object admin from the database according to its first name and/or last name selected in the search combo box
//                Admin adm = QueryAdmin.queryAdm
//                        .createAdminInfo(String.valueOf(Frame.adm.getCombo()[0].getSelectedItem()));
//                // add all the information in the TextField
//                Frame.adm.getTextField()[0].setText(adm.getFirstname());
//                Frame.adm.getTextField()[1].setText(adm.getLastname());
//                Frame.adm.getTextField()[2].setText(adm.getUsername());
//
//            } catch (Exception e1) {
//
//                e1.printStackTrace();
//            }
//            break;
//
//		}
		}

	}
}
