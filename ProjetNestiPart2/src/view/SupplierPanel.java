package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
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
	public static Supplier activSupplier;
	public static SupplierSell activSupplierSell;

	public static Label[] label;
	public static ComboBox[] combo;
	public static TextField[] textField;
	public static PasswordField passwordField[];
	public static Button[] button;
	public static SupplierPanel panel;
	public static ScrollPane scroll;
	public static JTable table;

	static QuerySupplier querySupp;
	static QuerySupplierSell querySell;
	static QueryProduct queryProd;

	public SupplierPanel() throws Exception {
		this.setBackground(new Color(213, 167, 113));
		this.setLayout(null);
		querySupp = new QuerySupplier();
		querySell = new QuerySupplierSell();
		queryProd = new QueryProduct();

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
		button = supplierButton;

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
		label = supplierLabel;

		ComboBox listSupplier = new ComboBox("listSupp", 182, 31, 339, 32);
		this.add(listSupplier);

		ComboBox listSupplierProduct = new ComboBox("listSuppProd", 26, 301, 184, 32);
		this.add(listSupplierProduct);

		ComboBox[] supplierCombo = { listSupplier, listSupplierProduct };
		combo = supplierCombo;

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

		textField = supplierText;

		ScrollPane spSupplier = new ScrollPane(499, 158, 301, 202);
		this.add(spSupplier);
		scroll = spSupplier;

		tSupplier = new JTable();
		tSupplier.setBackground(new Color(255, 222, 173));
		DefaultTableModel model = new DefaultTableModel(new Object[][] {,},
				new String[] { "Product", "Unit", "Price" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				boolean editable = true;
				if (column < 2) {
					editable = false;
				}
				return editable;
			}
		};
		tSupplier.setModel(model);
		spSupplier.setViewportView(tSupplier);
		suppl = new ValueNeededSupplier(supplierLabel, supplierCombo, supplierText, supplierButton, this, spSupplier,
				tSupplier);
		table = tSupplier;

		btnSupplierBlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (btnSupplierBlock.getText().equals("Unblocked")) {
						btnSupplierBlock.setText("Blocked");
						btnSupplierBlock.setBackground(new Color(243, 101, 101));
					} else if (btnSupplierBlock.getText().equals("Blocked")) {
						btnSupplierBlock.setText("Unblocked");
						btnSupplierBlock.setBackground(new Color(173, 246, 100));
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		btnSupplierLaunch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					clearTable();
					if (!String.valueOf(listSupplier.getSelectedItem()).equals("Create New Supplier")) {
						btnSupplierCreate.setEnabled(false);
						btnSupplierModify.setEnabled(true);

						// create the object supplier from the database according to the name selected
						// in the search combo box
						Supplier supplier = querySupp
								.createSupplierInfo(String.valueOf(listSupplier.getSelectedItem()));
						// add all the information in the TextField
						fillTextField(supplier);
						// create the object supplier sell to have the list of product sold by a
						// supplier
						activSupplierSell = fillProductSupplierTable(supplier);
						activSupplier = supplier;
						btnSupplierBlock.setText(activSupplier.getState());
						if (btnSupplierBlock.getText().equals("Blocked")) {
							btnSupplierBlock.setBackground(new Color(243, 101, 101));
						} else {
							btnSupplierBlock.setBackground(new Color(173, 246, 100));
						}
					} else { // if it is a new supplier

						emptyTextField();
						btnSupplierModify.setEnabled(false);
						btnSupplierCreate.setEnabled(true);
						btnSupplierBlock.setText("Unblocked");
						btnSupplierBlock.setBackground(new Color(173, 246, 100));
					}

					btnSupplierBlock.setEnabled(true);
					btnSupplierPlus.setEnabled(true);
					btnSupplierDEL.setEnabled(true);
					listSupplierProduct.setEnabled(true);
					editableText();

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		btnSupplierCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					// if the name is not already taken
					if (isNameTaken(tfSupplierName.getText()) == false) {
						System.out.println(isNameTaken(tfSupplierName.getText()));
						System.out.println(tfSupplierName.getText());
						Supplier supplCreate = new Supplier(tfSupplierName.getText(), tfSupplierAdress.getText(),
								tfSupplierTown.getText(), tfContactName.getText(), tfContactFirstname.getText(),
								tfContactTel.getText(), "Unblocked", Frame.activAdmin.getId());

						querySupp.createPrepared(supplCreate);
						// if we added product in the table, we have to add it to the database
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						for (int i = 0; i < model.getRowCount(); i++) {
							System.out.println("test");
							Product prod = queryProd.createProductInfo((String) model.getValueAt(i, 0));
							double price = Double.parseDouble(((String) model.getValueAt(i, 2)).split(" ")[0]);
							SupplierSell supplSellCreate = new SupplierSell(supplCreate, prod, price);
							querySell.createPrepared(supplSellCreate);
						}
						// update supplier list in the combo box
						updateListSupplier();
						// clearAll
						clearAndEnableFalse();
						clearTable();

					} else {
						JOptionPane.showMessageDialog(null, "This Supplier's name is already taken");
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		btnSupplierPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String nameProduct = (String) listSupplierProduct.getSelectedItem();
					ArrayList<String> listProductInTable = new ArrayList<String>();
					// this loop is used to have the list of the table products.
					for (int i = 0; i < model.getRowCount(); i++) {
						listProductInTable.add((String) model.getValueAt(i, 0));
					}
					String unit = (String) queryProd.createProductInfo(nameProduct).getUnit().getName();
					// check if the price is a numerical value
					if (isNumeric(tfProductPrice.getText())) {
						Object[] row = { nameProduct, unit, tfProductPrice.getText() + " €/u" };
						// if the product selected in the comboBox is not already in the table
						if (listProductInTable.indexOf(listSupplierProduct.getSelectedItem()) == -1) {
							model.addRow(row); // we add the product to the table
						} else {
							JOptionPane.showMessageDialog(null,
									"This product is already in the list, you can delete it or modify the price directly in the table");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Please enter a valid (numerical) price");
					}

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
					// if we change the name of the selected supplier
					if (!activSupplier.getName().equals(tfSupplierName.getText())) {
						if (isNameTaken(tfSupplierName.getText()) == false) {
							querySupp.updatePrepared("name", tfSupplierName.getText(), activSupplier.getName());
							activSupplier.setName(tfSupplierName.getText());
						} else {
							JOptionPane.showMessageDialog(null, "This Supplier's name is already taken");
							return; // the rest of the method is not used if this condition is not respected !
						}
					}
					if (!activSupplier.getAdress().equals(tfSupplierAdress.getText())) {
						querySupp.updatePrepared("adress", tfSupplierAdress.getText(), activSupplier.getName());
					}
					if (!activSupplier.getCity().equals(tfSupplierTown.getText())) {
						querySupp.updatePrepared("city", tfSupplierTown.getText(), activSupplier.getName());
					}
					if (!activSupplier.getContactLastname().equals(tfContactName.getText())) {
						querySupp.updatePrepared("contactLastname", tfContactName.getText(), activSupplier.getName());
					}
					if (!activSupplier.getContactFirstname().equals(tfContactFirstname.getText())) {
						querySupp.updatePrepared("contactFirstname", tfContactFirstname.getText(),
								activSupplier.getName());
					}
					if (!activSupplier.getContactNumber().equals(tfContactTel.getText())) {
						querySupp.updatePrepared("contactNumber", tfContactTel.getText(), activSupplier.getName());
					}

					if (!activSupplier.getState().equals(btnSupplierBlock.getText())) {
						querySupp.updatePrepared("state", btnSupplierBlock.getText(), activSupplier.getName());
					}

					modifyFromTable();
					// update in the program the activ supplier and activSupplierSell objects
					activSupplier = querySupp.createSupplierInfo(activSupplier.getName());
					activSupplierSell = querySell.createSupplierSellInfo(activSupplier);
					// update List of supplier in the combo box
					updateListSupplier();
					// clearAll
					clearAndEnableFalse();
					clearTable();

				} catch (Exception e1) {
					System.out.println("actionPerformed");
					e1.printStackTrace();
				}
			}
		});

	}

	public void modifyFromTable() throws Exception {
		ArrayList<String> newListProduct = new ArrayList<String>();
		ArrayList<Double> newListPrice = new ArrayList<Double>();
		ArrayList<String> listProductName = new ArrayList<String>();
		String[] prices;
		// in this loop, we collect the lists of prices and products from the table
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (int i = 0; i < model.getRowCount(); i++) {
			// add products from table
			newListProduct.add((String) model.getValueAt(i, 0));
			// get prices from the table by splitting the string
			prices = ((String) model.getValueAt(i, 2)).split(" ");
			// add prices from table
			newListPrice.add(Double.parseDouble(prices[0]));
		}
		// create the list of the product names sold from the activSupplier
		for (int i = 0; i < activSupplierSell.getProducts().size(); i++) {
			listProductName.add(activSupplierSell.getProducts().get(i).getName());
		}
		// we look over the list of products from the table
		for (int i = 0; i < newListProduct.size(); i++) {
			// if a product from the table is not already in the database, we add it
			if (listProductName.indexOf(newListProduct.get(i)) == -1) {
				Product newProduct = queryProd.createProductInfo(newListProduct.get(i));
				SupplierSell newSupplierSellProduct = activSupplierSell;
				newSupplierSellProduct.setBuyingPrice(newListPrice.get(i));
				newSupplierSellProduct.setProduct(newProduct);
				querySell.createPrepared(newSupplierSellProduct);
			} else {
				// if a product from the table is already in the database but the price is
				// different
				if (!String.valueOf(activSupplierSell.getBuyingPrices().get(i))
						.equals(String.valueOf(newListPrice.get(i)))) {
					querySell.updatePrice(String.valueOf(newListPrice.get(i)), newListProduct.get(i),
							activSupplierSell.getSupplier().getName());
				}
			}
		}
		// if a product is in the database but not in the table (delete), we delete it
		// in the database
		for (int i = 0; i < listProductName.size(); i++) {
			if (newListProduct.indexOf(listProductName.get(i)) == -1) {
				querySell.deletePrepared(listProductName.get(i));
			}
		}
	}

	public static void clearTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (int j = model.getRowCount() - 1; j >= 0; j--) {
			model.removeRow(j);
		}
	}

	public static void clearAndEnableFalse() {
		for (TextField text : textField) {
			text.setEditable(false);
			text.setBackground(new Color(216, 206, 209));
			text.setText("");
		}
		for (int i = 1; i < button.length; i++) {
			button[i].setEnabled(false);
		}
		combo[1].setEnabled(false);
		button[1].setText("Block/Unblock");
		button[1].setBackground(new Color(191, 244, 255));
	}

	public static void emptyTextField() {
		for (TextField text : textField) {
			text.setText("");
		}
	}

	public static void editableText() {
		for (TextField text : textField) {
			text.setEditable(true);
			text.setForeground(Color.BLACK);
			text.setBackground(new Color(255, 222, 173));
		}
	}

	public static void updateListSupplier() throws Exception {
		ArrayList<Supplier> listSuppl = new ArrayList<Supplier>();
		combo[0].removeAllItems();
		Supplier newSupplier = new Supplier("Create New Supplier", "", "", "", "", "", "", Frame.activAdmin.getId());
		listSuppl.add(newSupplier);
		for (Supplier sup : querySupp.listAllSupplier()) {
			listSuppl.add(sup);
		}
		for (int i = 0; i < listSuppl.size(); i++) {
			// add the list elements to the search combo box
			combo[0].addItem(listSuppl.get(i).getName());

		}

		combo[0].setSelectedIndex(0);
	}

	public static void updateListProduct() throws Exception {
		combo[1].removeAllItems();
		ArrayList<Product> listProduct = queryProd.listAllProduct();
		for (int i = 0; i < listProduct.size(); i++) {
			// add the list elements to the search combo box
			SupplierPanel.combo[1].addItem(listProduct.get(i).getName());

		}
	}

	public static SupplierSell fillProductSupplierTable(Supplier supplier) throws Exception {
		SupplierSell supplSell = querySell.createSupplierSellInfo(supplier);
		ArrayList<Product> product = supplSell.getProducts();
		ArrayList<Double> buyingPrices = supplSell.getBuyingPrices();
		clearTable();
		if (product.size() > 0) {
			for (int i = 0; i < product.size(); i++) {
				Object[] row = { product.get(i).getName(), product.get(i).getUnit().getName(),
						buyingPrices.get(i) + " €/u" };
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(row);
			}
		}
		return supplSell;
	}

	public static void fillTextField(Supplier supplier) {

		textField[0].setText(supplier.getName());
		textField[1].setText(supplier.getAdress());
		textField[2].setText(supplier.getCity());
		textField[3].setText(supplier.getContactLastname());
		textField[4].setText(supplier.getContactFirstname());
		textField[5].setText(supplier.getContactNumber());
	}

	public static boolean isNumeric(String str) {
		boolean numeric = false;
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			System.err.println("Erreur numeric : " + e.getMessage());
		}
		return numeric;
	}

	public static boolean isNameTaken(String name) {
		boolean taken = true;
		ArrayList<String> list = new ArrayList<String>();
		// loop on all the suppliers in the comboBox (same as database)
		for (int i = 0; i < combo[0].getItemCount(); i++) {
			list.add((String) combo[0].getItemAt(i));
		}
		// if the new name is not already taken
		if (list.indexOf(name) == -1) {
			taken = false;
		}
		return taken;
	}

}
