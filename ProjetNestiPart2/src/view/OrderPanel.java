package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
	public static TextField textField;
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

	public OrderPanel() throws Exception {
		this.setBackground(new Color(213, 167, 113));
		this.setLayout(null);
		this.queryArticle = new QueryArticle();
		this.querySupplier = new QuerySupplier();
		this.queryProduct=new QueryProduct();
		this.queryPackaging=new QueryPackaging();
		this.queryOrder=new QueryOrder();
		this.querySupplierSell=new QuerySupplierSell();
		
		Button btnOrderLaunch = new Button("Order_Launch", 360, 20, 86, 23);
		this.add(btnOrderLaunch);
		
		Button btnOrderArticleLaunch = new Button("OrderArticle_Launch", 500, 62, 86, 23);
		this.add(btnOrderArticleLaunch);
		
		Button btnOrderAdd = new Button("+_Order2", 634, 116, 50, 23);
		this.add(btnOrderAdd);
		
		Button btnOrderAdd2 = new Button("+_Order1", 634, 182, 45, 23);
		this.add(btnOrderAdd2);

		Button btnOrderMinus = new Button("-_Order", 685, 182, 41, 23);
		this.add(btnOrderMinus);

		Button btnOderRemove = new Button("x_Order", 736, 182, 41, 23);
		this.add(btnOderRemove);

		Button btnOrderModify = new Button("Order_Modify", 154, 371, 113, 32);
		this.add(btnOrderModify);

		Button btnOrderCreate = new Button("Order_Create", 496, 371, 113, 32);
		this.add(btnOrderCreate);

		Button[] orderButtons = {btnOrderLaunch,btnOrderArticleLaunch,btnOrderAdd,btnOrderAdd2,btnOrderMinus,btnOderRemove,btnOrderModify,btnOrderCreate};
		button=orderButtons;
		
		Label lblOrderSearch = new Label("Search Order", 31, 8, 178, 45);
		this.add(lblOrderSearch);
		
		Label lblArticleSearch = new Label("Search Article", 31, 50, 178, 45);
		this.add(lblArticleSearch);
		

		Label lblSupplierOrder = new Label("Supplier", 50, 92, 159, 22);
		this.add(lblSupplierOrder);

		Label lblOrderProduct = new Label("Product", 218, 91, 86, 23);
		this.add(lblOrderProduct);

		Label lblOrderPackaging = new Label("Packaging", 314, 89, 113, 29);
		this.add(lblOrderPackaging);
		
		Label lblOrderQuantity = new Label ("Quantity",500,95,86,23);
		this.add(lblOrderQuantity);
		
		Label[] orderLabel = {lblArticleSearch,lblOrderSearch,lblSupplierOrder,lblOrderProduct,lblOrderPackaging,lblOrderQuantity};
		label=orderLabel;

		TextField tfQuantity = new TextField ("Quantity",500,115,100,20);
		this.add(tfQuantity);
		
		textField=tfQuantity;

		ComboBox listOrder = new ComboBox("listOrder", 150, 15, 200, 32);
		this.add(listOrder);
		
		ComboBox listArticle = new ComboBox("listArticle", 150, 57, 339, 32);
		this.add(listArticle);	
		
		ComboBox listOrderSupplier = new ComboBox("listOrdSuppl", 50, 111, 158, 32);
		this.add(listOrderSupplier);

		ComboBox listOrderProduct = new ComboBox("listOrdProd", 218, 111, 86, 32);
		this.add(listOrderProduct);
		
		ComboBox listOrderPackaging = new ComboBox("listOrdPack", 314, 111, 158, 32);
		this.add(listOrderPackaging);

		ComboBox listOrderState = new ComboBox("listOrdState", 665, 291, 100, 22);
		listOrderState.setMaximumRowCount(4);
		this.add(listOrderState);
		
		ComboBox[] orderCombo = {listOrder,listArticle,listOrderSupplier,listOrderProduct,listOrderPackaging,listOrderState};
		combo=orderCombo;
		
		ScrollPane scrollPane_3 = new ScrollPane(50, 163, 574, 178);
		this.add(scrollPane_3);
		
		scroll=scrollPane_3;

		table_Order = new JTable();
		
		DefaultTableModel model = new DefaultTableModel(new Object[][] {,},
				new String[] { "Product", "Packaging", "Quantity", "Price" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				boolean editable = true;
				if (column < 2) {
					editable = false;
				}
				return editable;
			}
		};
		table_Order.setModel(model);
		table_Order.setBackground(new Color(255, 222, 173));
		scrollPane_3.setViewportView(table_Order);
		table=table_Order;
		
		
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
						// fill the table
						fillOrderTable(order);
						activOrder=order;
						if (!order.getState().equals("Waiting")) {
							
						} else {
							btnOrderArticleLaunch.setEnabled(true);
							listArticle.setEnabled(true);
							listOrderState.setSelectedItem(order.getState());
						}
						btnOrderCreate.setEnabled(false);
						btnOrderModify.setEnabled(true);
						
						
					} else { // if it is a new supplier

						emptyTextField();
						btnOrderModify.setEnabled(false);
						btnOrderCreate.setEnabled(true);
					}

					btnOrderAdd.setEnabled(true);
					btnOrderAdd2.setEnabled(true);
					btnOrderMinus.setEnabled(true);
					btnOderRemove.setEnabled(true);
					
					

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
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
		
		ArrayList<Article> listArticle = queryArticle.listAllArticle();
		for (int i = 0; i < listArticle.size(); i++) {
			// add the list elements to the search combo box
			combo[1].addItem(listArticle.get(i));

		}
	}
	
	public static void listOfSupplier() throws Exception {
		ArrayList<Supplier> listSuppl = new ArrayList<Supplier>();
		combo[2].removeAllItems();
		for (Supplier sup : querySupplier.listAllSupplier()) {
			listSuppl.add(sup);
		}
		for (int i = 0; i < listSuppl.size(); i++) {
			// add the list elements to the search combo box
			combo[2].addItem(listSuppl.get(i).getName());
		}
	}
	
	public static void listOfProduct() throws Exception {
		combo[3].removeAllItems();
		ArrayList<Product> listProduct = queryProduct.listAllProduct();
		for (int i = 0; i < listProduct.size(); i++) {
			// add the list elements to the search combo box
			combo[3].addItem(listProduct.get(i).getName());

		}
	}
	
	public static void listOfPackaging() throws Exception {

		combo[4].removeAllItems();
		ArrayList<Packaging> listPackaging = queryPackaging.listAllPackaging();
		for (int i = 0; i < listPackaging.size(); i++) {
			// add the list elements to the search combo box
			combo[4].addItem(listPackaging.get(i).getName());

		}
	}
	
	public static void listState() throws Exception {

		combo[5].removeAllItems();
		String[] listState = {"Accepted", "Waiting", "Blocked", "Received"};
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
			textField.setEditable(false);
			textField.setBackground(new Color(216, 206, 209));
			textField.setText("");
	
		for (int i = 1; i < button.length; i++) {
			button[i].setEnabled(false);
		}
		combo[1].setEnabled(false);
		combo[2].setEnabled(false);
		combo[3].setEnabled(false);
		combo[4].setEnabled(false);
		combo[5].setEnabled(false);
	}
	

	public static void emptyTextField() {
			textField.setText("");
	}
	
	/**
	 * This method is used to fill the Table when you select an existing order
	 * @param order
	 * @throws Exception
	 */
	public static void fillOrderTable(Order order) throws Exception {
		//get all the orderLines from the database for the chosen order
		
		Order orderSelected = (Order) combo[0].getSelectedItem();
		SupplierSell suppSell = querySupplierSell.createSupplierSellInfo(orderSelected.getSupplier());
		
		ArrayList<OrderLine> orderLine = queryOrder.listAllOrderLine(orderSelected.getId());
		ArrayList<Article> article = new ArrayList<Article>();
		for (int i=0;i<orderLine.size();i++) {
			article.add(queryArticle.createArticleInfo(orderLine.get(i).getIdArticle()));
		}
		clearTable();
		if (orderLine.size() > 0) {
			for (int i = 0; i < orderLine.size(); i++) {
				String unit = article.get(i).getProduct().getUnit().getName();
				String packaging = article.get(i).getPackaging().getName() + " de " +article.get(i).getQuantity() + " "+unit;
				double price = querySupplierSell.getPrice(article.get(i).getProduct().getName(), orderSelected.getSupplier().getName());
				double quantity = orderLine.get(i).getQuantity();
				// rajouter un toString à product avec juste le nom
				Object[] row = { article.get(i).getProduct().getName(), packaging,quantity, price + "€/"+ unit+ " x " + quantity + " = " + (quantity*price) +"€"};
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(row);
			}
		}
	
	}
	
}

