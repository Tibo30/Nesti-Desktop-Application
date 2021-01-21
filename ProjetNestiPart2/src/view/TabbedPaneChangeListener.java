package view;

import java.util.ArrayList;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import entities.Admin;
import entities.Product;
import entities.Supplier;
import model.QueryAdmin;
import model.QueryProduct;
import model.QuerySupplier;

public class TabbedPaneChangeListener implements ChangeListener {
	boolean supplier = false;

	@Override
	public void stateChanged(ChangeEvent e) {

		if (e.getSource() instanceof JTabbedPane) {
			JTabbedPane pane = (JTabbedPane) e.getSource();
			System.out.println("Selected paneNo : " + pane.getSelectedIndex());
			if (pane.getSelectedIndex() == 2) {
				SupplierPanel.clearAndEnableFalse();
				SupplierPanel.clearTable();

				try {
					// create the list of supplier from the database
					SupplierPanel.updateListSupplier();
					// create the list of products from the database
					SupplierPanel.updateListProduct();

				} catch (Exception e1) {

					e1.printStackTrace();
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
