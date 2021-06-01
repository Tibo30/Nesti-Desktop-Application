package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

import components.Label;
import components.Panel;
import entities.OrderLine;
import entities.Product;
import entities.Admin;
import entities.Article;
import model.QueryOrder;

//Test commit
public class Frame {

	private JFrame frame;
	private final JPanel panel = new JPanel();
	private JTable table;
	public static ValueNeededSupplier suppl;

	public static ValueNeededAdmin adm;
	public static Admin activAdmin;
	public static Order activOrder;
	private JTable tableHistory;
	public static ScrollPane scroll;

	private static QueryOrder queryOrder;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame window = new Frame();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws Exception
	 */
	public Frame() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Exception
	 */
	private void initialize() throws Exception {
		frame = new JFrame();
		frame.setBounds(100, 100, 854, 526);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setBackground(new Color(66, 5, 5));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JTabbedPane TabbedPane = new JTabbedPane(JTabbedPane.TOP);
		TabbedPane.setFont(new Font("Tahoma", Font.BOLD, 13));
		TabbedPane.setBackground(new Color(213, 167, 113));
		TabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		TabbedPane.setBounds(10, 11, 815, 458);

		panel.add(TabbedPane);

		/**
		 * Home
		 */

		Panel panelHome = new Panel("panelHome");
		TabbedPane.addTab("Home", new ImageIcon(Frame.class.getResource("/assets/home.jpg")), panelHome, null);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(-2, 5, 815, 420);
		Image img = new ImageIcon(Frame.class.getResource("/assets/NESTi2.jpg")).getImage();
		Image newimg = img.getScaledInstance(815, 420, java.awt.Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(newimg));

		Label lblNewLabel_2 = new Label(activAdmin.getFirstname() + " " + activAdmin.getLastname(), 10, 194, 790, 72);
		lblNewLabel_2.setForeground(new Color(255, 250, 250));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 40));
		panelHome.add(lblNewLabel_2);

		Label lblNewLabel_1 = new Label("Welcome", 10, 143, 790, 58);
		panelHome.add(lblNewLabel_1);

		lblNewLabel.setIcon(new ImageIcon(newimg));
		panelHome.add(lblNewLabel);

		JLabel lblLogo = new JLabel("");
		lblLogo.setLabelFor(lblLogo);
		lblLogo.setIcon(new ImageIcon(Frame.class.getResource("/assets/logo.jpg")));
		lblLogo.setBounds(758, 0, 70, 32);
		panel.add(lblLogo);

		/**
		 * Profil
		 */
		ProfilePanel panelProfil = new ProfilePanel();

		TabbedPane.addTab("Profil", new ImageIcon(Frame.class.getResource("/assets/Profil.jpg")), panelProfil, null);

		/**
		 * Supplier
		 */

		SupplierPanel panelSupplier = new SupplierPanel();

		TabbedPane.addTab("Supplier", new ImageIcon(Frame.class.getResource("/assets/Supplier.jpg")), panelSupplier,
				null);

		/**
		 * Order
		 */

		OrderPanel panelOrder = new OrderPanel();

		TabbedPane.addTab("Order", new ImageIcon(Frame.class.getResource("/assets/Order.jpg")), panelOrder, null);

		/**
		 * Article
		 */

		ArticlePanel panelArticle = new ArticlePanel();

		TabbedPane.addTab("Article", new ImageIcon(Frame.class.getResource("/assets/Article.jpg")), panelArticle, null);

		/**
		 * Product
		 */

		ProductPanel panelProduct = new ProductPanel();

		TabbedPane.addTab("Product", new ImageIcon(Frame.class.getResource("/assets/Product.jpg")), panelProduct, null);

		/**
		 * History
		 */

		Panel panelHistory = new Panel("panelHistory");

		TabbedPane.addTab("History", new ImageIcon(Frame.class.getResource("/assets/History.jpg")), panelHistory, null);

		/*
		 * ScrollPane scrollPane_4 = new ScrollPane(289, 55, 444, 271);
		 * scrollPane_4.setEnabled(false); scrollPane_4.add(scrollPane_4);
		 */

		tableHistory = new JTable();
		tableHistory.setBounds(130, 136, 535, 196);
		tableHistory.setBackground(new Color(255, 222, 173));
		panelHistory.add(tableHistory);

		/**
		 * History Table Constructor
		 */

		DefaultTableModel model3 = new DefaultTableModel(new Object[][] {,},
				new String[] { "Order", "Delivery date", "Validation date", "State" });
		tableHistory.setModel(model3);
		tableHistory.setModel(model3);
		// scrollPane_4.setViewportView(tableHistory);

		// Buttons
		JButton btnOrdersTreated = new JButton("Orders Treated");
		btnOrdersTreated.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// create the History of the orderlines from the database
				//Order orderHist = new Order();
					//int idOrder= 
					//	Date validationDate=
					//	Date deliveryDate=
					//	String state=
				int[] col= tableHistory.getSelectedColumns();
				QueryOrder queryOrder = new QueryOrder();
				
				Order orderHist = new Order(int idOrder,activOrder.getId(),);
				ArrayList<Order> listOrderHistDatabase = queryOrder.listOrderHistory(0, null, null, null);
			
				DefaultTableModel model = (DefaultTableModel) tableHistory.getModel();
				for (int i = 0; i < listOrderHistDatabase.size(); i++) {

					// listOrderLineIdArticleDatabase.add(listOrderLineDatabase.get(i).getIdArticle());
					// listOrderLineQuantityDatabase.add(listOrderLineDatabase.get(i).getQuantity());

					Object[] row = { listOrderHistDatabase.get(i), listOrderHistDatabase.get(i),
							listOrderHistDatabase.get(i), listOrderHistDatabase.get(i) };

					model.addRow(row);



					/*
					 * for (int i = 0; i < listOrderHistDatabase.size(); i++) {
					 * listOrderHistDatabase.add(listOrderHistDatabase.get(i).getIdOrder());
					 * listOrderHistDatabase.add(listOrderHistDatabase.get(i).getDeliveryDate());
					 * 
					 * ; }
					 */

				}
			}
		});

		btnOrdersTreated.setBackground(new Color(135, 206, 235));

		btnOrdersTreated.setBounds(385, 76, 127, 27);
		panelHistory.add(btnOrdersTreated);

		JButton btnOrdersProcessed = new JButton("Orders Processed");
		btnOrdersProcessed.setBackground(new Color(135, 206, 235));

		btnOrdersProcessed.setBounds(522, 76, 143, 27);
		panelHistory.add(btnOrdersProcessed);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(new Color(144, 238, 144));

		btnSubmit.setBounds(543, 359, 85, 21);
		panelHistory.add(btnSubmit);

		/**
		 * Manage
		 */

		ManagePanel panelManage = new ManagePanel();

		TabbedPane.addTab("Manage", new ImageIcon(Frame.class.getResource("/assets/Manage.jpg")), panelManage, null);

		// add a changeListener to the tabbedPane
		TabbedPane.addChangeListener(new TabbedPaneChangeListener());

	}

	public void show() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame window = new Frame();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
