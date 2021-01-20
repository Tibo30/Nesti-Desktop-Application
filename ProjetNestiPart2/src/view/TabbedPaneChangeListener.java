package view;

import java.util.ArrayList;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import entities.Product;
import entities.Supplier;
import model.QueryProduct;
import model.QuerySupplier;

public class TabbedPaneChangeListener implements ChangeListener {
	boolean supplier=false;
	
	@Override
	public void stateChanged(ChangeEvent e) {
		
		if (e.getSource() instanceof JTabbedPane) {
			JTabbedPane pane = (JTabbedPane) e.getSource();
			System.out.println("Selected paneNo : " + pane.getSelectedIndex());
			if (pane.getSelectedIndex() == 2) {
				SupplierPanel.clearTextFields();
				SupplierPanel.clearTable();
				
				if (supplier==false) {
					supplier=true;
					try {
						// create the list of supplier from the database
						ArrayList<Supplier> listSuppl=QuerySupplier.querySuppl.listAllSupplier();
						for (int i = 0; i < listSuppl.size(); i++) {
							//add the list elements to the search combo box
							SupplierPanel.combo[0].addItem(listSuppl.get(i).getName());
							
						}
						
						ArrayList<Product> listProduct=QueryProduct.queryProd.listAllProduct();
						for (int i = 0; i < listProduct.size(); i++) {
							//add the list elements to the search combo box
							SupplierPanel.combo[1].addItem(listProduct.get(i).getName());
							
						}
						
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
				}
				}
				
//			 else if  (pane.getSelectedIndex() == 5) {
//
//                try {
//                    ArrayList<Product> listProd=QueryProduct.queryProd.createProductInfo();
//                    for (int i = 0; i < listProd.size(); i++) {
//                        //add the list elements to the search combo box
//                        Frame.table_1.getTable()[0].addItem(listProd.get(i));
//                    }
//
//
//                } catch (Exception e1) {
//
//                    e1.printStackTrace();
//                }
//			}
		}

	}

}
