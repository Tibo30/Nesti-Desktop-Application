package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import components.Button;
import components.Label;
import components.Panel;
import entities.Admin;

//Test commit
public class Frame {

	private JFrame frame;
	private final JPanel panel = new JPanel();

	private JTable table;
	private JTable table_1;
	private JTable tSupplier;
	
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
