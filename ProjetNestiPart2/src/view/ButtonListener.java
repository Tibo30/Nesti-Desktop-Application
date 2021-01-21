package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import entities.Admin;
import entities.Product;
import entities.Supplier;
import entities.SupplierSell;
import entities.UnitMeasure;
import model.QueryAdmin;
import model.QueryProduct;
import model.QuerySupplier;
import model.QuerySupplierSell;
import javax.swing.table.DefaultTableModel;

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
				// create the object supplier from the database according to the name selected
				// in the search combo box

				Supplier supplier = QuerySupplier.querySuppl
						.createSupplierInfo(String.valueOf(Frame.suppl.getCombo()[0].getSelectedItem()));
				// add all the information in the TextField
				Frame.suppl.getTextField()[0].setText(supplier.getName());
				Frame.suppl.getTextField()[1].setText(supplier.getAdress());
				Frame.suppl.getTextField()[2].setText(supplier.getCity());
				Frame.suppl.getTextField()[3].setText(supplier.getContactLastname());
				Frame.suppl.getTextField()[4].setText(supplier.getContactFirstname());
				Frame.suppl.getTextField()[5].setText(supplier.getContactNumber());
				// create the object supplier sell to have the list of product sold by a
				// supplier
				SupplierSell supplSell = QuerySupplierSell.querySell.createSupplierSellInfo(supplier);
				ArrayList<Product> product = supplSell.getProducts();
				ArrayList<Double> buyingPrices = supplSell.getBuyingPrices();
				DefaultTableModel model = (DefaultTableModel) Frame.suppl.getTable().getModel(); // cast the model as a
																									// defaultTableModel
				for (int j = model.getRowCount() - 1; j >= 0; j--) {
					model.removeRow(j);
				}
				if (product.size() > 0) {
					for (int i = 0; i < product.size(); i++) {
						Object[] test = { product.get(i).getName(), "", buyingPrices.get(i) + " �/u" };
						model.addRow(test);
//                        model.setValueAt(product.get(i).getName(), i, 0);
//                        model.setValueAt(buyingPrices.get(i) + " �/u", i, 2);
					}

				}

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			break;
		}

		case "Supplier_Create": {

			try {
				Admin admin = QueryAdmin.queryAdm.createAdminInfo("JohnnyDoe35");

				Supplier supplCreate = new Supplier(Frame.suppl.getTextField()[0].getText(),
						Frame.suppl.getTextField()[1].getText(), Frame.suppl.getTextField()[2].getText(),
						Frame.suppl.getTextField()[3].getText(), Frame.suppl.getTextField()[4].getText(),
						Frame.suppl.getTextField()[5].getText(), "Unblocked", admin.getId());

				QuerySupplier.querySuppl.createPrepared(supplCreate);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

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
			int row = ProductPanel.prod.table.getSelectedRow();
			boolean only = true;
			if (ProductPanel.prod.table.getValueAt(row, 1).equals("Unblocked") && (only == true)) {
				// Block
				only = false;
				Object toto = "Blocked";
				DefaultTableModel model = (DefaultTableModel) ProductPanel.prod.table.getModel();
				model.setValueAt(toto, row, 1);

			} else {
				only = true;
				Object toto = "Unblocked";
				DefaultTableModel model = (DefaultTableModel) ProductPanel.prod.table.getModel();
				model.setValueAt(toto, row, 1);

			}
			;

			break;
		}
		case "Save": {

			break;
		}

		case "+_Product": { ///////////////////BUGG/////////////////

			UnitMeasure unit = new UnitMeasure(ProductPanel.prod.getCombo()[0].getSelectedItem().toString());
			int row1 = ProductPanel.prod.table.getSelectedRow();
			
			Product product = new Product(
					ProductPanel.prod.textField.getText(),
					ProductPanel.prod.table.getValueAt(row1, 1).toString(),
					ProductPanel.prod.getCombo()[1].getSelectedItem().toString(),
					unit);
			
			Object[] row = product.toRowProduct();
			System.out.println(row);
			DefaultTableModel model = (DefaultTableModel) ProductPanel.prod.table.getModel();
			model.addRow(row);

			break;
		}
		case "Product Modify": {
			int row = ProductPanel.prod.table.getSelectedRow();
			
			System.out.println(ProductPanel.prod.textField.getText());
			System.out.println(ProductPanel.prod.combo[0].getSelectedItem());	
			System.out.println(ProductPanel.prod.combo[1].getSelectedItem());
			System.out.println(row);
			DefaultTableModel model = (DefaultTableModel) ProductPanel.prod.table.getModel();
			String[] product = {ProductPanel.prod.textField.getText(),"Unblocked",ProductPanel.prod.combo[1].getSelectedItem().toString(),ProductPanel.prod.combo[0].getSelectedItem().toString(),""};
			for (int i = 0; i < ProductPanel.prod.table.getColumnCount() ;i++) {
				model.setValueAt(product[i], row, i);
			}
			
			/*
			UnitMeasure unit = new UnitMeasure(ProductPanel.prod.getCombo()[0].getSelectedItem().toString());
			int row1 = ProductPanel.prod.table.getSelectedRow();
			
			Product product = new Product(
					ProductPanel.prod.textField.getText(),
					ProductPanel.prod.table.getValueAt(row1, 1).toString(),
					ProductPanel.prod.getCombo()[1].getSelectedItem().toString(),
					unit);
			
		
			Object[] row = product.toRowProduct();
			
			for (int i = 0; i<row.length;i++) {
			System.out.println(row[i].toString());}
			//DefaultTableModel model = (DefaultTableModel) ProductPanel.prod.table.getModel();
	*/
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
