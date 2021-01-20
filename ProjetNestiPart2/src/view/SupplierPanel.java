package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entities.Admin;
import entities.Product;
import entities.Supplier;
import entities.SupplierSell;
import model.QueryAdmin;
import model.QueryProduct;
import model.QuerySupplier;
import model.QuerySupplierSell;

public class SupplierPanel extends JPanel {
	private JTable tSupplier;
	public static ValueNeededSupplier suppl;
	private Supplier activSupplier;
	private SupplierSell activSupplierSell;
	
	public static Label[] label;
	public static ComboBox[] combo;
	public static TextField[] textField;
	public static PasswordField passwordField[];
	public static Button[] button;
	public static SupplierPanel panel;
	public static ScrollPane scroll;
	public static JTable table;

	public SupplierPanel() throws Exception {
		this.setBackground(new Color(213, 167, 113));
		this.setLayout(null);

		Button btnSupplierLaunch = new Button("LaunchSupplier", 531, 36, 86, 23);
		this.add(btnSupplierLaunch);

		Button btnSupplierBlock = new Button("SupplierBlock / Unblock", 10, 72, 122, 23);
		this.add(btnSupplierBlock);

		Button btnSupplierPlus = new Button("+_Supplier", 376, 306, 50, 23);
		this.add(btnSupplierPlus);

		Button btnSupplierCreate = new Button("Supplier_Create", 141, 365, 113, 32);
		this.add(btnSupplierCreate);

		Button btnSupplierModify = new Button("Supplier_Modify", 376, 365, 113, 32);
		this.add(btnSupplierModify);

		Button btnSupplierDEL = new Button("DEL", 614, 365, 62, 32);
		this.add(btnSupplierDEL);

		Button[] supplierButton = { btnSupplierLaunch, btnSupplierBlock, btnSupplierPlus, btnSupplierCreate,
				btnSupplierModify, btnSupplierDEL };
		this.button=supplierButton;

		Label lblSupplierSearch = new Label("Search", 125, 34, 95, 27);
		this.add(lblSupplierSearch);

		Label lblSupplierName = new Label("Supplier Name", 20, 112, 92, 14);
		this.add(lblSupplierName);

		Label lblSupplierAdress = new Label("Supplier Adress", 152, 112, 199, 14);
		this.add(lblSupplierAdress);

		Label lblSupplierTown = new Label("Supplier Town", 376, 112, 85, 14);
		this.add(lblSupplierTown);

		Label lblSupplierContactName = new Label("Contact Name", 20, 161, 86, 14);
		this.add(lblSupplierContactName);

		Label lblSupplierContactFistname = new Label("Contact Fistname", 162, 161, 127, 14);
		this.add(lblSupplierContactFistname);

		Label lblSupplierContactPhone = new Label("Contact phone", 299, 161, 91, 14);
		this.add(lblSupplierContactPhone);

		Label lblSupplierProductPrice = new Label("Product Price", 245, 282, 87, 14);
		this.add(lblSupplierProductPrice);

		Label lblSupplierProduct = new Label("Supplier Product", 26, 276, 106, 14);
		this.add(lblSupplierProduct);

		Label[] supplierLabel = { lblSupplierSearch, lblSupplierName, lblSupplierAdress, lblSupplierTown,
				lblSupplierContactName, lblSupplierContactFistname, lblSupplierContactPhone, lblSupplierProductPrice,
				lblSupplierProduct };
		this.label=supplierLabel;

		ComboBox listSupplier = new ComboBox("listSupp", 182, 31, 339, 32);
		this.add(listSupplier);

		ComboBox listSupplierProduct = new ComboBox("listSuppProd", 26, 301, 184, 32);
		this.add(listSupplierProduct);

		ComboBox[] supplierCombo = { listSupplier, listSupplierProduct };
		this.combo=supplierCombo;

		TextField tfSupplierName = new TextField("supplierName", 26, 133, 115, 20);
		this.add(tfSupplierName);

		TextField tfSupplierAdress = new TextField("supplierAdress", 151, 133, 213, 20);
		this.add(tfSupplierAdress);

		TextField tfSupplierTown = new TextField("supplierTown", 375, 133, 122, 20);
		this.add(tfSupplierTown);

		TextField tfContactName = new TextField("contactName", 26, 180, 123, 20);
		this.add(tfContactName);

		TextField tfContactFirstname = new TextField("contactFirstname", 166, 180, 123, 20);
		this.add(tfContactFirstname);

		TextField tfContactTel = new TextField("contactTel", 305, 180, 113, 20);
		this.add(tfContactTel);

		TextField tfProductPrice = new TextField("productPrice", 245, 306, 86, 20);
		this.add(tfProductPrice);

		TextField[] supplierText = { tfSupplierName, tfSupplierAdress, tfSupplierTown, tfContactName,
				tfContactFirstname, tfContactTel, tfProductPrice };
		this.textField=supplierText;
		
		ScrollPane spSupplier = new ScrollPane(499, 158, 301, 202);
		this.add(spSupplier);
		this.scroll=spSupplier;

		tSupplier = new JTable();
		tSupplier.setBackground(new Color(255, 222, 173));
		DefaultTableModel model = new DefaultTableModel(new Object[][] {,},
				new String[] { "Product", "Unit", "Price" });
		tSupplier.setModel(model);
		spSupplier.setViewportView(tSupplier);
		suppl = new ValueNeededSupplier(supplierLabel, supplierCombo, supplierText, supplierButton, this, spSupplier,
				tSupplier);
		this.table=tSupplier;
		
		btnSupplierLaunch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					// create the object supplier from the database according to the name selected
					// in the search combo box
					Supplier supplier = QuerySupplier.querySuppl
							.createSupplierInfo(String.valueOf(listSupplier.getSelectedItem()));
					// add all the information in the TextField
					tfSupplierName.setText(supplier.getName());
					tfSupplierAdress.setText(supplier.getAdress());
					tfSupplierTown.setText(supplier.getCity());
					tfContactName.setText(supplier.getContactLastname());
					tfContactFirstname.setText(supplier.getContactFirstname());
					tfContactTel.setText(supplier.getContactNumber());
					// create the object supplier sell to have the list of product sold by a
					// supplier
					SupplierSell supplSell = QuerySupplierSell.querySell.createSupplierSellInfo(supplier);
					ArrayList<Product> product = supplSell.getProducts();
					ArrayList<Double> buyingPrices = supplSell.getBuyingPrices();
					clearTable();
					if (product.size() > 0) {
						for (int i = 0; i < product.size(); i++) {
							Object[] row = { product.get(i).getName(), product.get(i).getUnit().getName(),
									buyingPrices.get(i) + " €/u" };
							model.addRow(row);
						}
					}
					activSupplier = supplier;
					activSupplierSell = supplSell;

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		btnSupplierCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Admin admin = QueryAdmin.queryAdm.createAdminInfo("JohnnyDoe35");

					Supplier supplCreate = new Supplier(tfSupplierName.getText(), tfSupplierAdress.getText(),
							tfSupplierTown.getText(), tfContactName.getText(), tfContactFirstname.getText(),
							tfContactTel.getText(), "Unblocked", admin.getId());

					QuerySupplier.querySuppl.createPrepared(supplCreate);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		btnSupplierPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String nameProduct = (String) listSupplierProduct.getSelectedItem();
					String unit = (String) QueryProduct.queryProd.createProductInfo(nameProduct).getUnit().getName();
					Object[] row = { nameProduct, unit, tfProductPrice.getText() + " €/u" };
					model.addRow(row);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnSupplierDEL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					model.removeRow(tSupplier.getSelectedRow());

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		btnSupplierModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

//				if (!activSupplier.getName().equals(tfSupplierName.getText())) {
//					QuerySupplier.querySuppl.updatePrepared("name", tfSupplierName.getText(), activSupplier.getName());
//				} 
//				if (!activSupplier.getAdress().equals(tfSupplierAdress.getText())) {
//					QuerySupplier.querySuppl.updatePrepared("adress", tfSupplierAdress.getText(), activSupplier.getName());
//				}
//				if (!activSupplier.getCity().equals(tfSupplierTown.getText())) {
//					QuerySupplier.querySuppl.updatePrepared("city", tfSupplierTown.getText(), activSupplier.getName());
//				}
//				if (!activSupplier.getContactLastname().equals(tfContactName.getText())) {
//					QuerySupplier.querySuppl.updatePrepared("contactLastname", tfContactName.getText(), activSupplier.getName());
//				}
//				if (!activSupplier.getContactFirstname().equals(tfContactFirstname.getText())) {
//					QuerySupplier.querySuppl.updatePrepared("contactFirstname", tfContactFirstname.getText(), activSupplier.getName());
//				}
//				if (!activSupplier.getContactNumber().equals(tfContactTel.getText())) {
//					QuerySupplier.querySuppl.updatePrepared("contactNumber", tfContactTel.getText(), activSupplier.getName());
//				}

					modifyFromTable();
					
					activSupplier=QuerySupplier.querySuppl.createSupplierInfo(activSupplier.getName()); // update in java activ supplier
					activSupplierSell=QuerySupplierSell.querySell.createSupplierSellInfo(activSupplier);

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		

	}
	
