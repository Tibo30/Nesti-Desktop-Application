package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



import entities.Article;
import entities.Product;
import entities.UnitMeasure;
import model.QueryArticle;
import model.QueryProduct;
import tools.Check;

public class ProductPanel extends JPanel {
	public static JTable table_1;

	public static Label[] label;
	public static ComboBox[] combo;
	public static TextField[] textField;
	public static PasswordField passwordField[];
	public static Button[] button;
	public static SupplierPanel panel;
	public static ScrollPane scroll;
	private static QueryProduct queryProd;
	private static QueryArticle queryArticle;
	public static Product activProduct;

	boolean flag;

	public ProductPanel() throws Exception {
		this.setBackground(new Color(213, 167, 113));
		this.setLayout(null);
		this.queryProd = new QueryProduct();
		this.queryArticle = new QueryArticle();

		Button btnProductBlock = new Button("Block /Unblock selected Element", 26, 337, 183, 39);
		btnProductBlock.setEnabled(false);

		this.add(btnProductBlock);

		Button btnProductAddTextfield = new Button("+_Product", 26, 285, 89, 46);
		btnProductAddTextfield.setEnabled(false);
		this.add(btnProductAddTextfield);

		Button btnProductModify = new Button("Product Modify", 121, 284, 89, 46);
		btnProductModify.setEnabled(false);

		this.add(btnProductModify);

		Button[] productButton = { btnProductBlock, btnProductAddTextfield };
		button = productButton;
		Label lblProductIngredient = new Label("Type of product", 31, 84, 121, 14);
		this.add(lblProductIngredient);

		Label lblProductUnit = new Label("Product Unit", 26, 224, 78, 14);
		this.add(lblProductUnit);

		Label lblProduct = new Label("Product", 31, 152, 175, 30);
		this.add(lblProduct);

		Label[] productLabel = { lblProductIngredient, lblProductUnit, lblProduct };
		label = productLabel;

		ComboBox listProductUnit = new ComboBox("listProdUnit", 26, 242, 180, 32);
		this.add(listProductUnit);

		ComboBox listProductType = new ComboBox("listProdType", 26, 109, 180, 32);
		this.add(listProductType);

		ComboBox[] productComboBox = { listProductUnit, listProductType };
		combo = productComboBox;

		ScrollPane scrollPane_1 = new ScrollPane(289, 55, 444, 271);
		scrollPane_1.setEnabled(false);
		this.add(scrollPane_1);

		TextField tfProduct = new TextField("product", 26, 181, 180, 32);
		this.add(tfProduct);

		table_1 = new JTable() {
			public boolean isCellEditable(int d, int c) {
				return false;
			}
		};
		/*
		 * Give visual effect and extract value when user click on table row
		 * 
		 */
		table_1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				flag = true;
				// by default
				if (table_1.getSelectedRow() != 0) {
					btnProductBlock.setEnabled(true);
					btnProductModify.setEnabled(true);
					btnProductAddTextfield.setEnabled(true);
					btnProductModify.setBackground(new Color(232, 250, 126));
				}
				// inject value of row in textfield ans list
				int row = table_1.getSelectedRow();
				tfProduct.setText((String) table_1.getValueAt(row, 0));
				listProductUnit.setSelectedItem((String) table_1.getValueAt(row, 3));
				listProductType.setSelectedItem((String) table_1.getValueAt(row, 2));
				// Give color of button Block/unblock
				if (table_1.getValueAt(row, 1).equals("Blocked")) {
					btnProductBlock.setText("Blocked");
					btnProductBlock.setBackground(new Color(243, 101, 101));
				}
				if (table_1.getValueAt(row, 1).equals("Unblocked")) {
					btnProductBlock.setBackground(new Color(173, 246, 100));
					btnProductBlock.setText("Unblocked");
				}
				try {
					// Give product info
					Product Product = queryProd.createProductInfo((String) table_1.getValueAt(row, 0));
					activProduct = Product;
				} catch (Exception e1) {
					System.out.println("error query Product");
					e1.printStackTrace();
				}
			}
		});

		table_1.setShowHorizontalLines(false);
		table_1.setBackground(new Color(255, 222, 173));
		DefaultTableModel model2 = new DefaultTableModel(new Object[][] {,},
				new String[] { "Product", "State", "Type", "Unit", "Nb Articles" });

		table_1.setModel(model2);
		scrollPane_1.setViewportView(table_1);

		btnProductAddTextfield.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				int mousetrue;
				int rowadd = table_1.getSelectedRow();
				
				// Validate condition of adding Product
				if (rowadd != -1) {
					if (tfProduct.getText().toString().equals("")) {

						JOptionPane.showMessageDialog(null, "Product is empty");
					} else {
						System.out.println(tfProduct.getText().toString());

						if (table_1.getSelectedRow() != -1) {

							if (!tfProduct.getText().equals(table_1.getValueAt(table_1.getSelectedRow(), 0))) {

								UnitMeasure unit = new UnitMeasure(listProductUnit.getSelectedItem().toString());

								if (flag == true) {
									mousetrue = table_1.getSelectedRow();
								} else {
									mousetrue = table_1.getRowCount() - 1;
								}
								// Create an object product with value and add it in table
								if (Check.isValidString(tfProduct.getText())) {
								
								Product product = new Product(tfProduct.getText(),
										table_1.getValueAt(mousetrue, 1).toString(),
										listProductType.getSelectedItem().toString(), unit);

								Object[] row = product.toRowProduct();

								DefaultTableModel model = (DefaultTableModel) table_1.getModel();
								model.addRow(row);
								}else {
									JOptionPane.showMessageDialog(null, "Please enter a valid string with max 50 caracters.");
								}
								try {
									// Send Object to DDB
									UnitMeasure unitinfo = queryProd
											.createUnitInfo((String) listProductUnit.getSelectedItem());
									Product pro = new Product(tfProduct.getText(), "Unblocked",
											(String) listProductType.getSelectedItem(), unitinfo);
									queryProd.createPrepared(pro);
								} catch (Exception e) {

									e.printStackTrace();
								}

							} else {
								JOptionPane.showMessageDialog(null, "This Product's name is already taken");
							}
						} else {
							JOptionPane.showMessageDialog(null, "Click on the table");
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Click on the table adding element");

				}
			}
		});

		/*
		 * Button add Product
		 */
		btnProductModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = table_1.getSelectedRow();
				
				if (row != -1) {
					try {
				
						// Controle if the name is already use and if not Change it
						if (!activProduct.getName().equals(tfProduct.getText())) {
							if (SupplierPanel.isNameTaken(tfProduct.getText()) == false) {
								if (Check.isValidString(tfProduct.getText())) {
								queryProd.UpdateProductPrepared("name", tfProduct.getText(), activProduct.getName());
								activProduct.setName(tfProduct.getText());
							
								}
							} else {
								JOptionPane.showMessageDialog(null, "This Product's name is already taken");
							}
						}
					} catch (Exception e) {
						System.out.println("UpdateProductPrepared name error");
						e.printStackTrace();
					}

					try {
						// Change the type to the product in DDB
						if (!activProduct.getType().equals(listProductType.getSelectedItem().toString())) {
							queryProd.UpdateProductPrepared("type", listProductType.getSelectedItem().toString(),
									activProduct.getName());
						}
					} catch (Exception e) {
						System.out.println("UpdateProductPrepared type error");
						e.printStackTrace();
					}
					try {
						// Change the unit to the product in DDB
						if (!activProduct.getUnit().getName().equals(listProductUnit.getSelectedItem().toString())) {
							queryProd.UpdateProductPrepared("unit", (String) listProductUnit.getSelectedItem(),
									activProduct.getName());
						}
					} catch (Exception e) {
						System.out.println("UpdateProductPrepared  unit error");
						e.printStackTrace();
					}
					try {
						// Change all element in table
						DefaultTableModel model = (DefaultTableModel) table_1.getModel();
						String[] product = { tfProduct.getText(), "Unblocked", combo[1].getSelectedItem().toString(),
								combo[0].getSelectedItem().toString(), "" };
						if (tfProduct.getText() != null && combo[1].getSelectedItem().toString() != null) {

							for (int i = 0; i < table_1.getColumnCount(); i++) {
								model.setValueAt(product[i], row, i);
							}
							// Reinitialize table
							clearTable();
							creatTable();
							emptyCombobox();
							createUnitList();
							createTypeList();
							
						}
					} catch (Exception e) {
						System.out.println("modify clear table error");
						e.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selectionné la ligne par un double click pour modifier");

				}
			}
		});

		/*
		 * Change the color and the state of Product
		 */
		btnProductBlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int row = table_1.getSelectedRow();
				boolean only = true;

				if (table_1.getValueAt(row, 1).equals("Unblocked") && (only == true)) {
					// Block the product visualy
					only = false;
					Object toto = "Blocked";
					btnProductBlock.setText("Blocked");
					btnProductBlock.setBackground(new Color(243, 101, 101));
					DefaultTableModel model = (DefaultTableModel) table_1.getModel();
					model.setValueAt(toto, row, 1);

				} else {
					// Unblock the product visualy
					only = true;
					Object toto = "Unblocked";
					btnProductBlock.setText("Unblocked");
					btnProductBlock.setBackground(new Color(173, 246, 100));
					DefaultTableModel model = (DefaultTableModel) table_1.getModel();
					model.setValueAt(toto, row, 1);

				}
				if (!activProduct.getState().equals(table_1.getValueAt(row, 1))) {
					try {
						// Give the value to the DDB
						queryProd.UpdateProductPrepared("state", table_1.getValueAt(row, 1).toString(),
								activProduct.getName());
					} catch (Exception e) {
						System.out.println("error query update Product");
						e.printStackTrace();
					}
				}
			}
		});
	}

	/*
	 * Create the table format
	 */
	public static void creatTable() {
		ArrayList<Product> listProd;
		ArrayList<Article> listAllArticle;
		try {
			listProd = queryProd.listAllProductYann();
			listAllArticle = queryArticle.listAllArticle();

			DefaultTableModel model = (DefaultTableModel) ProductPanel.table_1.getModel();
			for (int i = 0; i < listProd.size(); i++) {
				double quant;
				// add the list elements to the search combo box
				// System.out.println(listProd.get(i).getState());
				try {
					quant = (double) listAllArticle.get(i).getQuantity();
				} catch (Exception e) {
					quant = 0;

				}
				// Row object and is attributs
				Object[] row = { listProd.get(i).getName(), listProd.get(i).getState(), listProd.get(i).getType(),
						listProd.get(i).getUnit().getName(), formatD(quant) };

				model.addRow(row);
			}
		} catch (Exception e) {
			System.out.println("error table creation Product");
			e.printStackTrace();
		}
	}

	/**
	 * create list of unit
	 */
	public static void createUnitList() {
		try {
			ArrayList<UnitMeasure> listUnit = queryProd.AllUnit();

			// add the list elements to the search combo box
			for (int i = 0; i < listUnit.size(); i++) {

				ProductPanel.combo[0].addItem(listUnit.get(i).getName());

			}

		} catch (Exception e2) {

			e2.printStackTrace();
		}
	}

	/**
	 * Creat list of type
	 */
	public static void createTypeList() {
		try {
			ArrayList<String> listType = queryProd.AllType();

			// add the list elements to the search combo box
			for (int i = 0; i < listType.size(); i++) {
				ProductPanel.combo[1].addItem(listType.get(i));
			}

		} catch (Exception e2) {

			e2.printStackTrace();

		}
	}

	/*
	 * Clear table function
	 */
	public static void clearTable() {
		DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		for (int j = model.getRowCount() - 1; j >= 0; j--) {
			model.removeRow(j);
		}
	}
	public static void emptyCombobox() {
		for (ComboBox text : combo) {
			text.removeAllItems();
		}
	}

	/*
	 * Change the format of the number
	 */
	public static String formatD(double number) {
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.US);
		DecimalFormat df = new DecimalFormat("#.##########", otherSymbols);
		String resultFormat = df.format(number);
		return resultFormat;
	}
	
}