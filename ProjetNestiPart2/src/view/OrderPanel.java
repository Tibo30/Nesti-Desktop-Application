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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import components.Button;
import components.ComboBox;
import components.Label;
import components.PasswordField;
import components.TextField;
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
import tools.Check;

/**
 * Class for the order panel frame
 * 
 * @author Thibault
 *
 */
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

	/**
	 * Constructor
	 * 
	 * @throws Exception
	 */
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

		Label lblAccepted = new Label("Date", 50, 345, 250, 20);
		this.add(lblAccepted);

		Label lblDelivered = new Label("Date", 400, 345, 250, 20);
		this.add(lblDelivered);

		Label lblTotal = new Label("Total", 650, 345, 150, 22);
		this.add(lblTotal);
		lblTotal.setText("Total :");

		Label[] orderLabel = { lblArticleSearch, lblOrderSearch, lblSupplierOrder, lblOrderProduct, lblOrderPackaging,
				lblPackagingQuantity, lblProductUnit, lblOrderQuantity, lblAccepted, lblDelivered, lblTotal };
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

		/**
		 * Action listener on the button launch (order)
		 */
		btnOrderLaunch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					clearTable();
					clearAndEnableFalse();
					listState();
					listOrderState.setEnabled(true);
					// if it is not a creation
					if (!String.valueOf(listOrder.getSelectedItem()).equals("Create New Order")) {

						// get the object order from the database according to the name selected
						// in the search combo box
						Order order = (Order) listOrder.getSelectedItem();

						SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy 'at' HH:mm:ss");
						if (order.getValidationDate() != null) {
							System.out.println(order.getValidationDate());
							lblAccepted.setText("Validation Date : " + format.format(order.getValidationDate()));
						}
						if (order.getDeliveryDate() != null) {
							lblDelivered.setText("Delivery Date : " + format.format(order.getDeliveryDate()));
						}

						// put the name of the supplier for this order in the combobox
						listOrderSupplier.removeAllItems();
						listOrderSupplier.addItem((Supplier) order.getSupplier());

						// put the articles linked to the chosen supplier in the combobox
						listOfArticle(order.getSupplier());

						lblTotal.setText("Total :");

						// fill the table
						fillOrderTable(order);
						activOrder = order;
						activSupplier = order.getSupplier();
						listOfProductSupplier(activSupplier);

						if (order.getState().equals("Waiting")) {
							btnOrderAdd.setEnabled(true);
							btnOrderAdd2.setEnabled(true);
							btnOrderMinus.setEnabled(true);
							btnOrderRemove.setEnabled(true);
							// set enable true for the article launch button and list
							btnOrderArticleLaunch.setEnabled(true);
							listArticle.setEnabled(true);

						}
						listOrderState.setSelectedItem(order.getState().toString());

						// if the order is already received, nothing can be done
						if (order.getState().equals("Received")) {
							listOrderState.setEnabled(false);
						} else {
							listOrderSupplier.setEnabled(true);
							btnOrderCreate.setEnabled(false);
							btnOrderModify.setEnabled(true);
						}

					} else { // if it is a new order
						emptyTextField();
						listOfSupplier();
						listOrderSupplier.setEnabled(true);
						btnOrderModify.setEnabled(false);
						listOrderState.setSelectedItem("Waiting");
						listOrderState.removeItem("Received");

					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		/**
		 * Action Listener on the button launch (article)
		 */
		btnOrderArticleLaunch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					// if it is not a creation
					if (!String.valueOf(listArticle.getSelectedItem()).equals("Create New Article")) {
						// get the object order from the database according to the name selected
						// in the search combo box
						Article article = (Article) listArticle.getSelectedItem();
						activArticle = article;
						listOrderProduct.getModel().setSelectedItem(activArticle.getProduct());
						listOrderPackaging.getModel().setSelectedItem(activArticle.getPackaging());
						tfPackagingQuantity.setText(formatD(activArticle.getQuantity()));
						System.out.println(activArticle.getQuantity());
						tfPackagingQuantity.setEditable(false);
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
						if (listOrderProduct.getItemCount() > 0) {
							listOrderProduct.setSelectedIndex(0);
							activProduct = (Product) listOrderProduct.getSelectedItem();
							tfProductUnit.setText(activProduct.getUnit().getName());
						}

					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		/**
		 * Action listener on the supplier combobox
		 */
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
										listOfProductSupplier(activSupplier);

										btnOrderArticleLaunch.setEnabled(true);
										listArticle.setEnabled(true);
										// if it's a new order and the user click first on select a supplier then a
										// supplier name we have to enable the create button
										if (String.valueOf(listOrder.getSelectedItem()).equals("Create New Order")) {
											btnOrderCreate.setEnabled(true);
										}

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

		/**
		 * Action listener on the button add (order)
		 */
		btnOrderAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (Check.isNumeric(tfPackagingQuantity.getText()) && Check.isNumeric(tfQuantity.getText())) {

						activSupplier = (Supplier) listOrderSupplier.getSelectedItem();

						if (String.valueOf(listArticle.getSelectedItem()).equals("Create New Article")) {
							Article article = new Article(Double.parseDouble(tfPackagingQuantity.getText()), 0,
									(Packaging) listOrderPackaging.getSelectedItem(),
									(Product) listOrderProduct.getSelectedItem());
							// if the created article is not already in the database
							if (queryArticle.checkArticle(article.getProduct().getName(),
									article.getPackaging().getName(), article.getQuantity()) == null) {
								article.setIdAdmin(Frame.activAdmin.getId());
								article.setId(queryArticle.createPreparedID(article));
								btnOrderAdd2.setEnabled(true);
								btnOrderMinus.setEnabled(true);
								btnOrderRemove.setEnabled(true);
								activArticle = article;
							} else {
								activArticle = queryArticle.checkArticle(article.getProduct().getName(),
										article.getPackaging().getName(), article.getQuantity());
							}

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

						// if the article isn't already in the table (different name of product or
						// packaging)
						if (product.indexOf(row[1]) == -1 || packagingColumn.indexOf(row[2]) == -1) {
							model.addRow(row);
							listOrderProduct.setEnabled(false);
							listOrderPackaging.setEnabled(false);
							tfPackagingQuantity.setEditable(false);
							tfProductUnit.setEditable(false);
							tfQuantity.setEditable(false);
							
							double TotalTotalPrice = 0;
							
							for (int i = 0; i < model.getRowCount(); i++) {
								Article article = queryArticle.createArticleInfo((int) model.getValueAt(i, 0));
								TotalTotalPrice += calculTotalPrice(activSupplier,article, Integer.parseInt((String) model.getValueAt(i, 3)));
								System.out.println(TotalTotalPrice);
								System.out.println(model.getValueAt(i, 3));
							}
							label[10].setText("Total : " + TotalTotalPrice + " €");

						} else {
							JOptionPane.showMessageDialog(null, "This article is already in the table");
						}

					} else {
						JOptionPane.showMessageDialog(null, "Please put a number in both quantity fields");
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		/**
		 * Action listener on the list of product
		 */
		listOrderProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (listOrderProduct.getSelectedIndex() != -1) {
						tfProductUnit.setText(((Product) listOrderProduct.getSelectedItem()).getUnit().getName());
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		/**
		 * Action listener on the button add (quantity)
		 */
		btnOrderAdd2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (table_Order.getSelectedRow() != -1) {
						int row = table_Order.getSelectedRow();
						int quantity = Integer.parseInt((String) table_Order.getValueAt(row, 3)) + 1;
						activArticle = queryArticle.createArticleInfo((int) table_Order.getValueAt(row, 0));
						table_Order.setValueAt(formatI(quantity), row, 3);
						String totalPrice = calculPrice(activSupplier, activArticle, quantity);
						model.setValueAt(totalPrice, row, 4);
						
						double TotalTotalPrice = 0;
						for (int i = 0; i < model.getRowCount(); i++) {
							Article article = queryArticle.createArticleInfo((int) model.getValueAt(i, 0));
							TotalTotalPrice += calculTotalPrice(activSupplier,article, Integer.parseInt((String) model.getValueAt(i, 3)));
							System.out.println(TotalTotalPrice);
							System.out.println(model.getValueAt(i, 3));
						}
						label[10].setText("Total : " + TotalTotalPrice + " €");
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		/**
		 * Action listener on the button minus (quantity)
		 */
		btnOrderMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (table_Order.getSelectedRow() != -1) {
						int row = table_Order.getSelectedRow();
						int quantity = Integer.parseInt((String) table_Order.getValueAt(row, 3)) - 1;
						activArticle = queryArticle.createArticleInfo((int) table_Order.getValueAt(row, 0));
						table_Order.setValueAt(formatI(quantity), row, 3);
						String totalPrice = calculPrice(activSupplier, activArticle, quantity);
						model.setValueAt(totalPrice, row, 4);
						
						double TotalTotalPrice = 0;
						for (int i = 0; i < model.getRowCount(); i++) {
							Article article = queryArticle.createArticleInfo((int) model.getValueAt(i, 0));
							TotalTotalPrice += calculTotalPrice(activSupplier,article, Integer.parseInt((String) model.getValueAt(i, 3)));
							System.out.println(TotalTotalPrice);
							System.out.println(model.getValueAt(i, 3));
						}
						label[10].setText("Total : " + TotalTotalPrice + " €");
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		/**
		 * Action listener on the button remove
		 */
		btnOrderRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (table_Order.getSelectedRow() != -1) {
						int row = table_Order.getSelectedRow();
						model.removeRow(row);
						
						double TotalTotalPrice = 0;
						for (int i = 0; i < model.getRowCount(); i++) {
							Article article = queryArticle.createArticleInfo((int) model.getValueAt(i, 0));
							TotalTotalPrice += calculTotalPrice(activSupplier,article, Integer.parseInt((String) model.getValueAt(i, 3)));
							System.out.println(TotalTotalPrice);
							System.out.println(model.getValueAt(i, 3));
						}
						label[10].setText("Total : " + TotalTotalPrice + " €");
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		/**
		 * Action listener on the state combobox
		 */
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
												"Are you sure thant you want to switch to" + selectedItem,
												"PLEASE CONFIRM", JOptionPane.OK_CANCEL_OPTION);
										if (answer == 2) {
											listOrderState.setSelectedItem(activOrder.getState());
											;
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

		/**
		 * Action listener on the button modify
		 */
		btnOrderModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					// if the state changed
					if (!listOrderState.getSelectedItem().equals((String) activOrder.getState())) {
						queryOrder.updatePreparedOrder("state", (String) listOrderState.getSelectedItem(),
								activOrder.getId());
						JOptionPane.showMessageDialog(null, "The state of the order has been changed");
						// if "accepted" we change the validation date
						if (listOrderState.getSelectedItem().equals("Accepted")) {
							System.out.println("ici");
							queryOrder.updatePreparedOrder("validation", "CURRENT_TIMESTAMP", activOrder.getId());
						} // if "received" we change the delivery date
						else if (listOrderState.getSelectedItem().equals("Received")) {
							queryOrder.updatePreparedOrder("delivery", "CURRENT_TIMESTAMP", activOrder.getId());
						} // if "blocked" we set NULL both dates
						else if (listOrderState.getSelectedItem().equals("Blocked")) {
							queryOrder.updatePreparedOrder("blocked", "NULL", activOrder.getId());
						} // if the user chose to get back to waiting, we set NULL both dates
						else if (listOrderState.getSelectedItem().equals("Waiting")) {
							queryOrder.updatePreparedOrder("waiting", "NULL", activOrder.getId());
						}
					}

					if (listOrderState.getSelectedItem().equals("Waiting")) {
						modifyFromTable();
						JOptionPane.showMessageDialog(null, "The order has been update");
					}

					if (listOrderState.getSelectedItem().equals("Received")) {
						for (int i = 0; i < model.getRowCount(); i++) {
							int idArticle = (int) model.getValueAt(i, 0);
							int quantity = Integer.parseInt((String) model.getValueAt(i, 3));
							queryArticle.updatePrepared("quantityStock", String.valueOf(quantity), idArticle);
							System.out.println("ID : " + idArticle + "/ quantity : " + quantity);
						}
						JOptionPane.showMessageDialog(null,
								"The order is received, quantities has been added to the articles");
					}

					clearAndEnableFalse();
					clearTable();
					listOfOrder();
					listOfArticle();

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		/**
		 * Action listener on the button create
		 */
		btnOrderCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Order order = new Order((String) listOrderState.getSelectedItem(), activSupplier,
							Frame.activAdmin.getId());
					int idOrder = queryOrder.createPreparedOrderId(order);
					for (int i = 0; i < model.getRowCount(); i++) {
						int idArticle = (int) model.getValueAt(i, 0);
						int quantity = Integer.parseInt((String) model.getValueAt(i, 3));
						OrderLine orderline = new OrderLine(idArticle, idOrder, quantity);
						queryOrder.createPreparedOrderLine(orderline);
					}
					JOptionPane.showMessageDialog(null, "The order has been added");
					clearAndEnableFalse();
					clearTable();
					listOfOrder();
					listOfArticle();

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

	}

	/**
	 * This method is used to modify the order in the database according to the
	 * table
	 * 
	 * @throws Exception
	 */
	public void modifyFromTable() throws Exception {

		ArrayList<Article> newListArticle = new ArrayList<Article>();
		ArrayList<Article> listArticleDatabase = new ArrayList<Article>();
		ArrayList<OrderLine> newListOrderLine = new ArrayList<OrderLine>();
		ArrayList<Integer> newListOrderLineIdArticle = new ArrayList<Integer>();
		ArrayList<OrderLine> listOrderLineDatabase = new ArrayList<OrderLine>();
		ArrayList<Integer> listOrderLineIdArticleDatabase = new ArrayList<Integer>();
		ArrayList<Integer> listOrderLineQuantityDatabase = new ArrayList<Integer>();

		// in this loop, we collect the list of orderlines from the table
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (int i = 0; i < model.getRowCount(); i++) {
			// add orderlines from table
			int iDArticle = (int) model.getValueAt(i, 0);
			int quantity = Integer.parseInt((String) model.getValueAt(i, 3));
			OrderLine orderLine = new OrderLine(iDArticle, activOrder.getId(), quantity);
			newListOrderLine.add(orderLine);
			newListOrderLineIdArticle.add(orderLine.getIdArticle());
		}
		// create the list of the orderlines from the database for this order
		listOrderLineDatabase = queryOrder.listAllOrderLine(activOrder.getId());
		for (int i = 0; i < listOrderLineDatabase.size(); i++) {
			listOrderLineIdArticleDatabase.add(listOrderLineDatabase.get(i).getIdArticle());
			listOrderLineQuantityDatabase.add(listOrderLineDatabase.get(i).getQuantity());
		}
		// we look over the list of orderlines from the table
		for (int i = 0; i < newListOrderLine.size(); i++) {
			// if an orderline from the table is not already in the database, we add it
			if (listOrderLineIdArticleDatabase.indexOf(newListOrderLine.get(i).getIdArticle()) == -1) {
				OrderLine newOrderLine = new OrderLine(newListOrderLine.get(i).getIdArticle(), activOrder.getId(),
						newListOrderLine.get(i).getQuantity());
				queryOrder.createPreparedOrderLine(newOrderLine);
			} else {
				// if an orderline from the table is already in the database but the quantity is
				// different
				int index = listOrderLineIdArticleDatabase.indexOf(newListOrderLine.get(i).getIdArticle());
				if (!String.valueOf(newListOrderLine.get(i).getQuantity())
						.equals(String.valueOf(listOrderLineQuantityDatabase.get(index)))) {
					queryOrder.updatePreparedQuantityOrderLine(newListOrderLine.get(i).getQuantity(),
							activOrder.getId(), listOrderLineIdArticleDatabase.get(index));
				}
			}
		}
		// if an orderline is in the database but not in the table (delete), we delete
		// it
		// in the database
		for (int i = 0; i < listOrderLineIdArticleDatabase.size(); i++) {
			if (newListOrderLineIdArticle.indexOf(listOrderLineIdArticleDatabase.get(i)) == -1) {
				queryOrder.deletePreparedOrderLine(activOrder.getId(), listOrderLineIdArticleDatabase.get(i));
			}
		}

	}

	/**
	 * This method is used to fill the list of order in the combobox
	 * 
	 * @throws Exception
	 */
	public static void listOfOrder() throws Exception {

		combo[0].removeAllItems();
		ArrayList<Order> listOrder = new ArrayList<Order>();
		combo[0].addItem("Create New Order");
		for (Order ord : queryOrder.listAllOrder()) {
			listOrder.add(ord);
		}
		for (int i = 0; i < listOrder.size(); i++) {
			// add the list of order to the combo box
			combo[0].addItem(listOrder.get(i));

		}
	}

	/**
	 * This method is used to fill the list of article in the combobox from the
	 * database
	 * 
	 * @throws Exception
	 */
	public static void listOfArticle() throws Exception {
		combo[1].removeAllItems();
		ArrayList<Article> listArticle = new ArrayList<Article>();
		combo[1].addItem("Create New Article");
		for (Article art : queryArticle.listAllArticle()) {
			listArticle.add(art);
		}
		for (int i = 0; i < listArticle.size(); i++) {
			if (!listArticle.get(i).getState().equals("Blocked")
					&& !listArticle.get(i).getProduct().getState().equals("Blocked")) {
				// add the list of article to the combo box
				combo[1].addItem(listArticle.get(i));
			}
		}
	}

	/**
	 * This method is used to fill the list of article in the combobox according to
	 * the supplier
	 * 
	 * @param Supplier supplier
	 * @throws Exception
	 */
	public static void listOfArticle(Supplier supplier) throws Exception {
		combo[1].removeAllItems();
		ArrayList<Article> listArticle = new ArrayList<Article>();
		combo[1].addItem("Create New Article");
		for (Article art : queryArticle.listAllArticle(supplier)) {
			listArticle.add(art);
		}
		for (int i = 0; i < listArticle.size(); i++) {
			if (!listArticle.get(i).getState().equals("Blocked")
					&& !listArticle.get(i).getProduct().getState().equals("Blocked")) {
				// add the list of article to the combo box
				combo[1].addItem(listArticle.get(i));
			}
		}
	}

	/**
	 * This method is used to fill the list of supplier
	 * 
	 * @throws Exception
	 */
	public static void listOfSupplier() throws Exception {
		ArrayList<Supplier> listSuppl = new ArrayList<Supplier>();
		combo[2].removeAllItems();
		combo[2].addItem("Select a supplier");
		for (Supplier sup : querySupplier.listAllSupplier()) {
			listSuppl.add(sup);
		}
		for (int i = 0; i < listSuppl.size(); i++) {
			if (!listSuppl.get(i).getState().equals("Blocked")) {
				// add the list of supplier to the combo box
				combo[2].addItem(listSuppl.get(i));
			}
		}
	}

	/**
	 * This method is used to fill the list of product
	 * 
	 * @throws Exception
	 */
	public static void listOfProduct() throws Exception {
		combo[3].removeAllItems();
		ArrayList<Product> listProduct = queryProduct.listAllProduct();
		for (int i = 0; i < listProduct.size(); i++) {
			if (!listProduct.get(i).getState().equals("Blocked")) {
				// add the list of products to the combo box
				combo[3].addItem(listProduct.get(i));
			}
		}
	}

	
	/**
	 * This method is used to fill the list of product
	 * @param supplier
	 * @throws Exception
	 */
	public static void listOfProductSupplier(Supplier supplier) throws Exception {
		SupplierSell supplierSell;
		supplierSell = querySupplierSell.createSupplierSellInfo(activSupplier);
		ArrayList<Product> productSold = supplierSell.getProducts();
		for (Product product : productSold) {
			if (!product.getState().equals("Blocked")) {
				System.out.println(product.getState());
				combo[3].addItem(product);
			}
		}
	}

	/**
	 * This method is used to fill the list of packaging
	 * 
	 * @throws Exception
	 */
	public static void listOfPackaging() throws Exception {

		combo[4].removeAllItems();
		ArrayList<Packaging> listPackaging = queryPackaging.listAllPackaging();
		for (int i = 0; i < listPackaging.size(); i++) {
			// add the list of packaging to the combo box
			combo[4].addItem(listPackaging.get(i));

		}
	}

	/**
	 * This method is used to fill the list of state
	 * 
	 * @throws Exception
	 */
	public static void listState() throws Exception {

		combo[5].removeAllItems();
		String[] listState = { "Accepted", "Waiting", "Blocked", "Received" };
		for (int i = 0; i < listState.length; i++) {
			// add the list of states to the combo box
			combo[5].addItem(listState[i]);
		}
	}

	/**
	 * This method is used to clear the table
	 */
	public static void clearTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (int j = model.getRowCount() - 1; j >= 0; j--) {
			model.removeRow(j);
		}
	}

	/**
	 * This method is used to clear the textfields and enable the button
	 */
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

		label[8].setText("");
		label[9].setText("");

	}

	/**
	 * This method is used to make the textfields editable
	 */
	public static void editableText() {
		for (int i = 0; i < textField.length; i++) {
			if (i != 1) {
				textField[i].setEditable(true);
				textField[i].setForeground(Color.BLACK);
				textField[i].setBackground(new Color(255, 222, 173));
			}
		}
	}

	/**
	 * This method is used to make a textfield editable
	 * 
	 * @param i
	 */
	public static void editableText(int i) {
		textField[i].setEditable(true);
		textField[i].setForeground(Color.BLACK);
		textField[i].setBackground(new Color(255, 222, 173));

	}

	/**
	 * This method is used to empty the textfields
	 */
	public static void emptyTextField() {
		for (int i = 0; i < textField.length; i++) {
			textField[i].setText("");
		}
	}

	/**
	 * This method is used to fill the Table when you select an existing order
	 * 
	 * @param Order order
	 * @throws Exception
	 */
	public static void fillOrderTable(Order order) throws Exception {
		// get all the orderLines from the database for the chosen order

		Supplier supplier = order.getSupplier();

		ArrayList<OrderLine> orderLine = queryOrder.listAllOrderLine(order.getId());
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
				Object[] row = { article.get(i).getId(), article.get(i).getProduct(), packaging, formatI(quantity),
						totalPrice };
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(row);
				
			}
			label[10].setText("Total : " + queryOrder.getTotalOrder(order) + " €");
		}
	}

	/**
	 * This method is used to calcul the price
	 * 
	 * @param Supplier supplier
	 * @param Article  article
	 * @param int      quantity
	 * @return String
	 */
	public static String calculPrice(Supplier supplier, Article article, int quantity) {

		double buyingPrice = 0;
		try {
			buyingPrice = querySupplierSell.getPrice(article.getProduct().getName(), supplier.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double valueTotalPrice = Math.round((article.getQuantity() * quantity * buyingPrice) * 100.0) / 100.0;
		String totalPrice = buyingPrice + "€/" + article.getProduct().getUnit() + " x " + article.getQuantity()
				+ article.getProduct().getUnit() + " x " + quantity + " = " + (valueTotalPrice) + "€";

		return totalPrice;
	}
	
	/**
	 * This method is used to calcul the price
	 * @param supplier
	 * @param article
	 * @param quantity
	 * @return
	 */
	public static double calculTotalPrice(Supplier supplier, Article article, int quantity) {

		double TotalTotalPrice = 0;

		try {
			TotalTotalPrice = Math.round((article.getQuantity() * quantity * querySupplierSell
					.getPrice(article.getProduct().getName(), supplier.getName())) * 100.0)
					/ 100.0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return TotalTotalPrice;
	}
	

	/**
	 * This method is used to format the number (used to not display 2.0 but 2)
	 * 
	 * @param int number
	 * @return String
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
	 * @param double number
	 * @return String
	 */
	public static String formatD(double number) {
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.US);
		DecimalFormat df = new DecimalFormat("#.##########", otherSymbols);
		String resultFormat = df.format(number);
		return resultFormat;
	}

}
