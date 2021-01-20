package view;

import java.util.ArrayList;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import entities.Product;
import model.QueryProduct;
import model.QuerySupplier;

public class TabbedPaneChangeListener implements ChangeListener {
	boolean supplier=false;
	
	@Override
	public void stateChanged(ChangeEvent e) {
		
		if (e.getSource() instanceof JTabbedPane) {
			JTabbedPane pane = (JTabbedPane) e.getSource();
			

			if (pane.getSelectedIndex() == 2 && supplier==false) {
				supplier=true;
				try {
					// create the list of supplier from the database
					ArrayList<String> listSuppl=QuerySupplier.querySuppl.listAllSupplier();
					for (int i = 0; i < listSuppl.size(); i++) {
						//add the list elements to the search combo box
						Frame.suppl.getCombo()[0].addItem(listSuppl.get(i));
						
					}
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}else if  (pane.getSelectedIndex() == 5) {
				
				try {
					ArrayList<Product> listProd=QueryProduct.queryProd.createProductInfo();
					for (int i = 0; i < listProd.size(); i++) {
						//add the list elements to the search combo box
						Frame.table_1.getTable()[0].addItem(listProd.get(i));
					}
					
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
		}
		
		
		

		}

	}


