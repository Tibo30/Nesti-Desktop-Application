package view;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import entities.Product;
import entities.UnitMeasure;
import model.QueryProduct;
import model.QuerySupplier;



public class TabbedPaneChangeListener implements ChangeListener {
	boolean supplier = false;
	boolean product = false;

	@Override
	public void stateChanged(ChangeEvent e) {

		if (e.getSource() instanceof JTabbedPane) {
			JTabbedPane pane = (JTabbedPane) e.getSource();

			if (pane.getSelectedIndex() == 2 && supplier == false) {
				supplier = true;
				try {
					// create the list of supplier from the database
					ArrayList<String> listSuppl = QuerySupplier.querySuppl.listAllSupplier();
					for (int i = 0; i < listSuppl.size(); i++) {
						// add the list elements to the search combo box
						Frame.suppl.getCombo()[0].addItem(listSuppl.get(i));

					}

				} catch (Exception e1) {

					e1.printStackTrace();
				}

			} else if (pane.getSelectedIndex() == 5 && product == false) {
				product = true;
				try {
					ArrayList<Product> listProd = QueryProduct.queryProd.listAllProduct();
					DefaultTableModel model = (DefaultTableModel) ProductPanel.prod.getTable().getModel();
					for (int i = 0; i < listProd.size(); i++) {
						// add the list elements to the search combo box
						Object[] row = { listProd.get(i).getName(), listProd.get(i).getState(),listProd.get(i).getType(),
							 listProd.get(i).getUnit().getName(),	listProd.get(i).getQuantity() };
						model.addRow(row);
					}
					
					
					
				}catch (Exception e1) {
					e1.printStackTrace();
					
				}
				try {
					ArrayList<UnitMeasure> listUnit = QueryProduct.queryProd.AllUnit();

					// add the list elements to the search combo box
					for (int i = 0; i < listUnit.size(); i++) {

						ProductPanel.prod.getCombo()[0].addItem(listUnit.get(i).getName());

					}

				} catch (Exception e2) {

					e2.printStackTrace();

				}

			
			try {
				ArrayList<String> listType = QueryProduct.queryProd.AllType();

				// add the list elements to the search combo box
				for (int i = 0; i < listType.size(); i++) {
				
					ProductPanel.prod.getCombo()[1].addItem(listType.get(i));

				}

			} catch (Exception e2) {

				e2.printStackTrace();

			}
		}

		}
		}
	}
}
