package view;

import javax.swing.JComboBox;

import model.QuerySupplier;

public class ComboBox extends JComboBox {

	

	public ComboBox(String name, int x, int y, int L, int l) throws Exception {
		this.setBounds(x, y, L, l);
		
	if(name.equals("listSupp")) {
		// get the list of the suppliers
		for (int i=0;i<QuerySupplier.querySuppl.listAllSupplier().size();i++) {
			this.addItem(QuerySupplier.querySuppl.listAllSupplier().get(i));
		}
	
	}
	if(name.equals("ProductSearch")) {
		// get the list of the suppliers
		for (int i=0;i<QuerySupplier.querySuppl.listAllSupplier().size();i++) {
			
		}
		
		
	}
}}