	public void modifyFromTable() throws Exception {
		ArrayList<String> newListProduct = new ArrayList<String>();
		ArrayList<Double> newListPrice = new ArrayList<Double>();
		ArrayList<String> listProductName = new ArrayList<String>();
		// in this loop, we collect the lists of prices and products from the table
		DefaultTableModel model = (DefaultTableModel) this.table.getModel();
		for (int i = 0; i < model.getRowCount(); i++) {
			newListProduct.add((String) model.getValueAt(i, 0));
			String[] prices = ((String) model.getValueAt(i, 2)).split(" ");
			newListPrice.add(Double.parseDouble(prices[0]));
		}
		// create the list of the product names sold from the activSupplier
		for (int i = 0; i < activSupplierSell.getProducts().size(); i++) {
			listProductName.add(activSupplierSell.getProducts().get(i).getName());
		}
		// if a product from the table is not already in the database, we add it
		for (int i = 0; i < newListProduct.size(); i++) {
				if (listProductName.indexOf(newListProduct.get(i)) == -1) {
					Product newProduct = QueryProduct.queryProd.createProductInfo(newListProduct.get(i));
					SupplierSell newSupplierSellProduct = activSupplierSell;
					newSupplierSellProduct.setBuyingPrice(newListPrice.get(i));
					newSupplierSellProduct.setProduct(newProduct);
					QuerySupplierSell.querySell.createPrepared(newSupplierSellProduct);
				}						
		}
		for (int i=0;i<listProductName.size();i++) {
			if (newListProduct.indexOf(listProductName.get(i))==-1) {
				QuerySupplierSell.querySell.deletePrepared(listProductName.get(i));
			}
		}
	}
	
	
	public static void clearTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (int j = model.getRowCount() - 1; j >= 0; j--) {
			model.removeRow(j);
		}
	}
	public static void clearTextFields() {
		for (int i=0;i<textField.length;i++) {
			textField[i].setText("");
		}
		
		
		
	}

}
