package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import entities.Article;
import entities.Order;
import entities.OrderLine;
import entities.Packaging;
import entities.Product;
import entities.Supplier;
import entities.SupplierSell;
import model.QueryArticle;
import model.QueryOrder;
import model.QueryPackaging;
import model.QueryProduct;
import model.QuerySupplier;
import model.QuerySupplierSell;

public class OrderPanel extends JPanel {

	private JTable table_Order;
	public static Label[] label;
	public static ComboBox[] combo;
	public static TextField[] textField;
	public static PasswordField passwordField[];
	public static Button[] button;
	public static SupplierPanel panel;
	public static ScrollPane scroll;
	public static JTable table;
	private static QueryArticle queryArticle;
	private static QuerySupplier querySupplier;
	private static QueryProduct queryProduct;
	private static QueryPackaging queryPackaging;
	private static QueryOrder queryOrder;
	private static QuerySupplierSell querySupplierSell;
	public static Order activOrder;
	public static Article activArticle;
	public static Supplier activSupplier;
	public static Product activProduct;

	public OrderPanel() throws Exception {
		this.setBackground(new Color(213, 167, 113));
		this.setLayout(null);
		queryArticle = new QueryArticle();
		querySupplier = new QuerySupplier();
		queryProduct = new QueryProduct();
		queryPackaging = new QueryPackaging();
		queryOrder = new QueryOrder();
		querySupplierSell = new QuerySupplierSell();

		Button btnOrderLaunch = new Button("Order_Launch", 360, 20, 86, 23);
		this.add(btnOrderLaunch);

		Button btnOrderArticleLaunch = new Button("OrderArticle_Launch", 500, 62, 86, 23);
		btnOrderArticleLaunch.setName("Add");
		this.add(btnOrderArticleLaunch);

		Button btnOrderAdd = new Button("+_Order2", 544, 116, 50, 23);
		this.add(btnOrderAdd);

		Button btnOrderAdd2 = new Button("+_Order1", 705, 182, 45, 23);
		this.add(btnOrderAdd2);

		Button btnOrderMinus = new Button("-_Order", 705, 210, 45, 23);
		this.add(btnOrderMinus);

		Button btnOrderRemove = new Button("x_Order", 705, 240, 45, 23);
		this.add(btnOrderRemove);

		Button btnOrderModify = new Button("Order_Modify", 154, 371, 113, 32);
		this.add(btnOrderModify);

		Button btnOrderCreate = new Button("Order_Create", 496, 371, 113, 32);
		this.add(btnOrderCreate);

		Button[] orderButtons = { btnOrderLaunch, btnOrderArticleLaunch, btnOrderAdd, btnOrderAdd2, btnOrderMinus,
				btnOrderRemove, btnOrderModify, btnOrderCreate };
		button = orderButtons;

		Label lblOrderSearch = new Label("Search Order", 31, 8, 178, 45);
		this.add(lblOrderSearch);

		Label lblArticleSearch = new Label("Search Article", 31, 50, 178, 45);
		this.add(lblArticleSearch);

		Label lblSupplierOrder = new Label("Supplier", 500, 8, 159, 45);
		this.add(lblSupplierOrder);

		Label lblOrderProduct = new Label("Product", 20, 91, 86, 23);
		this.add(lblOrderProduct);

		Label lblOrderPackaging = new Label("Packaging", 184, 89, 113, 29);
		this.add(lblOrderPackaging);

		Label lblPackagingQuantity = new Label("Quantity", 304, 95, 50, 23);
		this.add(lblPackagingQuantity);

		Label lblProductUnit = new Label("Unit", 364, 95, 50, 23);
		this.add(lblProductUnit);

		Label lblOrderQuantity = new Label("Quantity Order", 424, 95, 86, 23);
		this.add(lblOrderQuantity);

		Label[] orderLabel = { lblArticleSearch, lblOrderSearch, lblSupplierOrder, lblOrderProduct, lblOrderPackaging,
				lblPackagingQuantity, lblProductUnit, lblOrderQuantity };
		label = orderLabel;

		TextField tfPackagingQuantity = new TextField("Quantity", 304, 118, 50, 20);
		this.add(tfPackagingQuantity);

		TextField tfProductUnit = new TextField("Quantity", 364, 118, 50, 20);
		this.add(tfProductUnit);

		TextField tfQuantity = new TextField("Quantity", 424, 118, 100, 20);
		this.add(tfQuantity);

		TextField[] orderTextField = { tfPackagingQuantity, tfProductUnit, tfQuantity };

		textField = orderTextField;

		ComboBox listOrder = new ComboBox("listOrder", 150, 15, 200, 32);
		this.add(listOrder);

		ComboBox listArticle = new ComboBox("listArticle", 150, 57, 339, 32);
		this.add(listArticle);

		ComboBox listOrderSupplier = new ComboBox("listOrdSuppl", 580, 15, 200, 32);
		this.add(listOrderSupplier);

		ComboBox listOrderProduct = new ComboBox("listOrdProd", 20, 111, 150, 32);
		this.add(listOrderProduct);

		ComboBox listOrderPackaging = new ComboBox("listOrdPack", 184, 111, 100, 32);
		this.add(listOrderPackaging);

		ComboBox listOrderState = new ComboBox("listOrdState", 685, 291, 100, 22);
		listOrderState.setMaximumRowCount(4);
		this.add(listOrderState);

		ComboBox[] orderCombo = { listOrder, listArticle, listOrderSupplier, listOrderProduct, listOrderPackaging,
				listOrderState };
		combo = orderCombo;

		ScrollPane scrollPane_3 = new ScrollPane(20, 163, 650, 178);
		this.add(scrollPane_3);

		scroll = scrollPane_3;

		table_Order = new JTable();

		DefaultTableModel model = new DefaultTableModel(new Object[][] {,},
				new String[] { "id", "Product", "Packaging", "Quantity", "Price" }) {
			@Override
			public boolean isCellEditable(int row, int column) {

				return false;
			}
		};
		table_Order.setModel(model);
		TableColumnModel columnModel = table_Order.getColumnModel();
		table_Order.setBackground(new Color(255, 222, 173));
		scrollPane_3.setViewportView(table_Order);
		columnModel.getColumn(0).setPreferredWidth(50);
		columnModel.getColumn(1).setPreferredWidth(150);
		columnModel.getColumn(2).setPreferredWidth(160);
		columnModel.getColumn(3).setPreferredWidth(60);
		columnModel.getColumn(4).setPreferredWidth(230);
		table = table_Order;

		btnOrderLaunch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					clearTable();
					clearAndEnableFalse();
					listOrderState.setEnabled(true);

					if (!String.valueOf(listOrder.getSelectedItem()).equals("Create New Order")) {

						// get the object order from the database according to the name selected
						// in the search combo box
						Order order = (Order) listOrder.getSelectedItem();
						// put the name of the supplier for this order in the combobox
						listOrderSupplier.removeAllItems();
						listOrderSupplier.addItem((Supplier) order.getSupplier());
						listOrderSupplier.setEnabled(true);
						// put the articles linked to the chosen supplier in the combobox
						listOfArticle(order.getSupplier());

						// set enable true for the article launch button and list
						btnOrderArticleLaunch.setEnabled(true);
						listArticle.setEnabled(true);

						// fill the table
						fillOrderTable(order);
						activOrder = order;
						if (!order.getState().equals("Waiting")) {
							listOrderState.setSelectedItem(order.getState().toString());
						} else {
							listOrderState.setSelectedItem(order.getState().toString());
						}
						btnOrderCreate.setEnabled(false);
						btnOrderModify.setEnabled(true);
						btnOrderAdd.setEnabled(true);
						btnOrderAdd2.setEnabled(true);
						btnOrderMinus.setEnabled(true);
						btnOrderRemove.setEnabled(true);

					} else { // if it is a new order
						emptyTextField();
						listOrderSupplier.setEnabled(true);
						btnOrderModify.setEnabled(false);
						btnOrderCreate.setEnabled(true);
						listOrderState.setSelectedItem("Waiting");

					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		btnOrderArticleLaunch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					if (!String.valueOf(listArticle.getSelectedItem()).equals("Create New Article")) {
						// get the object order from the database according to the name selected
						// in the search combo box
						Article article = (Article) listArticle.getSelectedItem();
						activArticle = article;
						listOrderProduct.getModel().setSelectedItem(activArticle.getProduct());
						listOrderPackaging.getModel().setSelectedItem(activArticle.getPackaging());
						tfPackagingQuantity.setText(formatD(activArticle.getQuantity()));
						tfProductUnit.setText(String.valueOf(activArticle.getProduct().getUnit()));
						editableText(2); // tfQuantity
						listOrderProduct.setEnabled(false);
						listOrderPackaging.setEnabled(false);
						btnOrderAdd.setEnabled(true);
						btnOrderAdd2.setEnabled(true);
						btnOrderMinus.setEnabled(true);
						btnOrderRemove.setEnabled(true);

					} else { // if it is a new order

						emptyTextField();
						editableText();
						listOrderProduct.setEnabled(true);
						listOrderPackaging.setEnabled(true);
						btnOrderAdd.setEnabled(true);
						listOrderProduct.setSelectedIndex(0);
						activProduct = (Product) listOrderProduct.getSelectedItem();
						tfProductUnit.setText(activProduct.getUnit().getName());

					}
//					if (String.valueOf(listArticle.getSelectedItem()).equals("Create New Article")) {
//						listOrderProduct.setSelectedIndex(0);
//					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		listOrderSupplier.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent event) {
				if (listOrderSupplier.isEnabled()) {
					if (!String.valueOf(listOrderSupplier.getSelectedItem()).equals("Select a supplier")) {

						if (event.getStateChange() == ItemEvent.SELECTED) {
							try {
								Object source = event.getSource();
								if (source instanceof JComboBox) {
									if (listOrderSupplier.getSelectedIndex() != -1) {
										// put the articles linked to the chosen supplier in the combobox
										listOfArticle((Supplier) listOrderSupplier.getSelectedItem());
										// change the list of product according to the chosen supplier
										listOrderProduct.removeAllItems();
										activSupplier = (Supplier) listOrderSupplier.getSelectedItem();
										SupplierSell supplierSell;
										supplierSell = querySupplierSell.createSupplierSellInfo(activSupplier);
										ArrayList<Product> productSold = supplierSell.getProducts();
										for (Product product : productSold) {
											listOrderProduct.addItem(product);
										}

										btnOrderArticleLaunch.setEnabled(true);
										listArticle.setEnabled(true);
										// listOrderProduct.setEnabled(true);

									}
								}
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					} else {
						clearAndEnableFalse();
						listOrderSupplier.setEnabled(true);
						clearTable();

					}
				}

			}
		});

		listOrderSupplier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (String.valueOf(listOrderSupplier.getSelectedItem()).equals("Select a supplier")) {
					// listOrderSupplier.setEnabled(true);
				}
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}
		});

		btnOrderAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (isNumeric(tfPackagingQuantity.getText()) && isNumeric(tfQuantity.getText())) {

						activSupplier = (Supplier) listOrderSupplier.getSelectedItem();

						if (String.valueOf(listArticle.getSelectedItem()).equals("Create New Article")) {
							Article article = new Article(Double.parseDouble(tfPackagingQuantity.getText()), 0,
									(Packaging) listOrderPackaging.getSelectedItem(),
									(Product) listOrderProduct.getSelectedItem());
							article.setIdAdmin(Frame.activAdmin.getId());
							article.setId(queryArticle.createPreparedID(article));
							btnOrderAdd2.setEnabled(true);
							btnOrderMinus.setEnabled(true);
							btnOrderRemove.setEnabled(true);
							activArticle = article;

						}
						activArticle.setRealQuant(Integer.parseInt(tfQuantity.getText()));

						activProduct = (Product) listOrderProduct.getSelectedItem();
						String packaging = listOrderPackaging.getSelectedItem() + " de " + tfPackagingQuantity.getText()
								+ " " + activProduct.getUnit();
						int quantity = Integer.parseInt(tfQuantity.getText());

						String totalPrice = calculPrice(activSupplier, activArticle, quantity);

						Object[] row = { activArticle.getId(), activProduct, packaging, formatI(quantity), totalPrice };

						DefaultTableModel model = (DefaultTableModel) table.getModel();

						// check if the article is already in the list
						ArrayList<Product> product = new ArrayList<Product>();
						ArrayList<String> packagingColumn = new ArrayList<String>();
						for (int i = 0; i < model.getRowCount(); i++) {
							product.add((Product) model.getValueAt(i, 1));
							packagingColumn.add((String) model.getValueAt(i, 2));
						}

						// if the article isn't already in the table
						if (product.indexOf(row[0]) == -1 || packagingColumn.indexOf(row[1]) == -1) {
							model.addRow(row);
						} else {
							JOptionPane.showMessageDialog(null, "This article is already in the table");
						}
						// Vector<Object> rowData = model.getDataVector().elementAt(2);

					} else {
						JOptionPane.showMessageDialog(null, "Please put a number in both quantity fields");
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		btnOrderAdd2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (table_Order.getSelectedRow() != -1) {
						int row = table_Order.getSelectedRow();
						int quantity = Integer.parseInt((String) table_Order.getValueAt(row, 3)) + 1;
						table_Order.setValueAt(formatI(quantity), row, 3);
						String totalPrice = calculPrice(activSupplier, activArticle, quantity);
						model.setValueAt(totalPrice, row, 4);
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		btnOrderMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (table_Order.getSelectedRow() != -1) {
						int row = table_Order.getSelectedRow();
						int quantity = Integer.parseInt((String) table_Order.getValueAt(row, 3)) - 1;
						table_Order.setValueAt(formatI(quantity), row, 3);
						String totalPrice = calculPrice(activSupplier, activArticle, quantity);
						model.setValueAt(totalPrice, row, 4);
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		btnOrderRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (table_Order.getSelectedRow() != -1) {
						int row = table_Order.getSelectedRow();
						model.removeRow(row);
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		listOrderState.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent event) {
				if (!listOrder.getSelectedItem().equals("Create New Order")) {
					if (listOrderSupplier.isEnabled()) {

						if (event.getStateChange() == ItemEvent.SELECTED) {
							try {
								Object source = event.getSource();
								if (source instanceof JComboBox) {
									JComboBox cb = (JComboBox) source;
									String selectedItem = String.valueOf(cb.getSelectedItem());
									if (!selectedItem.equals(activOrder.getState())) {
										int answer = JOptionPane.showConfirmDialog(null,
												"Are you sure thant you want to switch to" + selectedItem,"PLEASE CONFIRM",JOptionPane.OK_CANCEL_OPTION);
										if (answer==2) {
											listOrderState.setSelectedItem(activOrder.getState());;
										}
									}
								}
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

					}
				}
			}
		});

//		listOrderState.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				// faire apparaitre un JOPTION Pane ou autre pour confirmer le changement d'état
//				JOptionPane.showConfirmDialog(null, "Are you sure ?");
//			}
//		});

	}

	public static void listOfOrder() throws Exception {

		combo[0].removeAllItems();
		ArrayList<Order> listOrder = new ArrayList<Order>();
		combo[0].addItem("Create New Order");
		for (Order ord : queryOrder.listAllOrder()) {
			listOrder.add(ord);
		}
		for (int i = 0; i < listOrder.size(); i++) {
			// add the list elements to the search combo box
			combo[0].addItem(listOrder.get(i));

		}
	}

	public static void listOfArticle() throws Exception {
		combo[1].removeAllItems();
		ArrayList<Article> listArticle = new ArrayList<Article>();
		combo[1].addItem("Create New Article");
		for (Article art : queryArticle.listAllArticle()) {
			listArticle.add(art);
		}
		for (int i = 0; i < listArticle.size(); i++) {
			// add the list elements to the search combo box
			combo[1].addItem(listArticle.get(i));

		}
	}

	public static void listOfArticle(Supplier supplier) throws Exception {
		combo[1].removeAllItems();
		ArrayList<Article> listArticle = new ArrayList<Article>();
		combo[1].addItem("Create New Article");
		for (Article art : queryArticle.listAllArticle(supplier)) {
			listArticle.add(art);
		}
		for (int i = 0; i < listArticle.size(); i++) {
			// add the list elements to the search combo box
			combo[1].addItem(listArticle.get(i));

		}
	}

	public static void listOfSupplier() throws Exception {
		ArrayList<Supplier> listSuppl = new ArrayList<Supplier>();
		combo[2].removeAllItems();
		combo[2].addItem("Select a supplier");
		for (Supplier sup : querySupplier.listAllSupplier()) {
			listSuppl.add(sup);
		}
		for (int i = 0; i < listSuppl.size(); i++) {
			// add the list elements to the search combo box
			combo[2].addItem(listSuppl.get(i));
		}
	}

	public static void listOfProduct() throws Exception {
		combo[3].removeAllItems();
		ArrayList<Product> listProduct = queryProduct.listAllProduct();
		for (int i = 0; i < listProduct.size(); i++) {
			// add the list elements to the search combo box
			combo[3].addItem(listProduct.get(i));

		}
	}

	public static void listOfPackaging() throws Exception {

		combo[4].removeAllItems();
		ArrayList<Packaging> listPackaging = queryPackaging.listAllPackaging();
		for (int i = 0; i < listPackaging.size(); i++) {
			// add the list elements to the search combo box
			combo[4].addItem(listPackaging.get(i));

		}
	}

	public static void listState() throws Exception {

		combo[5].removeAllItems();
		String[] listState = { "Accepted", "Waiting", "Blocked", "Received" };
		for (int i = 0; i < listState.length; i++) {
			// add the list elements to the search combo box
			combo[5].addItem(listState[i]);
		}
	}

	public static void clearTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (int j = model.getRowCount() - 1; j >= 0; j--) {
			model.removeRow(j);
		}
	}

	public static void clearAndEnableFalse() {

		for (int i = 0; i < textField.length; i++) {
			textField[i].setEditable(false);
			textField[i].setBackground(new Color(216, 206, 209));
			textField[i].setText("");
		}

		for (int i = 1; i < button.length; i++) {
			button[i].setEnabled(false);
		}
		combo[1].setEnabled(false);
		combo[2].setEnabled(false);
		combo[3].setEnabled(false);
		combo[4].setEnabled(false);
		combo[5].setEnabled(false);
	}

	public static void editableText() {
		for (int i = 0; i < textField.length; i++) {
			if (i != 1) {
				textField[i].setEditable(true);
				textField[i].setForeground(Color.BLACK);
				textField[i].setBackground(new Color(255, 222, 173));
			}
		}
	}

	public static void editableText(int i) {
		textField[i].setEditable(true);
		textField[i].setForeground(Color.BLACK);
		textField[i].setBackground(new Color(255, 222, 173));

	}

	public static void emptyTextField() {
		for (int i = 0; i < textField.length; i++) {
			textField[i].setText("");
		}
	}

	/**
	 * This method is used to fill the Table when you select an existing order
	 * 
	 * @param order
	 * @throws Exception
	 */
	public static void fillOrderTable(Order order) throws Exception {
		// get all the orderLines from the database for the chosen order

		Order orderSelected = (Order) combo[0].getSelectedItem();
		Supplier supplier = orderSelected.getSupplier();

		ArrayList<OrderLine> orderLine = queryOrder.listAllOrderLine(orderSelected.getId());
		ArrayList<Article> article = new ArrayList<Article>();
		for (int i = 0; i < orderLine.size(); i++) {
			article.add(queryArticle.createArticleInfo(orderLine.get(i).getIdArticle()));
		}
		clearTable();
		if (orderLine.size() > 0) {
			for (int i = 0; i < orderLine.size(); i++) {
				int quantity = orderLine.get(i).getQuantity();
				String unit = article.get(i).getProduct().getUnit().getName();
				String packaging = article.get(i).getPackaging().getName() + " de " + article.get(i).getQuantity() + " "
						+ unit;

				String totalPrice = calculPrice(supplier, article.get(i), quantity);
				Object[] row = { article.get(i).getId(),article.get(i).getProduct(), packaging, formatI(quantity), totalPrice }; 
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(row);
			}
		}
	}

	public static String calculPrice(Supplier supplier, Article article, int quantity) {

		double buyingPrice = 0;
		try {
			buyingPrice = querySupplierSell.getPrice(article.getProduct().getName(), supplier.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double valueTotalPrice = article.getQuantity() * quantity * buyingPrice;
		String totalPrice = buyingPrice + "€/" + article.getProduct().getUnit() + " x " + article.getQuantity()
				+ article.getProduct().getUnit() + " x " + quantity + " = " + (valueTotalPrice) + "€";

		return totalPrice;
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

	/**
	 * This method is used to format the number (used to not display 2.0 but 2)
	 * 
	 * @param number
	 * @return
	 */
	public static String formatI(int number) {
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.US);
		DecimalFormat df = new DecimalFormat("#.##########", otherSymbols);
		String resultFormat = df.format(number);
		return resultFormat;
	}

	/**
	 * This method is used to format the number (used to not display 2.0 but 2)
	 * 
	 * @param number
	 * @return
	 */
	public static String formatD(double number) {
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.US);
		DecimalFormat df = new DecimalFormat("#.##########", otherSymbols);
		String resultFormat = df.format(number);
		return resultFormat;
	}

//	public static void addArticleToTable(Article article) {
//		String unit = article.getProduct().getUnit().getName();
//		String packaging = article.getPackaging().getName() + " de " + article.getQuantity() + " "
//				+ unit;
//		double buyingPrice = querySupplierSell.getPrice(article.get(i).getProduct().getName(),
//				orderSelected.getSupplier().getName());
//		double quantity = orderLine.get(i).getQuantity();
//		double valueTotalPrice = article.get(i).getQuantity() * quantity * buyingPrice;
//		String totalPrice = buyingPrice + "€/" +article.get(i).getProduct().getUnit() + " x "
//				+ article.get(i).getQuantity() + article.get(i).getProduct().getUnit() + " x " + quantity + " = "
//				+ (valueTotalPrice) + "€";
//		
//		// rajouter un toString à product avec juste le nom
//		Object[] row = { article.get(i).getProduct(), packaging, quantity,totalPrice};
//		DefaultTableModel model = (DefaultTableModel) table.getModel();
//		model.addRow(row);
//	}

}
