package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import entities.Product;
import entities.Supplier;
import entities.SupplierSell;
import model.QuerySupplier;
import model.QuerySupplierSell;

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
			try {
				Supplier supplier = QuerySupplier.querySuppl
						.createSupplierInfo(String.valueOf(Frame.suppl.getCombo()[0].getSelectedItem()));
				System.out.println("test");
				Frame.suppl.getTextField()[0].setText(supplier.getName());
				Frame.suppl.getTextField()[1].setText(supplier.getAdress());
				Frame.suppl.getTextField()[2].setText(supplier.getCity());
				Frame.suppl.getTextField()[3].setText(supplier.getContactLastname());
				Frame.suppl.getTextField()[4].setText(supplier.getContactFirstname());
				Frame.suppl.getTextField()[5].setText(supplier.getContactNumber());
				SupplierSell supplSell = QuerySupplierSell.querySell.createSupplierSellInfo(supplier);
				ArrayList<Product> product=supplSell.getProducts();
				if (product.size()>0) {
					Frame.suppl.getTable().getModel().setValueAt(product.get(0).getName(), 0, 0);
				}
				
				
			

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

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

		case "Product_Launch": {

			break;
		}
		case "+_Product": {

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
		case "Manage_Launch": {

			break;
		}

		}
	}

}