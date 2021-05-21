package view;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import entities.Admin;
import model.QuerySupplier;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.Icon;
import javax.swing.JPasswordField;

//Test commit
public class Frame {

	private JFrame frame;
	private final JPanel panel = new JPanel();

	private JTable table;
	private JTable table_1;
	private JTable tSupplier;
	private JTable table_Order;
	private JTable table_3;
	public static ValueNeededSupplier suppl;
	

	public static ValueNeededAdmin adm;
	public static Admin activAdmin;
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

		Label lblNewLabel_2 = new Label("Joe Smith", 10, 194, 790, 72);
		panelHome.add(lblNewLabel_2);

		Label lblNewLabel_1 = new Label("Welcome", 10, 143, 790, 58);
		panelHome.add(lblNewLabel_1);

		lblNewLabel.setIcon(new ImageIcon(newimg));
		panelHome.add(lblNewLabel);
		TabbedPane.setBackgroundAt(0, new Color(213, 167, 113));

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

		Panel panelOrder = new Panel("panelOrder");

		TabbedPane.addTab("Order", new ImageIcon(Frame.class.getResource("/assets/Order.jpg")), panelOrder, null);
		panelOrder.setLayout(null);

		Button btnOrderAddTextfield = new Button("+_Order1", 634, 182, 45, 23);
		panelOrder.add(btnOrderAddTextfield);

		Button btnOrderMinusTextfield = new Button("-_Order", 689, 182, 41, 23);
		panelOrder.add(btnOrderMinusTextfield);

		Button btnOderRemoveTextfield = new Button("x_Order", 736, 182, 41, 23);
		panelOrder.add(btnOderRemoveTextfield);

		Button btnOrderLaunch = new Button("Order_Launch", 568, 47, 86, 23);
		panelOrder.add(btnOrderLaunch);

		Button btnOrderAddTextfield2 = new Button("+_Order2", 414, 116, 50, 23);
		panelOrder.add(btnOrderAddTextfield2);

		Button btnOrderSubmit = new Button("Order_Submit", 330, 371, 113, 32);
		panelOrder.add(btnOrderSubmit);

		Button btnOrderModify = new Button("Order_Modify", 154, 371, 113, 32);
		panelOrder.add(btnOrderModify);

		Button btnOrderCreate = new Button("Order_Create", 496, 371, 113, 32);
		panelOrder.add(btnOrderCreate);

		Label lblOrderSearch = new Label("Search with order number", 31, 36, 178, 45);
		panelOrder.add(lblOrderSearch);

		Label lblSupplierOrder = new Label("Supplier Order", 50, 92, 159, 22);
		panelOrder.add(lblSupplierOrder);

		Label lblOrderProduct = new Label("Product Order", 218, 91, 86, 23);
		panelOrder.add(lblOrderProduct);

		Label lblOrderPackaging = new Label("Packaging Order", 314, 89, 113, 29);
		panelOrder.add(lblOrderPackaging);

		ComboBox listOrderSupplier = new ComboBox("listOrdSuppl", 50, 111, 158, 32);
		panelOrder.add(listOrderSupplier);

		ComboBox listOrder = new ComboBox("listOrder", 219, 42, 339, 32);
		panelOrder.add(listOrder);

		ComboBox listOrderProduct = new ComboBox("listOrdProd", 218, 111, 86, 32);
		panelOrder.add(listOrderProduct);

		ComboBox listOrderPackaging = new ComboBox("listOrdPack", 314, 111, 86, 32);
		panelOrder.add(listOrderPackaging);

		ComboBox listOrderOfState = new ComboBox("listOrdState", 686, 291, 84, 22);
		listOrderOfState.setMaximumRowCount(4);
		panelOrder.add(listOrderOfState);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_3.setBounds(50, 163, 574, 178);
		panelOrder.add(scrollPane_3);

		table_Order = new JTable();
		table_Order.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null }, },
				new String[] { "Product", "Packaging", "Quantity", "Price" }));
		table_Order.setBackground(new Color(255, 222, 173));
		scrollPane_3.setViewportView(table_Order);

		TextField tfOrderNumber = new TextField("orderNumber", 50, 77, 86, 20);
		panelOrder.add(tfOrderNumber);

		TextField tfState = new TextField("state", 685, 326, 86, 20);
		panelOrder.add(tfState);

		/**
		 * Article
		 */

		ArticlePanel panelArticle = new ArticlePanel();

		TabbedPane.addTab("Article", new ImageIcon(Frame.class.getResource("/assets/Article.jpg")), panelArticle, null);
		

		
/*
         * Product
         */

        ProductPanel panelProduct = new ProductPanel();

        TabbedPane.addTab("Product", new ImageIcon(Frame.class.getResource("/assets/Product.jpg")), panelProduct, null);
        
        

        

		/**
		 * History
		 */

		Panel panelHistory = new Panel("panelHistory");

		TabbedPane.addTab("History", new ImageIcon(Frame.class.getResource("/assets/History.jpg")), panelHistory, null);

		Button btnHistorySubmit = new Button("History_Submit", 525, 381, 89, 23);
		panelHistory.add(btnHistorySubmit);

		Button btnHistoryShowCompletedOrders = new Button("Orders placed", 454, 79, 129, 23);
		panelHistory.add(btnHistoryShowCompletedOrders);

		Button btnHistoryShowOrdersInProgress = new Button("Orders in progress", 593, 79, 149, 23);
		panelHistory.add(btnHistoryShowOrdersInProgress);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(58, 141, 684, 178);
		panelHistory.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(255, 222, 173));
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null }, },
				new String[] { "Order", "Delivery date", "Validation date", "State" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(2).setPreferredWidth(106);
		scrollPane.setViewportView(table);

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
