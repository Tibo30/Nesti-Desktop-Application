package view;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import entities.Admin;
import entities.Product;
import entities.Supplier;
import model.QueryAdmin;
import entities.UnitMeasure;
import model.QueryProduct;
import model.QuerySupplier;

public class TabbedPaneChangeListener implements ChangeListener {
	boolean supplier = false;
	boolean product = false;
	private QueryAdmin queryAdmin = new QueryAdmin();
	private QueryProduct queryProd = new QueryProduct();
	@Override
	public void stateChanged(ChangeEvent e) {

		if (e.getSource() instanceof JTabbedPane) {
			JTabbedPane pane = (JTabbedPane) e.getSource();

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

			} else if (pane.getSelectedIndex() == 3) {
				
				OrderPanel.clearTable();
				OrderPanel.clearAndEnableFalse();
				
				try {					
					OrderPanel.listOfOrder();
					OrderPanel.listOfArticle();
					OrderPanel.listOfSupplier();
					OrderPanel.listOfProduct();
					OrderPanel.listOfPackaging();
					OrderPanel.listState();

				} catch (Exception e1) {

					e1.printStackTrace();
				}

			} else if (pane.getSelectedIndex() == 5 && product == false) {
				product = true;
				try {
					ArrayList<Product> listProd =queryProd.listAllProduct();
				
					DefaultTableModel model = (DefaultTableModel) ProductPanel.table_1.getModel();
					for (int i = 0; i < listProd.size(); i++) {
						// add the list elements to the search combo box
					//	System.out.println(listProd.get(i).getState());
						Object[] row = { 
								listProd.get(i).getName(), listProd.get(i).getState(),
								listProd.get(i).getType(), listProd.get(i).getUnit().getName(),""
								 };
						
						model.addRow(row);
					}

				} catch (Exception e1) {
					e1.printStackTrace();

				}
				try {
					ArrayList<UnitMeasure> listUnit = queryProd.AllUnit();

					// add the list elements to the search combo box
					for (int i = 0; i < listUnit.size(); i++) {

						ProductPanel.combo[0].addItem(listUnit.get(i).getName());

					}

				} catch (Exception e2) {

					e2.printStackTrace();

				}

				try {
					ArrayList<String> listType = queryProd.AllType();

					// add the list elements to the search combo box
					for (int i = 0; i < listType.size(); i++) {

						ProductPanel.combo[1].addItem(listType.get(i));

					}

				} catch (Exception e2) {

					e2.printStackTrace();

				}
			} else if (pane.getSelectedIndex() == 7) {

                try { 

                    ArrayList<Admin> listAdmin =  queryAdmin.listAllAdmin();
                    for (int i=0; i< listAdmin.size(); i++) {

//                        liste d'objets dans combo avec toString pas besoin de requête

                        ManagePanel.combo.addItem(listAdmin.get(i));

                    }



                }catch (Exception e1) {
                    e1.printStackTrace();

                }
			}

		}
	}
}
