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
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import components.Label;
import components.Panel;
import entities.Order;
import entities.Admin;
import model.QueryOrder;

//Test commit
public class Frame {

	/**
	 * Attributes
	 */
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
		
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(58, 141, 684, 178);
        panelHistory.add(scrollPane);
		
		

		tableHistory = new JTable();
		tableHistory.setBounds(130, 136, 535, 196);
		tableHistory.setBackground(new Color(255, 222, 173));
		panelHistory.add(tableHistory);

		/**
		 * History Table Constructor
		 */
	
		DefaultTableModel model = new DefaultTableModel(new Object[][] {,},
                new String[] { "Order", "Validation date", "Delivery date", "State" }) {
            @Override
            public boolean isCellEditable(int row, int column) {

                return false;
            }
        };
		tableHistory.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Order", "Validation date", "Delivery date", "State"
			}
		));

scrollPane.setViewportView(tableHistory);
		// Buttons
		JButton btnOrdersTreated = new JButton("Orders Treated");
		btnOrdersTreated.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) tableHistory.getModel();
		        for (int j = model.getRowCount() - 1; j >= 0; j--) {
		            model.removeRow(j);
		        }
				QueryOrder queryOrder = new QueryOrder();

				ArrayList<Order> listOrderHistDatabase = null;
				try {

					listOrderHistDatabase = queryOrder.listOrderHistory("delivered");

					for (int i = 0; i < listOrderHistDatabase.size(); i++) {


						Object[] row = { listOrderHistDatabase.get(i).toString(), listOrderHistDatabase.get(i).getValidationDate(),
								listOrderHistDatabase.get(i).getDeliveryDate(), listOrderHistDatabase.get(i).getState()};

						model.addRow(row);

					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			
			
		});
		 
		btnOrdersTreated.setBackground(new Color(135, 206, 235));

		btnOrdersTreated.setBounds(385, 76, 127, 27);
		panelHistory.add(btnOrdersTreated);

		JButton btnOrdersProcessed = new JButton("Orders Processed");
		btnOrdersProcessed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) tableHistory.getModel();
		        for (int j = model.getRowCount() - 1; j >= 0; j--) {
		            model.removeRow(j);
		        }
				QueryOrder queryOrder = new QueryOrder();

				ArrayList<Order> listOrderHistDatabase = null;
				try {

					listOrderHistDatabase = queryOrder.listOrderHistory("");

					for (int i = 0; i < listOrderHistDatabase.size(); i++) {


						Object[] row = { listOrderHistDatabase.get(i).toString(), listOrderHistDatabase.get(i).getValidationDate(),
								listOrderHistDatabase.get(i).getDeliveryDate(), listOrderHistDatabase.get(i).getState()};

						model.addRow(row);

					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			
			
		});
		
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
