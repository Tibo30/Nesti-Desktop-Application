package view;

import java.util.ArrayList;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import entities.Admin;
import model.QueryAdmin;
import model.QueryArticle;
import model.QueryProduct;

public class TabbedPaneChangeListener implements ChangeListener {
	boolean supplier = false;
	boolean product = false;
	private QueryAdmin queryAdmin = new QueryAdmin();
	private QueryProduct queryProd = new QueryProduct();
	private QueryArticle queryArt = new QueryArticle();
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
//					OrderPanel.listOfArticle();
//					OrderPanel.listOfSupplier();
//					OrderPanel.listOfProduct();
//					OrderPanel.listState();
					OrderPanel.listOfPackaging();
				} catch (Exception e1) {

					e1.printStackTrace();
				}
			}else if (pane.getSelectedIndex() == 4 ) {
				try {
					
					ArticlePanel.creatListOfArticle();
					ArticlePanel.updateListArticle();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			} else if (pane.getSelectedIndex() == 5 && product == false) {
				product = true;
				ProductPanel.creatTable();
				ProductPanel.createUnitList();
				ProductPanel.createTypeList();
					
			}
		}
	}
}
